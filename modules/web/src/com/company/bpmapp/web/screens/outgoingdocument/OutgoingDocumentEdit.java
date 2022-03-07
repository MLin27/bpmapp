package com.company.bpmapp.web.screens.outgoingdocument;

import com.company.bpmapp.entity.Journal;
import com.company.bpmapp.entity.Nomenclature;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.BeanLocator;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.validation.RegexpValidator;
import com.haulmont.cuba.gui.screen.*;
import com.company.bpmapp.entity.OutgoingDocument;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;
import com.haulmont.cuba.security.entity.User;
import jdk.nashorn.internal.runtime.ScriptFunction;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.jsoup.select.Evaluator;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@UiController("bpmapp_OutgoingDocument.edit")
@UiDescriptor("outgoing-document-edit.xml")
@EditedEntityContainer("outgoingDocumentDc")
@LoadDataBeforeShow
public class OutgoingDocumentEdit extends StandardEditor<OutgoingDocument> {

    @Inject
    private PickerField<User> authorField;
    @Inject
    private DateField<LocalDate> creationDateField;
    @Inject
    private FileMultiUploadField multiUploadField;
    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private Notifications notifications;
    @Inject
    private DataManager dataManager;
    @Inject
    private TextField<String> registrationNumberField;
    @Inject
    private DateField<LocalDate> registrationDateField;



    @Inject
    private BeanLocator beanLocator;

    @Subscribe("nameField")
    public void onNameFieldValueChange(HasValue.ValueChangeEvent<String> event) {
        String docType = getEditedEntity().getDocumentType().getName();
        String regNum = getEditedEntity().getRegistrationNumber();
        String regDate = getEditedEntity().getRegistrationDate().toString();
        String destination = getEditedEntity().getAddressee();
        String theme = getEditedEntity().getTopic();
        getEditedEntity().setName(docType + " №" + regNum + " от " + regDate + " в " + destination + ", " + theme + ".");
    }


    @Subscribe
    protected void onInit(InitEvent event) {

        authorField.setEditable(false);                //ensures the Author, Reg.Number and dates of registration and creation are ineditable
        creationDateField.setEditable(false);


        multiUploadField.addQueueUploadCompleteListener(queueUploadCompleteEvent -> {           //creates File loader window
            for (Map.Entry<UUID, String> entry : multiUploadField.getUploadsMap().entrySet()) {
                UUID fileId = entry.getKey();
                String fileName = entry.getValue();
                FileDescriptor fd = fileUploadingAPI.getFileDescriptor(fileId, fileName);
                try {
                    fileUploadingAPI.putFileIntoStorage(fileId, fd);
                } catch (FileStorageException e) {
                    throw new RuntimeException("Error saving file to FileStorage", e);
                }
                dataManager.commit(fd);
            }
            notifications.create()
                    .withCaption("Uploaded files: " + multiUploadField.getUploadsMap().values())
                    .show();
            multiUploadField.clearUploads();
        });

        multiUploadField.addFileUploadErrorListener(queueFileUploadErrorEvent -> {
            notifications.create()
                    .withCaption("File upload error")
                    .show();
        });
    }

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {

        registrationNumberField.setEditable(false);

        if(getEditedEntity().getRegistrationDate() != null){
            registrationDateField.setEditable(false);
        }
    }



    @Subscribe("journalField")
    public void onJournalFieldValueChange(HasValue.ValueChangeEvent<Journal> event) {
        if(getEditedEntity().getJournal() != null) {
            if(registrationDateField.getValue()==null){

            }
            else{
                String macrosFormat = getEditedEntity().getJournal().getNumberFormat();    //getting date from the registration number pattern
                String pattern = "Исх - *(?<Date>((DD)?\\.)?(MM)\\.(YY)?YY) - №";
                Pattern r = Pattern.compile(pattern);
                Matcher m = r.matcher(macrosFormat);
                m.find();
                String date = m.group("Date");
                if(date.contains("DD")){
                    date = date.replace("DD", "dd");
                }
                DateTimeFormatter ALL_POSSIBLE_DATE_FORMAT = new DateTimeFormatterBuilder()
                        .appendOptional(DateTimeFormatter.ofPattern(date))
                        .toFormatter();
                String regDate = registrationDateField.getValue().format(ALL_POSSIBLE_DATE_FORMAT);
                String regNum;

                if (getEditedEntity().getJournal().getDigitAmount() != null) {
                    String formattedStr = String.format("%0" + getEditedEntity().getJournal().getDigitAmount() + "d", getEditedEntity().getOrderNum());
                    regNum = "Исх - " + regDate + " - " + formattedStr;

                } else {
                    regNum = "Исх - " + regDate + getEditedEntity().getRegistrationNumber();
                }
                getEditedEntity().setRegistrationNumber(regNum);
            }


        }



    }

    @Subscribe("causeField")
    public void onCauseFieldValueChange(HasValue.ValueChangeEvent<Nomenclature> event) {
        getEditedEntity().setRedirectedToCause(LocalDate.now());
    }







}
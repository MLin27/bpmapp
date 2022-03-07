package com.company.bpmapp.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Table(name = "BPMAPP_OUTGOING_DOCUMENT")
@Entity(name = "bpmapp_OutgoingDocument")
@NamePattern("%s|name")
public class OutgoingDocument extends StandardEntity {
    private static final long serialVersionUID = -898413787166821452L;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DOCUMENT_TYPE_ID")
    private Document documentType;

    @Column(name = "ORDER_NUM")
    private Integer orderNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOURNAL_ID")
    private Journal journal;

    @Column(name = "CONTENT")
    private String content;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAUSE_ID")
    private Nomenclature cause;

    @Column(name = "REDIRECTED_TO_CAUSE")
    private LocalDate redirectedToCause;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SIGNATORY_ID")
    private Employee signatory;

    @JoinColumn(name = "COORDINATOR_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private Employee coordinator;

    @Column(name = "TASK_START_DATE")
    private LocalDate taskStartDate;

    @Column(name = "TASK_COMPLETE_DATE")
    private LocalDate taskCompleteDate;

    @Column(name = "RESULT_")
    private String result;

    @Column(name = "COMMENT_")
    private String comment;

    @Column(name = "STATE")
    private String state;

    @OnDelete(DeletePolicy.CASCADE)
    @ManyToMany
    @JoinTable(name = "BPMAPP_OUTGOING_DOCUMENT_FILE_DESCRIPTOR_LINK",
            joinColumns = @JoinColumn(name = "OUTGOING_DOCUMENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "FILE_DESCRIPTOR_ID"))
    private List<FileDescriptor> file;

    @Column(name = "REGISTRATION_NUMBER")
    private String registrationNumber;

    @Column(name = "REGISTRATION_DATE")
    private LocalDate registrationDate;

    @NotNull
    @Column(name = "ADDRESSEE", nullable = false)
    private String addressee;

    @Column(name = "TO_WHOM")
    private String toWhom;

    @NotNull
    @Column(name = "TOPIC", nullable = false)
    private String topic;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EXECUTOR_ID")
    private Employee executor;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "AUTHOR_ID")
    private User author;

    @Lob
    @Column(name = "NOTE")
    private String note;

    @Lob
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "CREATION_DATE", nullable = false)
    private LocalDate creationDate;

    @Column(name = "EDIT_DATE")
    private LocalDate editDate;

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public LocalDate getRedirectedToCause() {
        return redirectedToCause;
    }

    public void setRedirectedToCause(LocalDate redirectedToCause) {
        this.redirectedToCause = redirectedToCause;
    }

    public Nomenclature getCause() {
        return cause;
    }

    public void setCause(Nomenclature cause) {
        this.cause = cause;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public void setFile(List<FileDescriptor> file) {
        this.file = file;
    }

    public List<FileDescriptor> getFile() {
        return file;
    }

    public Employee getSignatory() {
        return signatory;
    }

    public void setSignatory(Employee signatory) {
        this.signatory = signatory;
    }

    public DocumentState getState() {
        return state == null ? null : DocumentState.fromId(state);
    }

    public void setState(DocumentState state) {
        this.state = state == null ? null : state.getId();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public LocalDate getTaskCompleteDate() {
        return taskCompleteDate;
    }

    public void setTaskCompleteDate(LocalDate taskCompleteDate) {
        this.taskCompleteDate = taskCompleteDate;
    }

    public LocalDate getTaskStartDate() {
        return taskStartDate;
    }

    public void setTaskStartDate(LocalDate taskStartDate) {
        this.taskStartDate = taskStartDate;
    }

    public Employee getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(Employee coordinator) {
        this.coordinator = coordinator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setEditDate(LocalDate editDate) {
        this.editDate = editDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setExecutor(Employee executor) {
        this.executor = executor;
    }

    public LocalDate getEditDate() {
        return editDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public User getAuthor() {
        return author;
    }

    public Employee getExecutor() {
        return executor;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getToWhom() {
        return toWhom;
    }

    public void setToWhom(String toWhom) {
        this.toWhom = toWhom;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Document getDocumentType() {
        return documentType;
    }

    public void setDocumentType(Document documentType) {
        this.documentType = documentType;
    }
}
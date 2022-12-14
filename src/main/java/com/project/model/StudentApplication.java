package com.project.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "applications")
public class StudentApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ucas_code")
    private String ucasCode;
    @Column(name = "course_code")
    private String courseCode;
    @Column(name = "first_created")
    private String firstCreated;
    @Column(name = "entry_year")
    private String entryYear;
    @Column(name = "student_number")
    private String studentNumber;
    @Column(name = "personal_id")
    private String personalId;
    @Column(name = "status_code")
    private String statusCode;
    @Column(name = "latest_decision")
    private String latestDecision;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Column(name = "gender")
    private String gender;
    @Column(name = "fee_status")
    private String feeStatus;
    @Column(name = "correspondence_lang")
    private String correspondenceLang;
    @Column(name = "welsh_speaker")
    private String welshSpeaker;
    @Column(name = "country")
    private String country;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "email")
    private String email;
    @Column(name = "date_received")
    private String dateReceived;
    @Column(name = "contextual")
    private String contextual;
    @Column(name = "application_status")
    private List<ApplicationStatus> applicationStatus;
    @Column(name = "application_status_comments")
    private String applicationStatusComments;
    @Column(name = "fee_status_comments")
    private String feeStatusComments;
    @Column(name = "highest_qualification")
    private String highestQualification;
    @Column(name = "grades_achieved")
    private String gradesAchieved;
    @Column(name = "keep_email_sent")
    private String keepEmailSent;
    @Column(name = "personal_statement_score")
    private String personalStatementScore;
    @Column(name = "invite_to_interview")
    private String inviteToInterview;
    @Column(name = "interview_date")
    private String interviewDate;
    @Column(name = "interview_comments")
    private String interviewComments;
    @Column(name = "interview_score")
    private String interviewScore;
    @Column(name = "ftp_checked")
    private String ftpChecked;
    @Column(name = "offer_conditions")
    private String offerConditions;
    @Column(name = "non_standard_email")
    private String nonStandardEmail;
    @Column(name = "confirmation_comments")
    private String confirmationComments;
    @Column(name = "offer_email_sent")
    private String offerEmailSent;
    @Column(name = "issue_date")
    private String issueDate;
    @Column(name = "dbs_cert_number")
    private String dbsCertNumber;
    @Column(name = "fa_status")
    private String faStatus;
    @Column(name = "update_service")
    private String updateService;
    @Column(name = "essential_to_dos")
    private String essentialToDos;
    @Column(name = "enrolment_criteria_comments")
    private String enrolmentCriteriaComments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUcasCode() {
        return ucasCode;
    }

    public void setUcasCode(String ucasCode) {
        this.ucasCode = ucasCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getFirstCreated() {
        return firstCreated;
    }

    public void setFirstCreated(String firstCreated) {
        this.firstCreated = firstCreated;
    }

    public String getEntryYear() {
        return entryYear;
    }

    public void setEntryYear(String entryYear) {
        this.entryYear = entryYear;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getLatestDecision() {
        return latestDecision;
    }

    public void setLatestDecision(String latestDecision) {
        this.latestDecision = latestDecision;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFeeStatus() {
        return feeStatus;
    }

    public void setFeeStatus(String feeStatus) {
        this.feeStatus = feeStatus;
    }

    public String getCorrespondenceLang() {
        return correspondenceLang;
    }

    public void setCorrespondenceLang(String correspondenceLang) {
        this.correspondenceLang = correspondenceLang;
    }

    public String getWelshSpeaker() {
        return welshSpeaker;
    }

    public void setWelshSpeaker(String welshSpeaker) {
        this.welshSpeaker = welshSpeaker;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }

    public String getContextual() {
        return contextual;
    }

    public void setContextual(String contextual) {
        this.contextual = contextual;
    }

    public List<ApplicationStatus> getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(List<ApplicationStatus> applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getApplicationStatusComments() {
        return applicationStatusComments;
    }

    public void setApplicationStatusComments(String applicationStatusComments) {
        this.applicationStatusComments = applicationStatusComments;
    }

    public String getFeeStatusComments() {
        return feeStatusComments;
    }

    public void setFeeStatusComments(String feeStatusComments) {
        this.feeStatusComments = feeStatusComments;
    }

    public String getHighestQualification() {
        return highestQualification;
    }

    public void setHighestQualification(String highestQualification) {
        this.highestQualification = highestQualification;
    }

    public String getGradesAchieved() {
        return gradesAchieved;
    }

    public void setGradesAchieved(String gradesAchieved) {
        this.gradesAchieved = gradesAchieved;
    }

    public String getKeepEmailSent() {
        return keepEmailSent;
    }

    public void setKeepEmailSent(String keepEmailSent) {
        this.keepEmailSent = keepEmailSent;
    }

    public String getPersonalStatementScore() {
        return personalStatementScore;
    }

    public void setPersonalStatementScore(String personalStatementScore) {
        this.personalStatementScore = personalStatementScore;
    }

    public String getInviteToInterview() {
        return inviteToInterview;
    }

    public void setInviteToInterview(String inviteToInterview) {
        this.inviteToInterview = inviteToInterview;
    }

    public String getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(String interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getInterviewComments() {
        return interviewComments;
    }

    public void setInterviewComments(String interviewComments) {
        this.interviewComments = interviewComments;
    }

    public String getInterviewScore() {
        return interviewScore;
    }

    public void setInterviewScore(String interviewScore) {
        this.interviewScore = interviewScore;
    }

    public String getFtpChecked() {
        return ftpChecked;
    }

    public void setFtpChecked(String ftpChecked) {
        this.ftpChecked = ftpChecked;
    }

    public String getOfferConditions() {
        return offerConditions;
    }

    public void setOfferConditions(String offerConditions) {
        this.offerConditions = offerConditions;
    }

    public String getNonStandardEmail() {
        return nonStandardEmail;
    }

    public void setNonStandardEmail(String nonStandardEmail) {
        this.nonStandardEmail = nonStandardEmail;
    }

    public String getConfirmationComments() {
        return confirmationComments;
    }

    public void setConfirmationComments(String confirmationComments) {
        this.confirmationComments = confirmationComments;
    }

    public String getOfferEmailSent() {
        return offerEmailSent;
    }

    public void setOfferEmailSent(String offerEmailSent) {
        this.offerEmailSent = offerEmailSent;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getDbsCertNumber() {
        return dbsCertNumber;
    }

    public void setDbsCertNumber(String dbsCertNumber) {
        this.dbsCertNumber = dbsCertNumber;
    }

    public String getFaStatus() {
        return faStatus;
    }

    public void setFaStatus(String faStatus) {
        this.faStatus = faStatus;
    }

    public String getUpdateService() {
        return updateService;
    }

    public void setUpdateService(String updateService) {
        this.updateService = updateService;
    }

    public String getEssentialToDos() {
        return essentialToDos;
    }

    public void setEssentialToDos(String essentialToDos) {
        this.essentialToDos = essentialToDos;
    }

    public String getEnrolmentCriteriaComments() {
        return enrolmentCriteriaComments;
    }

    public void setEnrolmentCriteriaComments(String enrolmentCriteriaComments) {
        this.enrolmentCriteriaComments = enrolmentCriteriaComments;
    }

    public String displayApplicationStatus() {
        if (applicationStatus == null) {
            return "";
        }
        return applicationStatus.stream().map(Enum::toString).collect(Collectors.joining(","));
    }

    public List<ApplicationStatus> parseExcelApplicationStatus(String statusFromExcel) {
        List<ApplicationStatus> result = new ArrayList<>();
        ApplicationStatus[] statuses = ApplicationStatus.values();
        List<String> statusFromExcelValues = Arrays.asList(statusFromExcel.split(","));
        for (int i = 0; i < statuses.length; i++) {
            if(statusFromExcelValues.contains(statuses[i].toString())) {
                result.add(statuses[i]);
            }
            ;

//            if (Arrays.stream(statusFromExcelValues).filter(x-> x.equals(statuses[i].toString())) {
//                result.add(statuses[i]);
//            }
        }
        return result;
    }
}

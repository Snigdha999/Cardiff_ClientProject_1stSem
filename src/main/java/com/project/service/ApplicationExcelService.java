package com.project.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.project.model.Statistics;
import com.project.model.StudentApplication;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApplicationExcelService {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<StudentApplication> applicationsList;

    public ApplicationExcelService(List<StudentApplication> applicationsList) {
        this.applicationsList = applicationsList;
        this.workbook = new XSSFWorkbook();
        this.sheet = workbook.createSheet("Applications");
    }

    public ApplicationExcelService(InputStream newWorkbook) throws IOException {
        this.applicationsList = new ArrayList<>();
        this.workbook = new XSSFWorkbook(newWorkbook);
        this.sheet = workbook.getSheetAt(0);
    }

    private void writeHeaderRow() {
        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(14);
        style.setFont(font);

        Cell cell = row.createCell(0);
        cell.setCellValue("UCAS Cardiff Course");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("Cardiff Course Code");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("Record First Created");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("Entry Year");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue("Student No");
        cell.setCellStyle(style);

        cell = row.createCell(5);
        cell.setCellValue("Personal Id");
        cell.setCellStyle(style);

        cell = row.createCell(6);
        cell.setCellValue("Application Status Code");
        cell.setCellStyle(style);

        cell = row.createCell(7);
        cell.setCellValue("Lastest Decision Code (CAP)");
        cell.setCellStyle(style);

        cell = row.createCell(8);
        cell.setCellValue("First Forename");
        cell.setCellStyle(style);

        cell = row.createCell(9);
        cell.setCellValue("Surname");
        cell.setCellStyle(style);

        cell = row.createCell(10);
        cell.setCellValue("Date of Birth");
        cell.setCellStyle(style);

        cell = row.createCell(11);
        cell.setCellValue("Gender");
        cell.setCellStyle(style);

        cell = row.createCell(12);
        cell.setCellValue("Fee Status");
        cell.setCellStyle(style);

        cell = row.createCell(13);
        cell.setCellValue("Correspondence Lang Welsh?");
        cell.setCellStyle(style);

        cell = row.createCell(14);
        cell.setCellValue("Welsh Speaker Indicator");
        cell.setCellStyle(style);

        cell = row.createCell(15);
        cell.setCellValue("Country of domicile");
        cell.setCellStyle(style);

        cell = row.createCell(16);
        cell.setCellValue("Nationality");
        cell.setCellStyle(style);

        cell = row.createCell(17);
        cell.setCellValue("Home Email");
        cell.setCellStyle(style);

        cell = row.createCell(18);
        cell.setCellValue("Date received from ADMIS");
        cell.setCellStyle(style);

        cell = row.createCell(19);
        cell.setCellValue("Contextual Flag?");
        cell.setCellStyle(style);

        cell = row.createCell(20);
        cell.setCellValue("Application Status in HCARE Admissions Office");
        cell.setCellStyle(style);

        cell = row.createCell(21);
        cell.setCellValue("Application Status Comments");
        cell.setCellStyle(style);

        cell = row.createCell(22);
        cell.setCellValue("Fee Status Comments");
        cell.setCellStyle(style);

        cell = row.createCell(23);
        cell.setCellValue("Highest Level Qualification");
        cell.setCellStyle(style);

        cell = row.createCell(24);
        cell.setCellValue("Grades achieved");
        cell.setCellStyle(style);

        cell = row.createCell(25);
        cell.setCellValue("Keeping Warm Email Sent?");
        cell.setCellStyle(style);

        cell = row.createCell(26);
        cell.setCellValue("Total Personal Statement Score");
        cell.setCellStyle(style);

        cell = row.createCell(27);
        cell.setCellValue("Invite to Interview Sent?");
        cell.setCellStyle(style);

        cell = row.createCell(28);
        cell.setCellValue("Interview Date");
        cell.setCellStyle(style);

        cell = row.createCell(29);
        cell.setCellValue("Interview Invite Comments");
        cell.setCellStyle(style);

        cell = row.createCell(30);
        cell.setCellValue("Total Interview Score");
        cell.setCellStyle(style);

        cell = row.createCell(31);
        cell.setCellValue("FTP Checked");
        cell.setCellStyle(style);

        cell = row.createCell(32);
        cell.setCellValue("Offer Conditions");
        cell.setCellStyle(style);

        cell = row.createCell(33);
        cell.setCellValue("Non-standard Quals chaser email");
        cell.setCellStyle(style);

        cell = row.createCell(34);
        cell.setCellValue("Confirmation Comments");
        cell.setCellStyle(style);

        cell = row.createCell(35);
        cell.setCellValue("Offer Email Sent");
        cell.setCellStyle(style);

        cell = row.createCell(36);
        cell.setCellValue("Issue Date");
        cell.setCellStyle(style);

        cell = row.createCell(37);
        cell.setCellValue("DBS Cert Number");
        cell.setCellStyle(style);

        cell = row.createCell(38);
        cell.setCellValue("FA Status");
        cell.setCellStyle(style);

        cell = row.createCell(39);
        cell.setCellValue("Update Service");
        cell.setCellStyle(style);

        cell = row.createCell(40);
        cell.setCellValue("Essential to Dos");
        cell.setCellStyle(style);

        cell = row.createCell(41);
        cell.setCellValue("Enrolment Criteria Comments");
        cell.setCellStyle(style);
    }

    private void writeDataRows() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for(StudentApplication application: applicationsList) {
            Row row = sheet.createRow(rowCount++);

            Cell cell = row.createCell(0);
            cell.setCellValue(application.getUcasCode());
            sheet.autoSizeColumn(0);
            cell.setCellStyle(style);

            cell = row.createCell(1);
            cell.setCellValue(application.getCourseCode());
            sheet.autoSizeColumn(1);
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue(application.getFirstCreated());
            sheet.autoSizeColumn(2);
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue(application.getEntryYear());
            sheet.autoSizeColumn(3);
            cell.setCellStyle(style);

            cell = row.createCell(4);
            cell.setCellValue(application.getStudentNumber());
            sheet.autoSizeColumn(4);
            cell.setCellStyle(style);

            cell = row.createCell(5);
            cell.setCellValue(application.getPersonalId());
            sheet.autoSizeColumn(5);
            cell.setCellStyle(style);

            cell = row.createCell(6);
            cell.setCellValue(application.getStatusCode());
            sheet.autoSizeColumn(6);
            cell.setCellStyle(style);

            cell = row.createCell(7);
            cell.setCellValue(application.getLatestDecision());
            sheet.autoSizeColumn(7);
            cell.setCellStyle(style);

            cell = row.createCell(8);
            cell.setCellValue(application.getName());
            sheet.autoSizeColumn(8);
            cell.setCellStyle(style);

            cell = row.createCell(9);
            cell.setCellValue(application.getSurname());
            sheet.autoSizeColumn(9);
            cell.setCellStyle(style);

            cell = row.createCell(10);
            cell.setCellValue(application.getDateOfBirth());
            sheet.autoSizeColumn(10);
            cell.setCellStyle(style);

            cell = row.createCell(11);
            cell.setCellValue(application.getGender());
            sheet.autoSizeColumn(11);
            cell.setCellStyle(style);

            cell = row.createCell(12);
            cell.setCellValue(application.getFeeStatus());
            sheet.autoSizeColumn(12);
            cell.setCellStyle(style);

            cell = row.createCell(13);
            cell.setCellValue(application.getCorrespondenceLang());
            sheet.autoSizeColumn(13);
            cell.setCellStyle(style);

            cell = row.createCell(14);
            cell.setCellValue(application.getWelshSpeaker());
            sheet.autoSizeColumn(14);
            cell.setCellStyle(style);

            cell = row.createCell(15);
            cell.setCellValue(application.getCountry());
            sheet.autoSizeColumn(15);
            cell.setCellStyle(style);

            cell = row.createCell(16);
            cell.setCellValue(application.getNationality());
            sheet.autoSizeColumn(16);
            cell.setCellStyle(style);

            cell = row.createCell(17);
            cell.setCellValue(application.getEmail());
            sheet.autoSizeColumn(17);
            cell.setCellStyle(style);

            cell = row.createCell(18);
            cell.setCellValue(application.getDateReceived());
            sheet.autoSizeColumn(18);
            cell.setCellStyle(style);

            cell = row.createCell(19);
            cell.setCellValue(application.getContextual());
            sheet.autoSizeColumn(19);
            cell.setCellStyle(style);

            cell = row.createCell(20);
            cell.setCellValue(application.displayApplicationStatus());
            sheet.autoSizeColumn(20);
            cell.setCellStyle(style);

            cell = row.createCell(21);
            cell.setCellValue(application.getApplicationStatusComments());
            sheet.autoSizeColumn(21);
            cell.setCellStyle(style);

            cell = row.createCell(22);
            cell.setCellValue(application.getFeeStatus());
            sheet.autoSizeColumn(22);
            cell.setCellStyle(style);

            cell = row.createCell(23);
            cell.setCellValue(application.getHighestQualification());
            sheet.autoSizeColumn(23);
            cell.setCellStyle(style);

            cell = row.createCell(24);
            cell.setCellValue(application.getGradesAchieved());
            sheet.autoSizeColumn(24);
            cell.setCellStyle(style);

            cell = row.createCell(25);
            cell.setCellValue(application.getKeepEmailSent());
            sheet.autoSizeColumn(25);
            cell.setCellStyle(style);

            cell = row.createCell(26);
            cell.setCellValue(application.getPersonalStatementScore());
            sheet.autoSizeColumn(26);
            cell.setCellStyle(style);

            cell = row.createCell(27);
            cell.setCellValue(application.getInviteToInterview());
            sheet.autoSizeColumn(27);
            cell.setCellStyle(style);

            cell = row.createCell(28);
            cell.setCellValue(application.getInterviewDate());
            sheet.autoSizeColumn(28);
            cell.setCellStyle(style);

            cell = row.createCell(29);
            cell.setCellValue(application.getInterviewComments());
            sheet.autoSizeColumn(29);
            cell.setCellStyle(style);

            cell = row.createCell(30);
            cell.setCellValue(application.getInterviewScore());
            sheet.autoSizeColumn(30);
            cell.setCellStyle(style);

            cell = row.createCell(31);
            cell.setCellValue(application.getFtpChecked());
            sheet.autoSizeColumn(31);
            cell.setCellStyle(style);

            cell = row.createCell(32);
            cell.setCellValue(application.getOfferConditions());
            sheet.autoSizeColumn(32);
            cell.setCellStyle(style);

            cell = row.createCell(33);
            cell.setCellValue(application.getNonStandardEmail());
            sheet.autoSizeColumn(33);
            cell.setCellStyle(style);

            cell = row.createCell(34);
            cell.setCellValue(application.getConfirmationComments());
            sheet.autoSizeColumn(34);
            cell.setCellStyle(style);

            cell = row.createCell(35);
            cell.setCellValue(application.getOfferEmailSent());
            sheet.autoSizeColumn(35);
            cell.setCellStyle(style);

            cell = row.createCell(36);
            cell.setCellValue(application.getIssueDate());
            sheet.autoSizeColumn(36);
            cell.setCellStyle(style);

            cell = row.createCell(37);
            cell.setCellValue(application.getDbsCertNumber());
            sheet.autoSizeColumn(37);
            cell.setCellStyle(style);

            cell = row.createCell(38);
            cell.setCellValue(application.getFaStatus());
            sheet.autoSizeColumn(38);
            cell.setCellStyle(style);

            cell = row.createCell(39);
            cell.setCellValue(application.getUpdateService());
            sheet.autoSizeColumn(39);
            cell.setCellStyle(style);

            cell = row.createCell(40);
            cell.setCellValue(application.getEssentialToDos());
            sheet.autoSizeColumn(40);
            cell.setCellStyle(style);

            cell = row.createCell(41);
            cell.setCellValue(application.getEnrolmentCriteriaComments());
            sheet.autoSizeColumn(41);
            cell.setCellStyle(style);
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderRow();
        writeDataRows();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    public List<StudentApplication> importExcel() throws IOException {
        for (int index = 0; index < sheet.getPhysicalNumberOfRows(); index++) {
            if (index > 0) {
                StudentApplication application = new StudentApplication();
                XSSFRow row = sheet.getRow(index);

                application.setUcasCode(row.getCell(0).getStringCellValue());

                application.setCourseCode(row.getCell(1).getStringCellValue());

                application.setFirstCreated(row.getCell(2).getStringCellValue());

                application.setEntryYear(row.getCell(3).getStringCellValue());

                application.setStudentNumber(row.getCell(4).getStringCellValue());

                application.setPersonalId(row.getCell(5).getStringCellValue());

                application.setStatusCode(row.getCell(6).getStringCellValue());

                application.setLatestDecision(row.getCell(7).getStringCellValue());

                application.setName(row.getCell(8).getStringCellValue());

                application.setSurname(row.getCell(9).getStringCellValue());

                application.setDateOfBirth(row.getCell(10).getStringCellValue());

                application.setGender(row.getCell(11).getStringCellValue());

                application.setFeeStatus(row.getCell(12).getStringCellValue());

                application.setCorrespondenceLang(row.getCell(13).getStringCellValue());

                application.setWelshSpeaker(row.getCell(14).getStringCellValue());

                application.setCountry(row.getCell(15).getStringCellValue());

                application.setNationality(row.getCell(16).getStringCellValue());

                application.setEmail(row.getCell(17).getStringCellValue());

                application.setDateReceived(row.getCell(18).getStringCellValue());

                application.setContextual(row.getCell(19).getStringCellValue());

                application.setApplicationStatus(application.parseExcelApplicationStatus(row.getCell(20).getStringCellValue()));

                application.setApplicationStatusComments(row.getCell(21).getStringCellValue());

                application.setFeeStatus(row.getCell(22).getStringCellValue());

                application.setHighestQualification(row.getCell(23).getStringCellValue());

                application.setGradesAchieved(row.getCell(24).getStringCellValue());

                application.setKeepEmailSent(row.getCell(25).getStringCellValue());

                application.setPersonalStatementScore(row.getCell(26).getStringCellValue());

                application.setInviteToInterview(row.getCell(27).getStringCellValue());

                application.setInterviewDate(row.getCell(28).getStringCellValue());

                application.setInterviewComments(row.getCell(29).getStringCellValue());

                application.setInterviewScore(row.getCell(30).getStringCellValue());

                application.setFtpChecked(row.getCell(31).getStringCellValue());

                application.setOfferConditions(row.getCell(32).getStringCellValue());

                application.setNonStandardEmail(row.getCell(33).getStringCellValue());

                application.setConfirmationComments(row.getCell(34).getStringCellValue());

                application.setOfferEmailSent(row.getCell(35).getStringCellValue());

                application.setIssueDate(row.getCell(36).getStringCellValue());

                application.setDbsCertNumber(row.getCell(37).getStringCellValue());

                application.setFaStatus(row.getCell(38).getStringCellValue());

                application.setUpdateService(row.getCell(39).getStringCellValue());

                application.setEssentialToDos(row.getCell(40).getStringCellValue());

                application.setEnrolmentCriteriaComments(row.getCell(41).getStringCellValue());

                applicationsList.add(application);
            }
        }
        return applicationsList;
    }
}

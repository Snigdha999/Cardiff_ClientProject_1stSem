package com.project.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.project.model.Statistics;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class StatisticsExcelService {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Statistics> statisticsList;

    public StatisticsExcelService(List<Statistics> statisticsList) {
        this.statisticsList = statisticsList;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Statistics");
    }

    public StatisticsExcelService(InputStream newWorkbook) throws IOException {
        this.statisticsList = new ArrayList<>();
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
        cell.setCellValue("Study Year");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("Funded Places");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("Offers");
        cell.setCellStyle(style);
    }

    private void writeDataRows() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for(Statistics statisticsItem: statisticsList) {
            Row row = sheet.createRow(rowCount++);

            Cell cell = row.createCell(0);
            cell.setCellValue(statisticsItem.getStudyYear());
            sheet.autoSizeColumn(0);
            cell.setCellStyle(style);

            cell = row.createCell(1);
            cell.setCellValue(statisticsItem.getPlaces());
            sheet.autoSizeColumn(1);
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue(statisticsItem.getOffers());
            sheet.autoSizeColumn(2);
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

    public String getStringValue(int index, XSSFRow row) {
        Cell cell = row.getCell(index);
        if(cell == null) {
            return "";
        }
        return cell.toString();
    }

    public int getIntValue(int index, XSSFRow row) {
        Cell cell = row.getCell(index);
        if(cell == null) {
            return 0;
        }
        return (int) cell.getNumericCellValue();
    }

    public List<Statistics> importExcel() throws IOException {
        for (int index = 0; index < sheet.getPhysicalNumberOfRows(); index++) {
            if (index > 0) {
                Statistics statistics = new Statistics();
                XSSFRow row = sheet.getRow(index);

                if (row != null && row.getCell(0).toString() != "") {
                    statistics.setStudyYear(getStringValue(0, row));
                    statistics.setPlaces(getIntValue(1, row));
                    statistics.setOffers(getIntValue(2, row));
                    statisticsList.add(statistics);
                }
            }
        }
        return statisticsList;
    }
}

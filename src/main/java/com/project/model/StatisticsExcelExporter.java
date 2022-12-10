package com.project.model;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class StatisticsExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Statistics> statistics;

    public StatisticsExcelExporter(List<Statistics> statistics) {
        this.statistics = statistics;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Statistics");
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

        for(Statistics statisticsItem: statistics) {
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
}

package com.example.reactive_app.service;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class ExcelReportService {

    public XSSFWorkbook generateExcelReport(int numberOfSheets) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(numberOfSheets);
        List<Future<XSSFSheet>> futures = new ArrayList<>();

        for (int i = 0; i < numberOfSheets; i++) {
            int sheetIndex = i;
            Callable<XSSFSheet> task = () -> generateSheet(sheetIndex);
            futures.add(executor.submit(task));
        }

        // Create a workbook and add generated sheets
        XSSFWorkbook workbook = new XSSFWorkbook();
        for (int i = 0; i < numberOfSheets; i++) {
            Future<XSSFSheet> future = futures.get(i);
            XSSFSheet sheet = future.get(); // This will block until the sheet is ready
            workbook.createSheet(sheet.getSheetName());
        }

        // Shutdown the executor service
        executor.shutdown();

        return workbook;
    }

    // Dummy method to simulate sheet generation
    private XSSFSheet generateSheet(int index) throws InterruptedException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet " + (index + 1));
        // Simulate time-consuming task
        Thread.sleep(1000);
        System.out.println("Generated " + sheet.getSheetName());
        return sheet;
    }
}

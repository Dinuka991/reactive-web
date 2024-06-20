package com.example.reactive_app.controller;

import com.example.reactive_app.service.ExcelReportService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;

@RestController
public class ExcelReportController {

    @Autowired
    private ExcelReportService excelReportService;

    @GetMapping("/generate-report")
    public ResponseEntity<byte[]> generateReport(@RequestParam int sheets) {
        try {
            XSSFWorkbook workbook = excelReportService.generateExcelReport(sheets);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            workbook.write(bos);
            workbook.close();

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=report.xlsx");

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(bos.toByteArray());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}

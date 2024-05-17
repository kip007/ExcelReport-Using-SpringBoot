package com.example.Report.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor

public class ExcelReport {

    private final ExcelGenerator excelGenerator;

    public void generateExcelReport() {
        try {
            excelGenerator.generateExcelReport();
            System.out.println("Excel report generated successfully");
        } catch (IOException e) {
            System.err.println("Error generating Excel report: " + e.getMessage());
        }
    }
}

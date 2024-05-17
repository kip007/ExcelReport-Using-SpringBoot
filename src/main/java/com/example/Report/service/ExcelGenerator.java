package com.example.Report.service;
import com.example.Report.Repo.Repository;
import com.example.Report.model.Employee;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExcelGenerator {
    private final Repository repository;
    public void generateExcelReport() throws IOException {

        String filePath = "C:/Users/intern/Desktop/Victor 47/employees_Data.xlsx";
        // fetch employees
        List<Employee> employees = repository.FirstReport();
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Employees");

            // Create header row
            Row headerRow = sheet.createRow(0);
            String[] headers = {"Employee ID", "First Name", "Last Name", "Email", "Hire Date", "Salary"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            // Populate data
            int rowNum = 1;
            for (Employee employee : employees) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(employee.getEMPLOYEE_ID());
                row.createCell(1).setCellValue(employee.getFIRST_NAME());
                row.createCell(2).setCellValue(employee.getLAST_NAME());
                row.createCell(3).setCellValue(employee.getEMAIL());
                row.createCell(4).setCellValue(employee.getHIRE_DATE()); // Convert to string or format as needed
                row.createCell(5).setCellValue(employee.getSALARY());
            }

            // Write to file
            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                workbook.write(outputStream);
            }
        }
    }
}

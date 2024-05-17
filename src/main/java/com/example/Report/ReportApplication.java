package com.example.Report;

import com.example.Report.service.ExcelReport;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;
import java.io.IOException;

@SpringBootApplication
public class ReportApplication {

	private static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		// Capture the application context when starting the Spring application
		context = SpringApplication.run(ReportApplication.class, args);


		// Retrieve the GenerateExcelService bean from the context
		ExcelReport excelReport = context.getBean(ExcelReport.class);

		// Call the service method
		excelReport.generateExcelReport();

		// No need to close the context manually, Spring Boot handles it
		context.close();



	}


}

package com.finance.report;

import com.finance.report.model.*;
import com.finance.report.service.PDFGeneratorService;
import com.finance.report.service.VelocityTemplateService;

import java.util.Arrays;
import java.util.Date;

public class Application {
	public static void main(String[] args) {
		// Sample Data
		User user = new User("U12345", "John Doe", "john.doe@email.com", "123 Main St, NY", "123456789");
		Transaction t1 = new Transaction(new Date(), "Deposit", 500.00, 1500.00);
		Transaction t2 = new Transaction(new Date(), "Withdrawal", -200.00, 1300.00);
		AccountSummary summary = new AccountSummary(500.00, 200.00, 1300.00);
		BankDetails bank = new BankDetails("XYZ Bank", "456 Bank Ave, NY");

		// Generate Velocity HTML
		VelocityTemplateService velocityService = new VelocityTemplateService();
		String htmlContent = velocityService.generateStatement(user, Arrays.asList(t1, t2), summary, bank);

		// Generate PDF
		PDFGeneratorService pdfService = new PDFGeneratorService();
		pdfService.generatePDF(htmlContent, "Monthly_Statement.pdf");

		System.out.println("PDF Generated: Monthly_Statement.pdf");
	}
}

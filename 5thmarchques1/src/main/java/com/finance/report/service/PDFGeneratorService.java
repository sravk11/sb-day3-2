package com.finance.report.service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.StringReader;

import com.lowagie.text.html.simpleparser.HTMLWorker;

public class PDFGeneratorService {
    public void generatePDF(String htmlContent, String filePath) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            HTMLWorker htmlWorker = new HTMLWorker(document);
            htmlWorker.parse(new StringReader(htmlContent));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}


package com.java.spring.service.pdf;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PDFConverterService {

    public String getPdfPath(String path) {
        return null;
    }

    public static String PDFtoCVS(String path, String fileName) throws IOException {
        StringBuilder pathToFile = new StringBuilder();
        pathToFile.append(path);
        pathToFile.append(fileName);

        PdfReader pdfReader = new PdfReader(pathToFile.toString());
        int pages = pdfReader.getNumberOfPages();

        pathToFile.replace(pathToFile.length() - 3, pathToFile.length(), "csv");
        FileWriter csvWriter = new FileWriter(pathToFile.toString());

        for (int i = 1; i <= pages; i++) {
            String context = PdfTextExtractor.getTextFromPage(pdfReader, i);
            String[] splitContext = context.split("\n");
            boolean isTitle = true;

            for (int j = 0; j < splitContext.length; j++) {
                if (isTitle) {
                    isTitle = false;
                    continue;
                }
                csvWriter.append(splitContext[j].replaceAll(" ", ";"));
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        }
        return pathToFile.toString();
    }
}

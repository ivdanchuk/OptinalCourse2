package com.java.spring.controller;

import com.java.spring.service.pdf.PDFConverterService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/upload")
public class PdfUploadController {

    @RequestMapping(method = RequestMethod.POST, produces = "text/csv")
    public ResponseEntity handleFileUpload(@RequestParam("file-pdf") MultipartFile multipartFile) throws IOException {
        String name = multipartFile.getOriginalFilename();
        byte[] bytes = multipartFile.getBytes();

        File targetFile = new File("src/main/resources/targetPdf.pdf");
        OutputStream outStream = new FileOutputStream(targetFile);
        outStream.write(bytes);
        IOUtils.closeQuietly(outStream);
        String pathToCSV = PDFConverterService.PDFtoCVS("src/main/resources/", "targetPdf.pdf");

        File file = new File(pathToCSV);
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=" + name + ".csv")
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(new FileSystemResource(file));
    }
}

package com.vozh.art.dataservice.service;


import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.canvas.parser.listener.IPdfTextLocation;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.element.Text;
import lombok.RequiredArgsConstructor;

import com.itextpdf.kernel.pdf.*;
import com.itextpdf.kernel.pdf.layer.PdfLayer;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.Property;


import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PdfService {
    private static final String PERSONAL_DATA_LAYER = "PersonalData";


    public void createPDFWithLayer(String outputPath, String name, String surname) throws IOException {
        try (PdfDocument pdfDoc = new PdfDocument(new PdfWriter(outputPath))) {
            Document document = new Document(pdfDoc);

            // Create layer for personal data
            PdfLayer personalDataLayer = new PdfLayer(PERSONAL_DATA_LAYER, pdfDoc);
            personalDataLayer.setOn(true);

            // Create PdfCanvas for the layer
            PdfCanvas canvas = new PdfCanvas(pdfDoc.addNewPage());
            canvas.beginLayer(personalDataLayer);

            // Add personal data
            document.add(new Paragraph("--- Personal Data Start ---"));
            document.add(new Paragraph("Name: " + name));
            document.add(new Paragraph("Surname: " + surname));
            document.add(new Paragraph("--- Personal Data End ---"));

            canvas.endLayer();

            Text title = new Text("try 2 delete me").setFontSize(15);
            document.add(new Paragraph(title));

            // Add other content
            document.add(new Paragraph("Main document content"));
        }
    }

}


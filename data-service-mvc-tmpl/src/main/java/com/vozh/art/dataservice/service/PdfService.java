package com.vozh.art.dataservice.service;

import com.itextpdf.kernel.pdf.*;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.layer.PdfLayer;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import lombok.RequiredArgsConstructor;

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

            // Create PdfCanvas for the page
            PdfCanvas pdfCanvas = new PdfCanvas(pdfDoc.addNewPage());

            // Add content to personal data layer
            pdfCanvas.beginLayer(personalDataLayer);
            document.add(new Paragraph("Name: " + name));
            document.add(new Paragraph("Surname: " + surname));
            pdfCanvas.endLayer();

            // Add other content (not in the personal data layer)
            document.add(new Paragraph("Main document content"));

            document.close();
        }
    }
    public void removePersonalDataLayer(String inputPath, String outputPath) throws IOException {
        try (PdfDocument pdfDoc = new PdfDocument(
                new PdfReader(inputPath),
                new PdfWriter(outputPath))) {

            // Get the OCG (Optional Content Group) properties
            PdfDictionary catalog = pdfDoc.getCatalog().getPdfObject();
            PdfDictionary ocProperties = catalog.getAsDictionary(PdfName.OCProperties);

            if (ocProperties != null) {
                // Get the OCGs (Optional Content Groups)
                PdfArray ocgs = ocProperties.getAsArray(PdfName.OCGs);
                if (ocgs != null) {
                    // Find and disable the personal data layer
                    for (int i = 0; i < ocgs.size(); i++) {
                        PdfDictionary ocg = ocgs.getAsDictionary(i);
                        if (PERSONAL_DATA_LAYER.equals(ocg.getAsString(PdfName.Name).toString())) {
                            // Set the layer visibility to false
                            PdfDictionary usage = new PdfDictionary();
                            usage.put(PdfName.Print, new PdfName("OFF"));
                            usage.put(PdfName.View, new PdfName("OFF"));
                            ocg.put(PdfName.Usage, usage);
                            break;
                        }
                    }
                }
            }

            pdfDoc.close();
        }
    }
}
//    public void createPDFWithRemovableBlock(String outputPath, String name, String surname) throws IOException {
//        try (PDDocument document = new PDDocument()) {
//            PDPage page = new PDPage();
//            document.addPage(page);
//
//            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
//                // Start marked content for personal data
//                contentStream.beginMarkedContent(COSName.getPDFName(PERSONAL_DATA_TAG));
//
//                // Add personal data
//                contentStream.beginText();
//                contentStream.newLineAtOffset(100, 700);
//                contentStream.setFont(PDType1Font.HELVETICA, 12);
//                contentStream.showText("Name: " + name);
//                contentStream.newLineAtOffset(0, -15);
//                contentStream.showText("Surname: " + surname);
//                contentStream.endText();
//
//                // End marked content
//                contentStream.endMarkedContent();
//
//
//
//
//                // Add other content
//                contentStream.beginText();
//                contentStream.newLineAtOffset(100, 650);
//                contentStream.showText("This is the main content of the document");
//                contentStream.endText();
//            }
//
//            document.save(outputPath);
//        }
//    }

//    public void removePersonalDataBlock(String inputPath, String outputPath) throws IOException {
//        try (PDDocument document = new PDDocument(new File(inputPath))) {
//            // Implementation to remove marked content with tag PERSONAL_DATA_TAG
//            // This would involve parsing the content stream and removing marked content sections
//
//            document.save(outputPath);
//        }
//    }
//}

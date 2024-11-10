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

    public void removePersonalDataLayer(String inputPath, String outputPath) throws IOException {
        CompositeCleanupStrategy strategy = new CompositeCleanupStrategy();
        strategy.add(new RegexBasedCleanupStrategy("Baeldung").setRedactionColor(ColorConstants.WHITE));
        PdfCleaner.autoSweepCleanUp(pdfDocument, strategy);

        for (IPdfTextLocation location : strategy.getResultantLocations()) {
            PdfPage page = pdfDocument.getPage(location.getPageNumber() + 1);
            PdfCanvas pdfCanvas = new PdfCanvas(page.newContentStreamAfter(), page.getResources(), page.getDocument());
            Canvas canvas = new Canvas(pdfCanvas, location.getRectangle());
            canvas.add(new Paragraph("HIDDEN").setFontSize(8)
                    .setMarginTop(0f));
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

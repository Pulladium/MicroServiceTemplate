package com.vozh.art.dataservice.controller;


import com.vozh.art.dataservice.service.PdfService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dev")
@RequiredArgsConstructor
@Slf4j
public class DevController {
    private final PdfService pdfService;



    @GetMapping("/createPdf")
    public String createPdf() {
        try {
            pdfService.createPDFWithLayer("pdfs/layeroutput.pdf", "John", "Doe");
            return "PDF created";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }

    @GetMapping("/removeLayerPD")
    public String removeLayerPD() {
        try {
            pdfService.removePersonalDataLayer("pdfs/layeroutput.pdf", "pdfs/outwithoutlayer.pdf");
            return "Layer removed";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }
}

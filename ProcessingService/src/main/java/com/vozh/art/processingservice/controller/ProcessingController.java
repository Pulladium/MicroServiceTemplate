package com.vozh.art.processingservice.controller;

import com.vozh.art.common.dto.DataItemRequest;
import com.vozh.art.processingservice.service.ProcessingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/processing")
public class ProcessingController {
    private final ProcessingService processingService;


    @PostMapping("/data-items")
    public ResponseEntity<String> createDataItem(@Valid @RequestBody DataItemRequest request) {
        processingService.processDataItem(request);
        return ResponseEntity.ok("Successfully sent for saving");
    }
}

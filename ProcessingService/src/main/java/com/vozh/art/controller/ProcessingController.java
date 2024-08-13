package com.vozh.art.controller;

import com.vozh.art.dto.DataItemRequest;
import com.vozh.art.dto.request.TaskRequest;
import com.vozh.art.dto.response.TaskResponse;
import com.vozh.art.service.ProcessingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

package com.vozh.art.dataservice.controller;


import com.vozh.art.common.dto.DataItemRequest;
import com.vozh.art.common.dto.DataItemResponse;
import com.vozh.art.dataservice.service.DataItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data-items")
@RequiredArgsConstructor
public class   DataItemController {
    private final DataItemService dataItemService;


//    @PostMapping
//    public ResponseEntity<DataItemResponse> createDataItem(@RequestBody DataItemRequest request) {
//        return ResponseEntity.ok(dataItemService.createDataItem(request));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<DataItemResponse> getDataItem(@PathVariable Long id) {
//        return ResponseEntity.ok(dataItemService.getDataItem(id));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<DataItemResponse>> getAllDataItems() {
//        return ResponseEntity.ok(dataItemService.getAllDataItems());
//    }

}

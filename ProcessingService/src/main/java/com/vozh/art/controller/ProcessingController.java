package com.vozh.art.controller;

import com.vozh.art.dto.request.TaskRequest;
import com.vozh.art.dto.response.TaskResponse;
import com.vozh.art.service.ProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tasks")
public class ProcessingController {

    private final ProcessingService processingService;

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@RequestBody TaskRequest taskRequest) {
        return ResponseEntity.ok(processingService.createTask(taskRequest));
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getActiveTasks() {
        return ResponseEntity.ok(processingService.getActiveTasks());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<TaskResponse> updateTaskStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(processingService.updateTaskStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelTask(@PathVariable Long id) {
        processingService.cancelTask(id);
        return ResponseEntity.noContent().build();
    }
}

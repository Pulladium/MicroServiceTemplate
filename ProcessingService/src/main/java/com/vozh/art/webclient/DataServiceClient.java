package com.vozh.art.webclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "data-service")
public interface DataServiceClient {
    @GetMapping("/api/data-items")
    List<DataItemResponse> getDataItems();

    @GetMapping("/api/data-items/{id}")
    DataItemResponse getDataItem(@PathVariable Long id);

    @PostMapping("/api/data-items")
    DataItemResponse addDataItem(@RequestBody DataItemRequest request);

    @PutMapping("/api/data-items/{id}")
    DataItemResponse updateDataItem(@PathVariable Long id, @RequestBody DataItemRequest request);

    @DeleteMapping("/api/data-items/{id}")
    void deleteDataItem(@PathVariable Long id);
}

package com.vozh.art.webclient;

import com.vozh.art.dto.DataItemRequest;
import com.vozh.art.dto.DataItemResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "data-service")
public interface DataServiceClient {
    @PostMapping("/api/data-items")
    DataItemResponse addDataItem(@RequestBody DataItemRequest request);
}

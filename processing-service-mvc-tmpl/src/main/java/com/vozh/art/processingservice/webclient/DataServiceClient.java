package com.vozh.art.processingservice.webclient;

import com.vozh.art.common.dto.DataItemRequest;
import com.vozh.art.common.dto.DataItemResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "data-service", url = "data-service.default.svc.cluster.local")
public interface DataServiceClient {
    @PostMapping("/api/data-items")
    DataItemResponse addDataItem(@RequestBody DataItemRequest request);
}

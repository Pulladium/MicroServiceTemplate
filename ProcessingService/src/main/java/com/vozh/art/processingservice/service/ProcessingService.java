package com.vozh.art.processingservice.service;

import com.vozh.art.common.dto.DataItemRequest;
import com.vozh.art.processingservice.webclient.DataServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class ProcessingService {
    private final DataServiceClient dataServiceClient;

    public void processDataItem(DataItemRequest request) {
        // Additional business logic or validations can be added here
        dataServiceClient.addDataItem(request);
    }
}

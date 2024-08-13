package com.vozh.art.service;

import com.vozh.art.dto.DataItemRequest;
import com.vozh.art.webclient.DataServiceClient;
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

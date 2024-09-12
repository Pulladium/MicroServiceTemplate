package com.vozh.art.processingservice.service;

import com.vozh.art.common.dto.DataItemRequest;
import com.vozh.art.common.event.DataSentEvent;
import com.vozh.art.processingservice.webclient.DataServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class ProcessingService {
    private final DataServiceClient dataServiceClient;
    private final KafkaTemplate<String, DataSentEvent> dataSentEventKafkaTemplate;

    public void processDataItem(DataItemRequest request) {
        // Additional business logic or validations can be added here
//        dataServiceClient.addDataItem(request);

        //Send message to kafka
        DataSentEvent dataSentEvent = new DataSentEvent(request.name(), request.value());
        dataSentEventKafkaTemplate.send("data-topic", dataSentEvent);
    }
}

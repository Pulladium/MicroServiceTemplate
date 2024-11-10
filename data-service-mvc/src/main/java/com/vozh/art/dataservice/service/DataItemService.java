package com.vozh.art.dataservice.service;

import com.vozh.art.dataservice.entity.DataItem;
import com.vozh.art.common.dto.DataItemRequest;
import com.vozh.art.common.dto.DataItemResponse;
import com.vozh.art.dataservice.repository.DataItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DataItemService {
    private final DataItemRepository dataItemRepository;

//    public DataItemResponse createDataItem(DataItemRequest request) {
//        DataItem dataItem = new DataItem();
//        dataItem.setName(request.name());
//        dataItem.setValue(request.value());
//        DataItem savedItem = dataItemRepository.save(dataItem);
//        return mapToResponse(savedItem);
//    }

//    public DataItemResponse getDataItem(Long id) {
//        return dataItemRepository.findById(id)
//                .map(this::mapToResponse)
//                .orElseThrow(() -> new RuntimeException("DataItem not found"));
//    }
//
//    public List<DataItemResponse> getAllDataItems() {
//        return dataItemRepository.findAll().stream()
//                .map(this::mapToResponse)
//                .collect(Collectors.toList());
//    }
//    private DataItemResponse mapToResponse(DataItem dataItem) {
//        return new DataItemResponse(dataItem.getId(), dataItem.getName(), dataItem.getValue());
//    }
}

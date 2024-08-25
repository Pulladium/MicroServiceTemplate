package com.vozh.art.processingservice.dto.response;

import java.time.LocalDateTime;

public record TaskResponse(
        Long id,
        String description,
        String status,
        LocalDateTime createdAt
) {
}

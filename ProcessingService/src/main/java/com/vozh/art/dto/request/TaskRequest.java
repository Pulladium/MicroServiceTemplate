package com.vozh.art.dto.request;

import java.time.LocalDateTime;

public record TaskRequest(
        String description,
        String status,
        LocalDateTime createdAt
) {
}

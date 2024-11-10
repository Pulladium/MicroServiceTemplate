package com.vozh.art.dataservice.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParticipantResponse {
    private Long participantId;
    private String name;
    private String surname;
    private String email;
    private LocalDateTime assignedAt;
}

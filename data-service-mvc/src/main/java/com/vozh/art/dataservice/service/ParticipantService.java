package com.vozh.art.dataservice.service;

import com.vozh.art.dataservice.dto.response.ParticipantResponse;
import com.vozh.art.dataservice.entity.Participant;
import org.springframework.stereotype.Service;

@Service
public class ParticipantService {
    public static ParticipantResponse mapToResponse(Participant participant) {
        return ParticipantResponse.builder()
                .participantId(participant.getId())
                .name(participant.getName())
                .surname(participant.getSurname())
                .email(participant.getEmail())
                .build();
    }
}

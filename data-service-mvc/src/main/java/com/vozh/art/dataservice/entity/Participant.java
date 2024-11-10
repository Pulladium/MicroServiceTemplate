package com.vozh.art.dataservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Participant extends BaseEntity<Long>{
    @OneToMany(mappedBy = "participant")
    private Set<CertificateParticipant> certificateParticipants;

    private String name;
    private String surname;
    private String email;
}

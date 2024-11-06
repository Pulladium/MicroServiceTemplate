package com.vozh.art.dataservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CertificateParticipant extends BaseEntity<Long>{

    @ManyToOne
    private Certificate certificate;

    @ManyToOne
    private Participant participant;
}

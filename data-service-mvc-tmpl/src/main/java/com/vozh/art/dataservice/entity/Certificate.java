package com.vozh.art.dataservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Certificate extends BaseEntity<Long> {

    private String description;
    private String issuer;
    private String signedDocumentUUID;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "certificate")
    private Set<CertificateParticipant> certificateParticipants;


//    todo maybe add here method to get SingedDoc from signedDocumentUUID

//    @OneToMany(mappedBy = "certificate", cascade = CascadeType.ALL)
//    private Set<CertificateParticipant> certificateParticipants = new HashSet<>();
}

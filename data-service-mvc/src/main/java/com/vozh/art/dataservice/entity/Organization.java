package com.vozh.art.dataservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Organization extends BaseEntity<Long>{

    @ManyToMany(mappedBy = "issuers")
    private Set<Certificate> certificates;

    @Column(nullable = false)
    private String name;

    private String address;

    private String contactInfo;

    private OrganizationStatus status;

    private String mantainerKeycloakUUID;

    public enum OrganizationStatus{
        APPROVED,
        REJECTED,
        AWAITING
    }
}

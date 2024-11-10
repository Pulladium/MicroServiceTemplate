package com.vozh.art.dataservice.dto.response;

import com.vozh.art.dataservice.entity.Organization;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrganizationResponse {
    private Long organizationId;

//    todo from where called this field
//    private Set<CertificateResponse> certificates;

    private String name;
    private String address;
    private String contactInfo;
    private Organization.OrganizationStatus status;
    private String maintainerKeycloakUUID;
}

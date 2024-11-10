package com.vozh.art.dataservice.service;

import com.vozh.art.dataservice.dto.response.CertificateResponse;
import com.vozh.art.dataservice.entity.Certificate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(properties = {
        "spring.cloud.discovery.enabled=false",
        "spring.cloud.service-registry.auto-registration.enabled=false"
})
@TestPropertySource(locations = "classpath:application.properties")

public class MappingTest {

    @Autowired
    CertificateService certificateService;

    @Test
    public void testEmptyCertMapping() {
        CertificateResponse result = CertificateService.mapToResponse(Certificate.builder()
                .id(1L)
                .description("description")
                .build());

        assertTrue(result.getCertificateId() == 1L);
        assertTrue(result.getDescription().equals("description"));
        assertTrue(result.getIssuers().isEmpty());
        assertTrue(result.getCategories().isEmpty());
    }
}

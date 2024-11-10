package com.vozh.art.dataservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(properties = {
        "spring.cloud.discovery.enabled=false",
        "spring.cloud.service-registry.auto-registration.enabled=false"
})
@TestPropertySource(locations = "classpath:application.properties")
public class CertificateTest {
    @Autowired
    private CertificateService certificateService;

}

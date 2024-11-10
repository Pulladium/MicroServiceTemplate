package com.vozh.art.dataservice;

import com.vozh.art.dataservice.entity.*;
import com.vozh.art.dataservice.repository.CategoryRepository;
import com.vozh.art.dataservice.repository.CertificateRepository;
import com.vozh.art.dataservice.repository.DataItemRepository;
import com.vozh.art.dataservice.repository.OrganizationRepository;
import com.vozh.art.dataservice.service.PdfService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.vozh.art.dataservice.entity.DataItem;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class DataServiceApplication {
    public static void main(String[] args) {

        SpringApplication.run(DataServiceApplication.class);
    }

    @Bean
    public CommandLineRunner createCertificate(CertificateRepository certificateRepository, CategoryRepository categoryRepository, OrganizationRepository organizationRepository){

        return args -> {
            Category category = Category.builder()
                    .description("Spring")
                    .build();

            Category subCategory = Category.builder()
                    .description("Spring boot")
                    .parentCategory(category)
                    .build();

            categoryRepository.saveAll(List.of(category,subCategory));

            Organization organization = Organization.builder()
                    .name("NOT CTU")
                    .address("Terronska 2228")
                    .mantainerKeycloakUUID("Not seeted")
                    .status(Organization.OrganizationStatus.APPROVED)
                    .contactInfo("blablabla.der@gmail.com")
                    .build();

            organizationRepository.save(organization);



            Certificate certificate = Certificate.builder()
                    .description("Java Persistence qualification certificate")
                    .categories(Set.of(subCategory))
                    .issuers(Set.of(organization))
                    .signedDocumentUUID(Set.of(new SingedDocRef("NOT YET")))
                    .build();

            log.info("Cert id : {}", certificate.getId());
            Certificate savedCert = certificateRepository.save(certificate);
            log.info("Cert id after save : {}", savedCert.getId());
        };
    }

//    @Bean
//    public CommandLineRunner createData(DataItemRepository dataItemRepository) {
//        return args -> {
//            List<DataItem> items = Arrays.asList(
//                    DataItem.builder().name("Phone pro max").value("45").build(),
//                    DataItem.builder().name("Phone 12").value("12").build(),
//                    DataItem.builder().name("Phone 32").value("2").build()
//            );
//            dataItemRepository.saveAll(items);
//        };
//    }



}
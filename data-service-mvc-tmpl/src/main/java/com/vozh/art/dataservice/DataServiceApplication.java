package com.vozh.art.dataservice;

import com.vozh.art.dataservice.entity.DataItem;
import com.vozh.art.dataservice.repository.DataItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.vozh.art.dataservice.entity.DataItem;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class DataServiceApplication {
    public static void main(String[] args) {

        SpringApplication.run(DataServiceApplication.class);
    }

    @Bean
    public CommandLineRunner createData(DataItemRepository dataItemRepository) {
        return args -> {
            List<DataItem> items = Arrays.asList(
                    DataItem.builder().name("Phone pro max").value("45").build(),
                    DataItem.builder().name("Phone 12").value("12").build(),
                    DataItem.builder().name("Phone 32").value("2").build()
            );
            dataItemRepository.saveAll(items);
        };
    }
}
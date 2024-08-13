package com.vozh.art.dataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DataServiceApplication {
    public static void main(String[] args) {

        SpringApplication.run(DataServiceApplication.class);
    }
}
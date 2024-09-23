package com.vozh.art.processingservice;

import io.dekorate.docker.annotation.DockerBuild;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
//@EnableDiscoveryClient
@SpringBootApplication
@EnableDiscoveryClient
@DockerBuild(name = "processing-service-mvc-tmpl", version = "1.0-SNAPSHOT")
public class ProcessingApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProcessingApplication.class);
    }
}
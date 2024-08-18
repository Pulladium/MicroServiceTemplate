package com.vozh.art.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("processing-service", r ->
                        r.path("/api/processing/**")
                        .uri("lb://processing-service"))
//                .route("service2", r -> r.path("/service2/**")
//                        .filters(f -> f.stripPrefix(1))
//                        .uri("lb://SERVICE-NAME2"))
                .build();
    }
}
package com.vozh.art.dataservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class DataItem extends BaseEntity<Long> {


    @Column(name = "item_amount",nullable = false)
    private String value;
}
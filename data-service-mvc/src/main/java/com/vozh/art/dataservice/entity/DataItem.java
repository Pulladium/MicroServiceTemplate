package com.vozh.art.dataservice.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DataItem extends BaseEntity<Long> {


    @Column(name = "item_amount",nullable = false)
    private String value;
}
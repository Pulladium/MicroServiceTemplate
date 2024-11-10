package com.vozh.art.dataservice.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Builder
@SuperBuilder
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity<T> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private T id;


}

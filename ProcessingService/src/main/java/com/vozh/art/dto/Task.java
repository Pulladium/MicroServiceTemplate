package com.vozh.art.dto;



import lombok.*;


import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Task {
    private Long id;
    private String description;
    private String status;
    private LocalDateTime createdAt;


}

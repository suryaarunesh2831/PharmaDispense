package com.example.pharmacy.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DispenseRecordDTOResponse {
    private Long drugId;
    private String drugName;
    private int quantity;

    private LocalDate date;
}

package com.example.pharmacy.dto.response;

import lombok.*;

import java.time.LocalDate;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DispenseRecordDTOLogResponse {
    private Long drugId;
    private String drugName;
    private int quantity;
    private LocalDate date;
}

package com.example.pharmacy.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DispenseRecordDTOResponse {
    Long prescriptionId;
    Long dispensedQuantity;
    LocalDate dispensedDate;
    int userId;
}

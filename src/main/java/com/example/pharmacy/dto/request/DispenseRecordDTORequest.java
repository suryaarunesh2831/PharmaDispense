package com.example.pharmacy.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DispenseRecordDTORequest {
    Long prescriptionId;
    Long dispensedQuantity;
    LocalDate dispensedDate;
    int userId;
}

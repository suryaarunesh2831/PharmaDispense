package com.example.pharmacy.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionDTORequest {
    Long prescriptionId;
    Long patientId;
    LocalDateTime createdDate;
    String status;
    List<Long> itemIds;
}

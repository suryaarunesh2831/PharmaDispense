package com.example.pharmacy.dto;

import com.example.pharmacy.model.User;
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
    User user;
    List<Long> itemIds;
}

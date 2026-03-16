package com.example.pharmacy.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PharmacyReportDTORequest {
    private Long reportId;
    private String scope;
    private String metrics;
    private LocalDateTime generatedDate;
}

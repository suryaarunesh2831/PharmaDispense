package com.example.pharmacy.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PharmacyReportDTOResponse {
    private Long reportId;
    private String scope;
    private String metrics;
    private LocalDateTime generatedDate;
}

package com.example.pharmacy.repository;

import com.example.pharmacy.model.PharmacyReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface pharmacyReportRepository extends JpaRepository<PharmacyReport,Integer> {
}

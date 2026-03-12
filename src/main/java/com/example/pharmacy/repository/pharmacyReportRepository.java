package com.example.pharmacy.repository;

import com.example.pharmacy.model.PharmacyReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface pharmacyReportRepository extends JpaRepository<PharmacyReport,Integer> {
}

package com.example.pharmacy.repository;

import com.example.pharmacy.model.DispenseRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.*;

@Repository
public interface DispenseRepository extends JpaRepository<DispenseRecord,Long> {
    Optional<DispenseRecord> findByDispensedDate(LocalDate dispensedDate);
}

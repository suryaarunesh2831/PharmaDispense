package com.example.pharmacy.repository;

import com.example.pharmacy.model.Prescription;
import com.example.pharmacy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {
}

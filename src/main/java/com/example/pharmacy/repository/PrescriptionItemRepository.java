package com.example.pharmacy.repository;

import com.example.pharmacy.model.PrescriptionItem;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionItemRepository extends JpaRepository<PrescriptionItem,Long> {
}

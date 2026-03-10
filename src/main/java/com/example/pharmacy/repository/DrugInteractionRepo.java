package com.example.pharmacy.repository;

import com.example.pharmacy.model.DrugInteraction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugInteractionRepo extends JpaRepository<DrugInteraction,Long> {
}

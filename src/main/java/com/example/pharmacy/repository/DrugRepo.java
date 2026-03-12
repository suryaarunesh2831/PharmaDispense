package com.example.pharmacy.repository;

import com.example.pharmacy.model.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepo extends JpaRepository<Drug,Long> {
}

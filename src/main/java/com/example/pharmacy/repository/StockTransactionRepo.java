package com.example.pharmacy.repository;

import com.example.pharmacy.model.StockTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockTransactionRepo extends JpaRepository<StockTransaction,Long> {
}

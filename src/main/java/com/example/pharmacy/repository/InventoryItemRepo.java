package com.example.pharmacy.repository;

import com.example.pharmacy.dto.response.InventoryResponseDto;
import com.example.pharmacy.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InventoryItemRepo extends JpaRepository<InventoryItem,Long> {

    @Query("SELECT new com.example.pharmacy.dto.response.InventoryResponseDto(ii.InventoryID,ii.drugobj.drugId,ii.BatchNumber,ii.ExpiryDate,ii.QuantityonHand,ii.ReorderLevel)FROM InventoryItem ii WHERE ii.QuantityonHand < 30")
    List<InventoryResponseDto> findItemsNeedingReorder();

    @Query("select ii.QuantityonHand from InventoryItem ii where ii.drugobj.drugId = :drugid")
    Optional<Long> finddrugquantitybasedonId(@Param("drugid") Long drugid);

    @Query("UPDATE InventoryItem i SET i.QuantityonHand = i.QuantityonHand - :qty WHERE i.InventoryID = :id AND i.QuantityonHand >= :qty")
    void decrementQuantity(@Param("required")Long required);

    @Query("UPDATE InventoryItem i SET i.QuantityonHand = i.QuantityonHand + :qty WHERE i.InventoryID = :id AND i.QuantityonHand >= :qty")
    void incrementQuantity(@Param("required")Long required);



}

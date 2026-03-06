package com.example.pharmacy.service;

import com.example.pharmacy.repository.*;
import com.example.pharmacy.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MarService {

    @Autowired
    marRepository marRepo;

    public MAR create(MAR mar){
        System.out.print(mar);
        return marRepo.save(mar);
    }

    public List<MAR> read(){
        return marRepo.findAll();
    }

    public void deleteById(int id){
        marRepo.deleteById(id);
    }
}

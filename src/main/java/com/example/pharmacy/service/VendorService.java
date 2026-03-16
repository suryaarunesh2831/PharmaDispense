package com.example.pharmacy.service;

import com.example.pharmacy.model.Vendor;
import com.example.pharmacy.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService{
    @Autowired
    public VendorRepository vendorRepository;

    public Vendor createVendor(Vendor vendor){
        return vendorRepository.save(vendor);
    }

    public Vendor updateVendor(Long id, Vendor updatedVendor){
        Vendor existingVendor = getVendorById(id);

        existingVendor.setName(updatedVendor.getName());
        existingVendor.setContactInfo(updatedVendor.getContactInfo());
        existingVendor.setRating(updatedVendor.getRating());
        existingVendor.setStatus(updatedVendor.getStatus());

        return vendorRepository.save(existingVendor);
    }

    public List<Vendor> getAllVendors(){
        return vendorRepository.findAll();
    }
    public Vendor getVendorById(Long id){
        return vendorRepository.findById(id).orElseThrow(()-> new RuntimeException("Vendor not found with id:" + id));
    }

    public void deleteAllVendor(){
        vendorRepository.deleteAll();
    }

    public void deleteVendorById(Long id){
        vendorRepository.deleteById(id);
    }

}

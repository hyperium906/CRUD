package com.example.spring_boot.service;

import com.example.spring_boot.model.DTO;
import java.util.List;
import java.util.Optional;


public interface ProductService {
    List<DTO> getAllPhoneProducts();
    Optional<DTO> getPhoneProductById(Long id);
    DTO savePhoneProduct(DTO phoneProductDTO);
    DTO updatePhoneProduct(Long id, DTO phoneProductDTO);
    void deletePhoneProduct(Long id);
}

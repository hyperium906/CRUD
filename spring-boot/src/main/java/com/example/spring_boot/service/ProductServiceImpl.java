package com.example.spring_boot.service;
import com.example.spring_boot.model.PhoneProduct;
import com.example.spring_boot.model.DTO;
import com.example.spring_boot.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public List<DTO> getAllPhoneProducts() {
        return List.of();
    }

    @Override
    public Optional<DTO> getPhoneProductById(Long id) {
        return Optional.empty();
    }

    @Override
    public DTO savePhoneProduct(DTO phoneProductDTO) {
        return null;
    }

    @Override
    public DTO updatePhoneProduct(Long id, DTO phoneProductDTO) {
        return null;
    }

    @Override
    public void deletePhoneProduct(Long id) {

    }
}
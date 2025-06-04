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

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<DTO> getAllPhoneProducts() {
        return productRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DTO> getPhoneProductById(Long id) {
        return productRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public DTO savePhoneProduct(DTO phoneProductDTO) {
        PhoneProduct product = convertToEntity(phoneProductDTO);
        PhoneProduct savedProduct = productRepository.save(product);
        return convertToDTO(savedProduct);
    }

    @Override
    public DTO updatePhoneProduct(Long id, DTO phoneProductDTO) {
        PhoneProduct product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setPhoneBrand(phoneProductDTO.phoneBrand());
        product.setPhoneModel(phoneProductDTO.phoneModel());
        product.setColor(phoneProductDTO.color());
        product.setPrice(phoneProductDTO.price());
        product.setStorage(phoneProductDTO.storage());
        PhoneProduct updatedProduct = productRepository.save(product);
        return convertToDTO(updatedProduct);
    }

    @Override
    public void deletePhoneProduct(Long id) {
        productRepository.deleteById(id);
    }

    private DTO convertToDTO(PhoneProduct product) {
        return new DTO(
                product.getId(),
                product.getPhoneBrand(),
                product.getPhoneModel(),
                product.getColor(),
                product.getPrice(),
                product.getStorage()
        );
    }

    private PhoneProduct convertToEntity(DTO dto) {
        PhoneProduct product = new PhoneProduct();
        product.setId(dto.id()); // optional during create
        product.setPhoneBrand(dto.phoneBrand());
        product.setPhoneModel(dto.phoneModel());
        product.setColor(dto.color());
        product.setPrice(dto.price());
        product.setStorage(dto.storage());
        return product;
    }
}
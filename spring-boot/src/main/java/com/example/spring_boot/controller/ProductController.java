package com.example.spring_boot.controller;


import com.example.spring_boot.model.DTO;
import com.example.spring_boot.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<DTO> getAllProducts() {
        return productService.getAllPhoneProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTO> getProductById(@PathVariable Long id) {
        Optional<DTO> product = productService.getPhoneProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public DTO createProduct(@RequestBody DTO productDTO) {
        return productService.savePhoneProduct(productDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTO> updateProduct(@PathVariable Long id, @RequestBody DTO productDTO) {
        try {
            DTO updatedProduct = productService.updatePhoneProduct(id, productDTO);
            return ResponseEntity.ok(updatedProduct);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deletePhoneProduct(id);
        return ResponseEntity.noContent().build();
    }
}
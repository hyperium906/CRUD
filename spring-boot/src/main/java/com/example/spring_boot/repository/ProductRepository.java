package com.example.spring_boot.repository;

import com.example.spring_boot.model.PhoneProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<PhoneProduct, Long> {
}

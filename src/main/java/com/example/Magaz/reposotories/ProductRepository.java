package com.example.Magaz.reposotories;

import com.example.Magaz.entities.Magazine;
import com.example.Magaz.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}

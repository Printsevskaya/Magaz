package com.example.Magaz.reposotories;

import com.example.Magaz.entities.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MagazineRepository extends JpaRepository<Magazine, UUID> {
}

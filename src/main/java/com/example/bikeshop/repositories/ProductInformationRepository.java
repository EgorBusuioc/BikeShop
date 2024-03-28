package com.example.bikeshop.repositories;

import com.example.bikeshop.models.ProductInformation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author EgorBusuioc
 * 27.03.2024
 */
public interface ProductInformationRepository extends JpaRepository<ProductInformation, Integer> {
}

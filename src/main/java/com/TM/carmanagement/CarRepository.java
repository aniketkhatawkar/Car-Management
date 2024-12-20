package com.TM.carmanagement;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    Page<Car> findByNameContainingOrModelContainingOrYearOrColorContainingOrFuelTypeContaining(
        String name, String model, Integer year, String color, String fuelType, Pageable pageable);

	List<Car> findByNameContainingOrModelContainingOrYear(Integer year, String name, String model);
}

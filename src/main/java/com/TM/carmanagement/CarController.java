package com.TM.carmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    // Create a new car
    @PostMapping
    public ResponseEntity<Car> addCar(@Valid @RequestBody Car car) {
        return ResponseEntity.ok(carService.addCar(car));
    }

    // Read all cars with filtering by name, model, or year
    @GetMapping
    public ResponseEntity<List<Car>> getAllCars(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String model,
        @RequestParam(required = false) Integer year
    ) {
        return ResponseEntity.ok(carService.getAllCars(name, model, year));
    }

    // Read car by ID
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        return carService.getCarById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update car details
    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @Valid @RequestBody Car updatedCar) {
        try {
            return ResponseEntity.ok(carService.updateCar(id, updatedCar));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete car
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/search")
    public ResponseEntity<Page<Car>> searchCars(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) String fuelType,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        return ResponseEntity.ok(carService.searchCars(name, model, year, color, fuelType, page, size, sortBy, direction));
    }
}

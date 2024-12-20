package com.TM.carmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    // Create a new car
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    // Get all cars or filter by name, model, or year
    public List<Car> getAllCars(String name, String model, Integer year) {
        if (name == null && model == null && year == null) {
            return carRepository.findAll();
        }
        return carRepository.findByNameContainingOrModelContainingOrYear(year, name, model);
    }

    // Get car by ID
    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    // Update car details
    public Car updateCar(Long id, Car updatedCar) {
        Optional<Car> existingCar = carRepository.findById(id);
        if (existingCar.isPresent()) {
            updatedCar.setId(id);
            return carRepository.save(updatedCar);
        } else {
            throw new RuntimeException("Car not found");
        }
    }

    // Delete car
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
    
    public Page<Car> searchCars(String name, String model, Integer year, String color, String fuelType, int page, int size, String sortBy, String direction) {
        Pageable pageable = PageRequest.of(page, size, direction.equals("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending());
        return carRepository.findByNameContainingOrModelContainingOrYearOrColorContainingOrFuelTypeContaining(name, model, year, color, fuelType, pageable);
    }
}

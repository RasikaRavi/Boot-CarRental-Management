package com.example.carrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.carrental.entity.Car;

public interface CarRepo extends JpaRepository<Car,Integer>{

}

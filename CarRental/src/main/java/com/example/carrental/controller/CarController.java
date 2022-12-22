package com.example.carrental.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.carrental.entity.Car;
import com.example.carrental.repository.CarRepo;

@Controller
public class CarController {
	
	@Autowired
	CarRepo repo;
	
	@RequestMapping("/saveCar")
	@ResponseBody
	public Optional<Car> addCars(@RequestParam int carId,String carModel, String carNo)
	{
		Car car = new Car();
		car.setCarId(carId);
		car.setCarModel(carModel);
		car.setCarNo(carNo);
		car.setStatus("available");
		repo.save(car);
		System.out.println("Item Saved");
		
		return repo.findById(carId);
	}
	
	@RequestMapping("/deleteCar")
	@ResponseBody
	public Optional<Car> deleteCarId(@RequestParam int id)
	{
		repo.deleteById(id);
		return repo.findById(id);
	}
	

	@RequestMapping("/getCars")
	@ResponseBody
	public List<Car> displayCars()
	{
		return repo.findAll();
	}
	
	@RequestMapping("/getCar")
	@ResponseBody
	public Optional<Car> displayById(@RequestParam int carId)
	{
		return repo.findById(carId);
	}
}

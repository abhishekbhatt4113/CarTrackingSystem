package io.cartrackingsystem.service;

import io.cartrackingsystem.entity.Car;
import io.cartrackingsystem.entity.Reading;
import io.cartrackingsystem.exception.BadRequestException;
import io.cartrackingsystem.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImplement implements CarService {

    @Autowired
    private CarRepository repository;

    @org.springframework.transaction.annotation.Transactional
    public List<Car> load(List<Car> car) {
        return repository.load(car);
    }

    @org.springframework.transaction.annotation.Transactional
    public Reading create(Reading reading) {
        Car car=repository.findOne(reading.getVin());
        if(car==null){
            throw new BadRequestException("First please enter Car details with vin number "+reading.getVin());
        }
        return repository.create(reading);
    }
}

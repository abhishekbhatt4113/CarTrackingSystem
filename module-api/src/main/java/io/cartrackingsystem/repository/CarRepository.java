package io.cartrackingsystem.repository;

import io.cartrackingsystem.entity.Car;
import io.cartrackingsystem.entity.Reading;

import java.util.List;

public interface CarRepository {

    public List<Car> load(List<Car> car);

    public Reading create(Reading reading);

    public Car findOne(String vin);
}

package io.cartrackingsystem.service;

import io.cartrackingsystem.entity.Car;
import io.cartrackingsystem.entity.Reading;

import java.util.List;

public interface CarService {

    public List<Car> load(List<Car> car);

    public Reading create(Reading reading);

}

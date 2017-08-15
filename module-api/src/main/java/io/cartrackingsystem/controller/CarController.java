package io.cartrackingsystem.controller;

import io.cartrackingsystem.entity.Car;
import io.cartrackingsystem.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
public class CarController {

    @Autowired
    private CarService services;

    @RequestMapping(method = RequestMethod.PUT, value = "/vehicles", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Car> load(@RequestBody List<Car> car){
        return services.load(car);
    }

}

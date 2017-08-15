package io.cartrackingsystem.controller;

import io.cartrackingsystem.entity.Reading;
import io.cartrackingsystem.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
public class CarReadingController {

    @Autowired
    private CarService services;

    @RequestMapping(method = RequestMethod.POST,value = "/readings",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                                                                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading create(@RequestBody Reading reading){
        return services.create(reading);
    }

}

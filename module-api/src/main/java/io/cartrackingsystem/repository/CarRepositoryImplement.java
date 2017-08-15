package io.cartrackingsystem.repository;

import io.cartrackingsystem.entity.Car;
import io.cartrackingsystem.entity.Reading;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CarRepositoryImplement implements CarRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Car> load(List<Car> car) {
        for(Car a:car){
            entityManager.merge(a);
        }
        return car;
    }

    public Reading create(Reading reading) {
        Car car = findOne(reading.getVin());
        if(car!=null && reading.getTimestamp().after(car.getLastServiceDate())){
            car.setLastServiceDate(reading.getTimestamp());
        }
        entityManager.persist(reading);
        return reading;
    }

    public Car findOne(String vin) {
        return entityManager.find(Car.class, vin);
    }
}

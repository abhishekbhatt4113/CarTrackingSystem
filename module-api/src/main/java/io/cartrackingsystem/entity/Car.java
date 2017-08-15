package io.cartrackingsystem.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Component
@Entity
public class
Car {

    @Id
    @Column(columnDefinition = "VARCHAR(80)")
    private String vin;
    @Column(columnDefinition = "VARCHAR(50)")
    private String make;
    @Column(columnDefinition = "VARCHAR(50)")
    private String model;
    private int year;
    @Column(name = "Red_line_RPM")
    private int redlineRpm;
    @Column(name = "Max_Fuel_Volume")
    private float maxFuelVolume;
    @Column(name = "Last_Service_Date")
    private Date lastServiceDate;

    @OneToMany(targetEntity = Reading.class, cascade = CascadeType.ALL,mappedBy = "vin")
    private List<Reading> reading;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(int redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public float getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(float maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public Date getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Date lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    public List<Reading> getReading() {
        return reading;
    }

    public void setReading(List<Reading> reading) {
        this.reading = reading;
    }

    @Override
    public String toString() {
        return "Car{" +
                "vin='" + vin + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", redlineRpm='" + redlineRpm + '\'' +
                ", maxFuelVolume='" + maxFuelVolume + '\'' +
                ", lastServiceDate='" + lastServiceDate + '\'' +
                ", reading=" + reading +
                '}';
    }
}

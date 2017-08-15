package io.cartrackingsystem.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Component
@Entity
public class Reading {

    @Id
    @Column(columnDefinition = "VARCHAR(80)")
    private String readId;
    @Column(columnDefinition = "VARCHAR(80)")
    private String vin;

    private float latitude;
    private float longitude;
    private Date timestamp;
    private int fuelVolume;
    private int speed;
    private int engineHp;
    @Column(columnDefinition = "VARCHAR(10)",name = "Engine_Light_ON")
    private String checkEngineLightOn;
    @Column(columnDefinition = "VARCHAR(10)",name = "Engine_Coolant_Low")
    private String engineCoolantLow;
    @Column(columnDefinition = "VARCHAR(10)",name = "Cruise_Control_ON")
    private String cruiseControlOn;
    private int engineRpm;


    @Embedded
    private Tires tires;


    public Reading() {
        this.readId = UUID.randomUUID().toString();
    }

    public String getReadId() {
        return readId;
    }

    public void setReadId(String readId) {
        this.readId = readId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(int fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(int engineHp) {
        this.engineHp = engineHp;
    }

    public String getCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(String checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public String getEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(String engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public String getCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(String cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public int getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(int engineRpm) {
        this.engineRpm = engineRpm;
    }

    public Tires getTires() {
        return tires;
    }

    public void setTires(Tires tires) {
        this.tires = tires;
    }

    @Override
    public String toString() {
        return "Reading{" +
                "readId='" + readId + '\'' +
                ", vin='" + vin + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", fuelVolume='" + fuelVolume + '\'' +
                ", speed='" + speed + '\'' +
                ", engineHp='" + engineHp + '\'' +
                ", checkEngineLightOn='" + checkEngineLightOn + '\'' +
                ", engineCoolantLow='" + engineCoolantLow + '\'' +
                ", cruiseControlOn='" + cruiseControlOn + '\'' +
                ", engineRpm='" + engineRpm + '\'' +
                ", tires=" + tires +
                '}';
    }
}

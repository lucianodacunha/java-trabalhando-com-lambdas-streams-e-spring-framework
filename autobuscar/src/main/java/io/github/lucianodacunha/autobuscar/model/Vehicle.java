package io.github.lucianodacunha.autobuscar.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Vehicle {

    private final Integer type;
    private final String value;
    private final String brand;
    private final String model;
    private final Integer year;
    private final String fuel;
    private final String fipeCode;
    private final String monthRef;
    private final String fuelCod;


    public Vehicle(VehicleData vehicleData) {
        this.type = vehicleData.type();
        this.value = vehicleData.value();
        this.brand = vehicleData.brand();
        this.model = vehicleData.model();
        this.year = vehicleData.year();
        this.fuel = vehicleData.fuel();
        this.fipeCode = vehicleData.fipeCode();
        this.monthRef = vehicleData.monthRef();
        this.fuelCod = vehicleData.fuelCode();
    }

    public Integer getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public String getFuel() {
        return fuel;
    }

    public String getFipeCode() {
        return fipeCode;
    }

    public String getMonthRef() {
        return monthRef;
    }

    public String getFuelCod() {
        return fuelCod;
    }

    @Override
    public String toString() {
        return String.format("%-50s %-4s %15s %8s", model, year, value, fuel);
    }
}

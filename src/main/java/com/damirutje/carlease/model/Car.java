package com.damirutje.carlease.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "CAR")
public class Car {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name = "ID")
    private long id;
    
    @Column(nullable = false, name = "MAKE")
    private String make;
    
    @Column(nullable = false, name = "MODEL")
    private String model;
    
    @Column(name = "VERSION")
    private String version;
    
    @Column(nullable = false, name = "NUMBER_OF_DOORS")
    private short numberOfDoors;

    /*@Column(nullable = false)
    private short numberOfSeats;*/

    @Column(name = "EMISSION_CO2")
    private int emissionCO2;
    
    @Column(nullable = false, name = "GROSS_PRICE")
    private BigDecimal grossPrice;

    @Column(nullable = false, name = "NETT_PRICE")
    private BigDecimal nettPrice;

    /*@Column(nullable = false)
    private short transmission;

    @Column(nullable = false)
    private short kW; */

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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public short getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(short numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    /*public short getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(short numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }*/

    public int getEmissionCO2() {
        return emissionCO2;
    }

    public void setEmissionCO2(int emissionCO2) {
        this.emissionCO2 = emissionCO2;
    }

    public BigDecimal getGrossPrice() {
        return grossPrice;
    }

    public void setGrossPrice(BigDecimal grossPrice) {
        this.grossPrice = grossPrice;
    }

    public BigDecimal getNettPrice() {
        return nettPrice;
    }

    public void setNettPrice(BigDecimal nettPrice) {
        this.nettPrice = nettPrice;
    }

    /*public short getTransmission() {
        return transmission;
    }

    public void setTransmission(short transmission) {
        this.transmission = transmission;
    }

    public short getkW() {
        return kW;
    }

    public void setkW(short kW) {
        this.kW = kW;
    }*/

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((make == null) ? 0 : make.hashCode());
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + ((version == null) ? 0 : version.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Car other = (Car) obj;
        if (id != other.id)
            return false;
        if (make == null) {
            if (other.make != null)
                return false;
        } else if (!make.equals(other.make))
            return false;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        if (version == null) {
            if (other.version != null)
                return false;
        } else if (!version.equals(other.version))
            return false;
        return true;
    }
}

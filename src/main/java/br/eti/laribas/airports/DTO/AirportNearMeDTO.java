/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.laribas.airports.DTO;

import br.eti.laribas.airports.projections.AirportNearMeProjection;


/**
 *
 * @author sesideva
 */
public class AirportNearMeDTO {
    
    private long id; 
    private String name;
    private String city;
    private String iataCode;
    private double latitude;
    private double longitude;
    private double altitude;
    private double distanciaKM;

    public AirportNearMeDTO() {
    }

    /**
 * Construtor
 * Recebe uma interface AirportNearMeProjection como parâmetro
 * e mapeia para um AirportNearMeDTO objeto.
 * @param airportProjection
 */
public AirportNearMeDTO(AirportNearMeProjection airportProjection) {
    this.id = airportProjection.getId();
    this.name = airportProjection.getName();
    this.city = airportProjection.getCity();
    this.iataCode = airportProjection.getIataCode();
    this.latitude = airportProjection.getLatitude();
    this.longitude = airportProjection.getLongitude();
    this.altitude = airportProjection.getAltitude();
    this.distanciaKM = airportProjection.getDistanciaKM();
}

     public long getId() {
     return id;
     }

    public AirportNearMeDTO(long id, String name, String city, String iataCode, double latitude, double longitude, double altitude, double distanciaKM) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.iataCode = iataCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.distanciaKM = distanciaKM;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getIataCode() {
        return iataCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public double getDistanciaKM() {
        return distanciaKM;
    }

     
}

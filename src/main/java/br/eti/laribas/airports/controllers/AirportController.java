/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.laribas.airports.controllers;

import br.eti.laribas.airports.DTO.AirportMinDTO;
import br.eti.laribas.airports.DTO.AirportNearMeDTO;
import br.eti.laribas.airports.entities.Airport;
import br.eti.laribas.airports.services.AirportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sesideva
 */
@RestController
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping("/airport")
    public List<Airport> findAll() {
        List<Airport> result = airportService.findAll();
        return result;

    }

    @GetMapping("/city/{cityName}")
    public ResponseEntity<List<Airport>> findByCityIgnoreCase(@PathVariable String cityName) {
        List<Airport> result = airportService.findByCity(cityName);

        if (result.isEmpty()) {
            //ops... lista vazia :p
            //notFound devolve 404
            return ResponseEntity.notFound().build();

        } else {
            // eba! tem dados :D
            // ok devolve 200 uwu
            return ResponseEntity.ok(result);

        }
    }

    @GetMapping("/country/{countryName}")
    public ResponseEntity<List<AirportMinDTO>> findByCountryIgnoreCase(@PathVariable String countryName) {
       
        List<AirportMinDTO> result = airportService.findByCountry(countryName);

        if (result.isEmpty()) {
            //ops... lista vazia :p
            //notFound devolve 404
            return ResponseEntity.notFound().build();

        } else {
            // eba! tem dados :D
            // ok devolve 200 uwu
            return ResponseEntity.ok(result);

        }
    }
    
    @GetMapping("/iatacode/{iataCode}")
    public ResponseEntity<Airport> findByIataCode(@PathVariable String iataCode) {
    Airport result = airportService.findByIataCode(iataCode);

    if (result == null) {
        // Ops.. Aeroporto vazio...
        // notFound devolve 404
        return ResponseEntity.notFound().build();
    } else {
        // Eba! Tem dados!
        // ok devolve 200
        return ResponseEntity.ok(result);
    }
}

    
    @GetMapping("/nearme")
    public ResponseEntity<List<AirportNearMeDTO>> findNearMe(
    @RequestParam double latitude,
            @RequestParam double longitude ) {
    List<AirportNearMeDTO> result = airportService.findNearMe(latitude, longitude) ;
    
    if (result.isEmpty()) {
        //ops ... lista vazia...
        //not found devolve 404
        return ResponseEntity.notFound().build();
    } else {
    //eba !! tem dados!!
    // ok devolve 200
    return ResponseEntity.ok(result);
    }
    }
}


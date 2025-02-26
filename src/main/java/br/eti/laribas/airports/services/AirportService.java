package br.eti.laribas.airports.services;

import br.eti.laribas.airports.entities.Airport;
import br.eti.laribas.airports.repositories.AirportRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sesideva
 */
@Service
public class AirportService {
    
    @Autowired
    private AirportRepository airportRepository;
    
    public List<Airport> findAll() {
     
        List<Airport> result = airportRepository.findAll();
        return result;
    }
    
    
    public List<Airport> findByCity(String city) {
    List<Airport> result = airportRepository.findByCityIgnoreCase(city);
    return result;
    }
    
}

package br.com.luigipietro.citiesapi.resources;

import br.com.luigipietro.citiesapi.entities.Country;
import br.com.luigipietro.citiesapi.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResource {

    @Autowired
    private CountryRepository repository;

    @GetMapping
    public Page<Country> countries (Pageable page){
        return repository.findAll(page);
    }
//    public List<Country> countries(){
//        return repository.findAll();
//    }

    @GetMapping("/{id}")
    public Optional<Country> getOne(@PathVariable Long id){
        return repository.findById(id);
    }
}
/*
http://localhost:8088/countries?page=0&size=10&sort=name,asc
*/

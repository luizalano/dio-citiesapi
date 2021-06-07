package br.com.luigipietro.citiesapi.resources;

import br.com.luigipietro.citiesapi.entities.State;
import br.com.luigipietro.citiesapi.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateResource {

    @Autowired
    private StateRepository repository;

    @GetMapping
    public List<State> states(){
        return repository.findAll();
    }
}

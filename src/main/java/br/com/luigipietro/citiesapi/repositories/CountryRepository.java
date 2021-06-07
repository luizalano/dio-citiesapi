package br.com.luigipietro.citiesapi.repositories;

import br.com.luigipietro.citiesapi.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}


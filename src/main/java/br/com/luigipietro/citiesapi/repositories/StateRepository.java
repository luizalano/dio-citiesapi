package br.com.luigipietro.citiesapi.repositories;

import br.com.luigipietro.citiesapi.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
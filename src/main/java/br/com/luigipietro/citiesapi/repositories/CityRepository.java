package br.com.luigipietro.citiesapi.repositories;

import br.com.luigipietro.citiesapi.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityRepository extends JpaRepository<City, Long> {

    @Query(value = "SELECT ((SELECT lat_lon FROM cidade WHERE id=?1) <@>" +
            " (SELECT lat_lon FROM cidade WHERE id=?2)) as distance", nativeQuery = true)
    Double distanceByPoints(Long city1, Long city2);

    @Query(value = "SELECT earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance", nativeQuery = true)
    Double distanceByCube(double x, double y, double x1, double y1);

    @Query(value = "SELECT ((SELECT lat_lon FROM cidade WHERE UPPER(nome)=UPPER(?1) LIMIT 1) <@> " +
            "(SELECT lat_lon FROM cidade WHERE UPPER(nome)=UPPER(?2) LIMIT 1)) as distance", nativeQuery = true)
    Double distanceByPointsNames(String name1, String name2);

    @Query(value = "SELECT earth_distance(" +
            "ll_to_earth((SELECT latitude FROM cidade WHERE UPPER(nome)=UPPER(?1) LIMIT 1),(SELECT longitude FROM cidade WHERE UPPER(nome)=UPPER(?1) LIMIT 1)), " +
            "ll_to_earth((SELECT latitude FROM cidade WHERE UPPER(nome)=UPPER(?2) LIMIT 1),(SELECT longitude FROM cidade WHERE UPPER(nome)=UPPER(?2) LIMIT 1))" +
            ") as distance", nativeQuery = true)
    Double distanceByCubeNames(String name1, String name2);

}

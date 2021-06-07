package br.com.luigipietro.citiesapi.resources;

import br.com.luigipietro.citiesapi.services.DistanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distances")
public class DistanceResource {

    Logger log = LoggerFactory.getLogger(DistanceResource.class);

    private final DistanceService service;

    public DistanceResource(DistanceService service) {
        this.service = service;
    }

    @GetMapping("/by-points")
    public ResponseEntity byPoints(@RequestParam(name = "from") final Long city1,
                                   @RequestParam(name = "to") final Long city2) {
        log.info("byPoints");
        return ResponseEntity.ok().body(service.distanceByPointsInMiles(city1, city2));
    }

    @GetMapping("/by-cube")
    public Double byCube(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2) {
        log.info("byCube");
        return service.distanceByCubeInMeters(city1, city2);
    }

    @GetMapping("/by-points/names")
    public String byPointsName(@RequestParam(name = "from") final String city1,
                           @RequestParam(name = "to") final String city2) {
        log.info("byPointsNames");
        return "De " + city1 + " a " + city2 + " em milhas -> " +
                service.distanceByPointsInMilesNames(city1, city2);
    }

    @GetMapping("/by-cube/names")
    public String byCubeName(@RequestParam(name = "from") final String city1,
                         @RequestParam(name = "to") final String city2) {
        log.info("byCubeNames");
        return "De " + city1 + " a " + city2 + " em km -> " +
                service.distanceByCubeInMetersNames(city1, city2) / 1000.0;
    }

//    @GetMapping("/by-math")
//    public Double byMath(@RequestParam(name = "from") final Long city1,
//                         @RequestParam(name = "to") final Long city2,
//                         @RequestParam final EarthRadius unit) {
//        log.info("byMath");
//        return service.distanceUsingMath(city1, city2, unit);
//    }
}

/*
http://localhost:8088/distances/by-cube?from=4929&to=5254

 */
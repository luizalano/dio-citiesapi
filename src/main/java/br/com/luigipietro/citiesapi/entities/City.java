package br.com.luigipietro.citiesapi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;


import javax.persistence.*;

@Entity
@Table(name = "cidade")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TypeDefs(value = {@TypeDef(name = "point", typeClass = PointType.class)})
public class City {

    @Id
    public Long id;

    @Column(name = "nome")
    public String name;

    @Column
    private Integer ibge;

    @Type(type = "point")
    @Column(name = "lat_lon", updatable = false, insertable = false)
    private Point geolocation;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    @Column(name = "cod_tom")
    private Integer codTom;

    @ManyToOne
    @JoinColumn(name = "uf", referencedColumnName = "id")
    private State state;
//    @Column
//    private Integer uf;

}

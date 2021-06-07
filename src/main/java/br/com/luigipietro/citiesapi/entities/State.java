package br.com.luigipietro.citiesapi.entities;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="estado")
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
// Este TypeDefs, precisa da seguinte linha no build.gradle:
// implementation 'com.vladmihalcea:hibernate-types-52:2.9.8'
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class State {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column
    private String uf;

    @Column
    private Integer ibge;

/* Se fosse para trazer somento o ID do país
  @Column(name = "pais")
  private Integer countryId;*/

    // 2nd - @ManyToOne
    @ManyToOne //(fetch = FetchType.LAZY)
    @JoinColumn(name = "pais", referencedColumnName = "id")
    private Country country;

    @Type(type = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ddd", columnDefinition = "jsonb")
    private List<Integer> ddd;
}

package cib.edu.pe.ProyectoDSW_CherryBite.model.bd;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "valornutricional")
public class ValorNutricional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idvalornutricional;

    private Double  calorias;
    private Double  proteinas;
    private Double  grasas;
    private Double  carbohidratos;
    private Double  colesterol;
    private Double  sodio;
    private Double  potasio;

    @OneToMany(mappedBy = "valorNutricional",
            cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Alimento> alimentos = new HashSet<>();
}

package cib.edu.pe.ProyectoDSW_CherryBite.model.bd;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "alimento")
public class Alimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idalimento;
    private String nombre;
    private Integer porcion;

    @ManyToOne
    @JoinColumn(name = "idgrupoalimento")
    private GrupoAlimento grupoAlimento;
    private String descripcion;
    private String imagen;
    @ManyToOne
    @JoinColumn(name = "idvalornutricional")
    private ValorNutricional valorNutricional;

    @ManyToOne
    @JoinColumn(name = "idunidadmedida")
    private UnidadMedida unidadMedida;

    @OneToMany(mappedBy = "alimento",
            cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<DetalleAlimento> alimentos = new HashSet<>();
}
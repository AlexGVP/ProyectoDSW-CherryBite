package cib.edu.pe.ProyectoDSW_CherryBite.model.bd;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "grupoalimento")
public class GrupoAlimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idgrupoalimento;
    private String descripcion;

    @OneToMany(mappedBy = "grupoAlimento",
            cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Alimento> alimentos = new HashSet<>();
}
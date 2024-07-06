package cib.edu.pe.ProyectoDSW_CherryBite.model.bd;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "habito")
public class Habito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idhabito;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "idcategoria")
    private Categoria categoria;
    private String frecuencia;
    private Date horadia;
    private Date fechainicio;
    private Date fechafin;
    private Integer progreso;

    @OneToMany(mappedBy = "habito", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<DetalleHabito> habitos = new HashSet<>();
}
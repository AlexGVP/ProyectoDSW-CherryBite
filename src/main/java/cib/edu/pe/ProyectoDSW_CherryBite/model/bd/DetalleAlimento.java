package cib.edu.pe.ProyectoDSW_CherryBite.model.bd;

import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.pk.AlimentoUsuarioID;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "detalle_alimento")
public class DetalleAlimento {
    @EmbeddedId
    private AlimentoUsuarioID id;
    private Date fecha;

    @ManyToOne
    @MapsId("idusuario")
    @JoinColumn(name = "idusuario")
    @JsonBackReference
    private Usuario usuario;

    @ManyToOne
    @MapsId("idalimento")
    @JoinColumn(name = "idalimento")
    @JsonBackReference
    private Alimento alimento;
}
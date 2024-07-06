package cib.edu.pe.ProyectoDSW_CherryBite.model.bd;

import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.pk.HabitoUsuarioID;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "detalle_habito")
public class DetalleHabito implements Serializable {
    @EmbeddedId
    private HabitoUsuarioID id;
    private Date fecha;

    @ManyToOne
    @MapsId("idusuario")
    @JoinColumn(name = "idusuario")
    @JsonBackReference
    private Usuario usuario;

    @ManyToOne
    @MapsId("idhabito")
    @JoinColumn(name = "idhabito")
    @JsonBackReference
    private Habito habito;
}
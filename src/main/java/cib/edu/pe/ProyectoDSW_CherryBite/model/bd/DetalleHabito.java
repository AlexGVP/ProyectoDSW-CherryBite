package cib.edu.pe.ProyectoDSW_CherryBite.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.security.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "detalle_habito")
public class DetalleHabito implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "idhabito")
    private Habito habito;

    private Boolean realizado;

    @Column(name = "fecha", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp fechaRealizado;
}

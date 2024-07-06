package cib.edu.pe.ProyectoDSW_CherryBite.model.bd.pk;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class HabitoUsuarioID implements Serializable {
    private Integer idusuario;
    private Integer idhabito;
}
package cib.edu.pe.ProyectoDSW_CherryBite.model.bd;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "unidadmedida")
public class UnidadMedida {
    private Integer idunidadmedida;
    private String descripcion;
}

package cib.edu.pe.ProyectoDSW_CherryBite.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DetalleHabitoDto {
    private Integer idusuario;
    private Integer idhabito;
    private Boolean realizado;
    private Date fecha;
}

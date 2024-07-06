package cib.edu.pe.ProyectoDSW_CherryBite.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DetalleHabitoDto implements DtoEntity{
    private Integer idusuarioUsuario;
    private Integer idhabitoHabito;
    private Boolean realizado;
    private Date fecha;
}

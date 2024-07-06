package cib.edu.pe.ProyectoDSW_CherryBite.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DetalleAlimentoDto implements DtoEntity{
    private Integer idusuario;
    private Integer idalimento;
    private Date fecha;
    private Integer cantidad;
}

package cib.edu.pe.ProyectoDSW_CherryBite.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DetalleAlimentoDto2 implements DtoEntity{
    private Integer idusuarioUsuario;
    private String nombreAlimento;
    private Date fecha;
    private String imagenAlimento;
    private Integer cantidad;
}

package cib.edu.pe.ProyectoDSW_CherryBite.model.dto;

import lombok.Data;

@Data
public class UsuarioDto implements DtoEntity{
    private Integer idusuario;
    private String nomusuario;
    private String email;
    private String nombres;
    private String apellidos;
    private Boolean activo;
}
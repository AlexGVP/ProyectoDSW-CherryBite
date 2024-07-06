package cib.edu.pe.ProyectoDSW_CherryBite.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UsuarioResponse {
    private Integer idusuario;
    private String nomusuario;
    private String token;
}

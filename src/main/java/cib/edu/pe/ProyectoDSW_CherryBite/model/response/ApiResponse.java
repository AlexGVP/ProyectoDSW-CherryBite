package cib.edu.pe.ProyectoDSW_CherryBite.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private boolean estado;
    private String mensaje;
}

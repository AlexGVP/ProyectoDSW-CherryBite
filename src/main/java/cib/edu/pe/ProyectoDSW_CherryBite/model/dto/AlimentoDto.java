package cib.edu.pe.ProyectoDSW_CherryBite.model.dto;

import lombok.Data;

@Data
public class AlimentoDto implements DtoEntity {
    private Integer idalimento;
    private String nombre;
    private Integer porcion;
    private String descripcion;
    private String imagen;
    private Double calorias;
    private Double proteinas;
    private Double grasas;
    private Double carbohidratos;
    private Double colesterol;
    private Double sodio;
    private Double potasio;
}

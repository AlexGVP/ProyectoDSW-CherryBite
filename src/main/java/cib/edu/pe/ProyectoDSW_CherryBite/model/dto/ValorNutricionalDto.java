package cib.edu.pe.ProyectoDSW_CherryBite.model.dto;

import lombok.Data;

@Data
public class ValorNutricionalDto implements DtoEntity{
    private Integer idvalornutricional;
    private Double calorias;
    private Double proteinas;
    private Double grasas;
    private Double carbohidratos;
    private Double colesterol;
    private Double sodio;
    private Double potasio;
}

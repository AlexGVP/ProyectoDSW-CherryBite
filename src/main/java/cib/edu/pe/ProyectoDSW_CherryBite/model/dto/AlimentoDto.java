package cib.edu.pe.ProyectoDSW_CherryBite.model.dto;

import lombok.Data;

@Data
public class AlimentoDto implements DtoEntity {
    private Integer idalimento;
    private String nombre;
    private Integer porcion;
    private String descripcion;
    private String imagen;
    private String descripcionGrupoAlimento;
    private Double caloriasValorNutricional;
    private Double proteinasValorNutricional;
    private Double grasasValorNutricional;
    private Double carbohidratosValorNutricional;
    private Double colesterolValorNutricional;
    private Double sodioValorNutricional;
    private Double potasioValorNutricional;
}

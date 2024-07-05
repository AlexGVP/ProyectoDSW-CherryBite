package cib.edu.pe.ProyectoDSW_CherryBite.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.Alimento;
import cib.edu.pe.ProyectoDSW_CherryBite.model.dto.DtoEntity;

@Component
public class DtoUtil {

    public DtoEntity convertirADto (Object obj, DtoEntity mapper) {
        return new ModelMapper().map(obj, mapper.getClass());
    }

    public Object convertirDtoAEntity (Object obj, DtoEntity mapper){
        return new ModelMapper().map(mapper,obj.getClass());
    }
}
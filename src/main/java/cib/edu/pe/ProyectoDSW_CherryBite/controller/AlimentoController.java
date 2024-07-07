package cib.edu.pe.ProyectoDSW_CherryBite.controller;

import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.DetalleAlimento;
import cib.edu.pe.ProyectoDSW_CherryBite.model.dto.AlimentoDto;
import cib.edu.pe.ProyectoDSW_CherryBite.model.dto.DetalleAlimentoDto;
import cib.edu.pe.ProyectoDSW_CherryBite.model.dto.DetalleAlimentoDto2;
import cib.edu.pe.ProyectoDSW_CherryBite.model.dto.DtoEntity;
import cib.edu.pe.ProyectoDSW_CherryBite.service.IAlimentoService;
import cib.edu.pe.ProyectoDSW_CherryBite.service.IDetalleAlimentoService;
import cib.edu.pe.ProyectoDSW_CherryBite.util.DtoUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/cherry/alimento")
public class AlimentoController {

    private IAlimentoService iAlimentoService;

    @GetMapping("")
    public ResponseEntity<List<DtoEntity>> getAllAlimentos(){
        List<DtoEntity>alimentoDtoList=new ArrayList<>();
        alimentoDtoList=iAlimentoService.listarAlimentos()
                .stream()
                .map(x -> new DtoUtil().convertirADto(x,new AlimentoDto()))
                .collect(Collectors.toList());
        if(alimentoDtoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(alimentoDtoList, HttpStatus.OK);
    }
}

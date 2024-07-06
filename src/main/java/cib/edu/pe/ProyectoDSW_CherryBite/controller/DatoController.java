package cib.edu.pe.ProyectoDSW_CherryBite.controller;

import cib.edu.pe.ProyectoDSW_CherryBite.model.dto.DatoDto;
import cib.edu.pe.ProyectoDSW_CherryBite.model.dto.DtoEntity;
import cib.edu.pe.ProyectoDSW_CherryBite.service.IDatoService;
import cib.edu.pe.ProyectoDSW_CherryBite.util.DtoUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/cherry/dato")
public class DatoController {
    IDatoService iDatoService;

    @GetMapping("")
    public ResponseEntity<List<DtoEntity>> getAllDato(){
        List<DtoEntity>datoDtoList=new ArrayList<>();
        datoDtoList=iDatoService.datoList()
                .stream()
                .map(x -> new DtoUtil().convertirADto(x,new DatoDto()))
                .collect(Collectors.toList());
        if(datoDtoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(datoDtoList, HttpStatus.OK);
    }
}

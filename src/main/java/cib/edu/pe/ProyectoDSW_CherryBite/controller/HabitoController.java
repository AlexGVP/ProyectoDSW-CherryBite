package cib.edu.pe.ProyectoDSW_CherryBite.controller;

import cib.edu.pe.ProyectoDSW_CherryBite.model.dto.DtoEntity;
import cib.edu.pe.ProyectoDSW_CherryBite.model.dto.HabitoDto;
import cib.edu.pe.ProyectoDSW_CherryBite.service.IHabitoService;
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
@RequestMapping(path = "api/cherry/habito")
public class HabitoController {

    private IHabitoService iHabitoService;

    @GetMapping("")
    public ResponseEntity<List<DtoEntity>> getAllHabitos(){
        List<DtoEntity>habitoDtoList=new ArrayList<>();
        habitoDtoList=iHabitoService.listarHabitos()
                .stream()
                .map(x -> new DtoUtil().convertirADto(x,new HabitoDto()))
                .collect(Collectors.toList());
        if(habitoDtoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(habitoDtoList, HttpStatus.OK);
    }
}

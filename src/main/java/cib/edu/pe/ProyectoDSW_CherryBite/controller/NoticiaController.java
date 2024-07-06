package cib.edu.pe.ProyectoDSW_CherryBite.controller;

import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.Noticia;
import cib.edu.pe.ProyectoDSW_CherryBite.model.dto.DtoEntity;
import cib.edu.pe.ProyectoDSW_CherryBite.model.dto.NoticiaDto;
import cib.edu.pe.ProyectoDSW_CherryBite.repository.NoticiaRepository;
import cib.edu.pe.ProyectoDSW_CherryBite.service.INoticiaService;
import cib.edu.pe.ProyectoDSW_CherryBite.service.NoticiaService;
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
@RequestMapping(path = "api/cherry/noticia")
public class NoticiaController {
    INoticiaService iNoticiaService;

    @GetMapping("")
    public ResponseEntity<List<DtoEntity>> getAllNoticias(){
        List<DtoEntity>noticiaDtoList=new ArrayList<>();
        noticiaDtoList=iNoticiaService.noticiaList()
                .stream()
                .map(x -> new DtoUtil().convertirADto(x,new NoticiaDto()))
                .collect(Collectors.toList());
        if(noticiaDtoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(noticiaDtoList, HttpStatus.OK);
    }
}

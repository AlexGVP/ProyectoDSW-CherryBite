package cib.edu.pe.ProyectoDSW_CherryBite.controller;

import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.DetalleAlimento;
import cib.edu.pe.ProyectoDSW_CherryBite.model.dto.DetalleAlimentoDto;
import cib.edu.pe.ProyectoDSW_CherryBite.model.dto.DetalleAlimentoDto2;
import cib.edu.pe.ProyectoDSW_CherryBite.model.dto.DtoEntity;
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
@RequestMapping(path = "api/cherry/detallealimento")
public class DetalleAlimentoController {

    private IDetalleAlimentoService iDetalleAlimentoService;
    @GetMapping("")
    public ResponseEntity<List<DtoEntity>> getAllAlimentosRegistrdos(){
        List<DtoEntity>detalleAlimentoDto2=new ArrayList<>();
        detalleAlimentoDto2=iDetalleAlimentoService.listadoComidasRegistradas()
                .stream()
                .map(x -> new DtoUtil().convertirADto(x,new DetalleAlimentoDto2()))
                .collect(Collectors.toList());
        if(detalleAlimentoDto2.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(detalleAlimentoDto2, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<DetalleAlimento> registrarAlimento(@RequestBody DetalleAlimentoDto detalleAlimentoDto) {
        try {
            DetalleAlimento detalleAlimento = iDetalleAlimentoService.registrarAlimento(detalleAlimentoDto);
            return new ResponseEntity<>(detalleAlimento, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package cib.edu.pe.ProyectoDSW_CherryBite.controller;

import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.DetalleAlimento;
import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.DetalleHabito;
import cib.edu.pe.ProyectoDSW_CherryBite.model.dto.DetalleAlimentoDto;
import cib.edu.pe.ProyectoDSW_CherryBite.model.dto.DetalleHabitoDto;
import cib.edu.pe.ProyectoDSW_CherryBite.model.dto.DtoEntity;
import cib.edu.pe.ProyectoDSW_CherryBite.service.IDetalleHabitoService;
import cib.edu.pe.ProyectoDSW_CherryBite.util.DtoUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/cherry/detallehabito")
public class DetalleHabitoController {


    private IDetalleHabitoService iDetalleHabitoService;

    @GetMapping("")
    public ResponseEntity<List<DtoEntity>> getAllDetalles() {
        List<DtoEntity> detalleHabitoDtoList = new ArrayList<>();
        detalleHabitoDtoList = iDetalleHabitoService.listarDetalleHabito()
                .stream()
                .map(x -> new DtoUtil().convertirADto(x, new DetalleHabitoDto()))
                .collect(Collectors.toList()).reversed();

        if (detalleHabitoDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(detalleHabitoDtoList, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<DetalleHabito> registrarHabito(@RequestBody DetalleHabitoDto detalleHabitoDto) {
        try {
            DetalleHabito detalleHabito = iDetalleHabitoService.registrarHabito(detalleHabitoDto);
            return new ResponseEntity<>(detalleHabito, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

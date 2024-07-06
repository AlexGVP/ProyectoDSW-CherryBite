package cib.edu.pe.ProyectoDSW_CherryBite.service;

import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.DetalleAlimento;
import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.pk.AlimentoUsuarioID;
import cib.edu.pe.ProyectoDSW_CherryBite.model.dto.DetalleAlimentoDto;

import java.util.List;
import java.util.Optional;

public interface IDetalleAlimentoService
{
    List<DetalleAlimento> listadoComidasRegistradas();
    DetalleAlimento registrarAlimento(DetalleAlimentoDto detalleAlimentoDto);
}

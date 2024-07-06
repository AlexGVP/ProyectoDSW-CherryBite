package cib.edu.pe.ProyectoDSW_CherryBite.service;


import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.DetalleAlimento;
import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.DetalleHabito;
import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.Habito;
import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.Usuario;
import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.pk.HabitoUsuarioID;
import cib.edu.pe.ProyectoDSW_CherryBite.model.dto.DetalleHabitoDto;
import cib.edu.pe.ProyectoDSW_CherryBite.repository.DetalleHabitoRepository;
import cib.edu.pe.ProyectoDSW_CherryBite.repository.HabitoRepository;
import cib.edu.pe.ProyectoDSW_CherryBite.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class DetalleHabitoService implements IDetalleHabitoService {
    private final DetalleHabitoRepository detalleHabitoRepository;
    private final HabitoRepository habitoRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public List<DetalleHabito> listarDetalleHabito() {
        return detalleHabitoRepository.findAll();
    }

    @Override
    public DetalleHabito registrarHabito(DetalleHabitoDto detalleHabitoDto) {
        DetalleHabito detalleHabito = convertirDtoAEntidad(detalleHabitoDto);
        return detalleHabitoRepository.save(detalleHabito);
    }

    private DetalleHabito convertirDtoAEntidad(DetalleHabitoDto detalleHabitoDto) {
        DetalleHabito detalleHabito = new DetalleHabito();
        HabitoUsuarioID id = new HabitoUsuarioID();
        id.setIdusuario(detalleHabitoDto.getIdusuarioUsuario());
        id.setIdhabito(detalleHabitoDto.getIdhabitoHabito());

        detalleHabito.setId(id);

        Habito habito = habitoRepository.findById(detalleHabitoDto.getIdhabitoHabito())
                .orElseThrow(() -> new RuntimeException("Habito no encontrado"));
        Usuario usuario = usuarioRepository.findById(detalleHabitoDto.getIdusuarioUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        detalleHabito.setHabito(habito);
        detalleHabito.setUsuario(usuario);
        detalleHabito.setFecha(detalleHabitoDto.getFecha() != null ? detalleHabitoDto.getFecha() : new Date());
        detalleHabito.setRealizado(detalleHabitoDto.getRealizado());

        return detalleHabito;
    }
}

package cib.edu.pe.ProyectoDSW_CherryBite.service;

import cib.edu.pe.ProyectoDSW_CherryBite.exception.ResourceNotFoundException;
import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.Rol;
import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.Usuario;
import cib.edu.pe.ProyectoDSW_CherryBite.repository.RolRepository;
import cib.edu.pe.ProyectoDSW_CherryBite.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UsuarioService implements IUsuarioService{

    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder=
            new BCryptPasswordEncoder();

    @Override
    public List<Usuario> listarUsuario() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> buscarusuarioPorId(Integer id) {
        Optional<Usuario> usuarioOptional=usuarioRepository.findById(id);
        if (usuarioOptional.isEmpty()){ return  Optional.empty();}
        return usuarioOptional;
    }

    @Override
    public Usuario obtenerUsuarioPorNomUsuario(String nomususario) {
        return usuarioRepository.findByNomusuario(nomususario);
    }

    @Override
    public Usuario nuevoUsuario(Usuario usuario) {
        Rol rolPorDefecto = rolRepository.findById(1)
                .orElseThrow(() -> new ResourceNotFoundException("no se encontró el rol"));
        usuario.setRoles(Collections.singleton(rolPorDefecto));
        usuario.setPassword(bCryptPasswordEncoder.encode(
                usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }
    @Override
    public Usuario actualizarUsuario(Integer id, Usuario actualizarUsuario) {
        Usuario usuarioExistente = usuarioRepository.findById(actualizarUsuario.getIdusuario()).orElse(null);
        if (usuarioExistente != null) {
            usuarioExistente.setNomusuario(actualizarUsuario.getNomusuario());
            usuarioExistente.setEmail(actualizarUsuario.getEmail());
            usuarioExistente.setPassword(actualizarUsuario.getPassword());
            usuarioExistente.setNombres(actualizarUsuario.getNombres());
            usuarioExistente.setApellidos(actualizarUsuario.getApellidos());
            usuarioExistente.setActivo(actualizarUsuario.getActivo());
            return usuarioRepository.save(usuarioExistente);
        }
        return null;
    }
}
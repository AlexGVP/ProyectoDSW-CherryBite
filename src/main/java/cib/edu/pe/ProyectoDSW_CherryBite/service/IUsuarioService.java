package cib.edu.pe.ProyectoDSW_CherryBite.service;


import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    List<Usuario> listarUsuario();
    Optional<Usuario> buscarusuarioPorId(Integer id);
    Usuario obtenerUsuarioPorNomUsuario(String nomususario);
    Usuario nuevoUsuario(Usuario usuario);
    Usuario actualizarUsuario(Integer id, Usuario actualizarUsuario);
}

package cib.edu.pe.ProyectoDSW_CherryBite.controller;

import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.Usuario;
import cib.edu.pe.ProyectoDSW_CherryBite.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/cherry/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/")
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuario();
    }

    @PostMapping("/agregar")
    public Usuario agregarUsuario(@RequestBody Usuario nuevoUsuario) {
        return usuarioService.agregarUsuario(nuevoUsuario);
    }

    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuarioActualizado) {
        usuarioActualizado.setIdusuario(id);
        return usuarioService.actualizarUsuario(usuarioActualizado);
    }
}
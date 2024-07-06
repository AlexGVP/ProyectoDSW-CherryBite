package cib.edu.pe.ProyectoDSW_CherryBite.controller;

import cib.edu.pe.ProyectoDSW_CherryBite.exception.ResourceNotFoundException;
import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.Usuario;
import cib.edu.pe.ProyectoDSW_CherryBite.model.response.ApiResponse;
import cib.edu.pe.ProyectoDSW_CherryBite.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/cherry/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;
    @GetMapping("")
    public ResponseEntity<List<Usuario>> listResponseUsuario(){
        List<Usuario> usuarioList=new ArrayList<>(usuarioService.listarUsuario());
        if (usuarioList.isEmpty()){return  new ResponseEntity<>(HttpStatus.NO_CONTENT);}
        return  new ResponseEntity<>(usuarioList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarIdResponseUsuario(@PathVariable Integer id){
        Usuario usuarioid=usuarioService.buscarusuarioPorId(id).orElseThrow(
                ()->new ResourceNotFoundException("El usario con el id "+id+" no existe")
        );
        return new ResponseEntity<>(usuarioid,HttpStatus.OK);

    }

    @PostMapping("")
    public ResponseEntity<ApiResponse> nuevoResponseUsuario(@RequestBody Usuario usuario){
        try {
            Usuario nuevousuario = usuarioService.nuevoUsuario(usuario);
            return ResponseEntity.ok(new ApiResponse(true, "Usuario creado exitosamente"));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error al crear el usuario: " + e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> actualizarResponseUsuario(@PathVariable Integer id, @RequestBody Usuario usuario){
        try {
            Usuario actualizarusuario = usuarioService.actualizarUsuario(id, usuario);
            return ResponseEntity.ok(new ApiResponse(true, "Usuario actualizado exitosamente"));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error al actualizar el usuario: " + e.getMessage()));
        }
    }

}

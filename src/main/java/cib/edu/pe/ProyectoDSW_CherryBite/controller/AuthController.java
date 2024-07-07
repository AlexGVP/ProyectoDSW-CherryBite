package cib.edu.pe.ProyectoDSW_CherryBite.controller;

import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.Usuario;
import cib.edu.pe.ProyectoDSW_CherryBite.model.response.UsuarioSeguridadDto;
import cib.edu.pe.ProyectoDSW_CherryBite.service.DetalleUsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/cherry/auth")
public class AuthController {

    private DetalleUsuarioService detalleUsuarioService;
    private AuthenticationManager authenticationManager;


    @PostMapping("/login")
    @Transactional(readOnly = true)
    public ResponseEntity<UsuarioSeguridadDto> autenticarUsuario(
            @RequestParam("usuario") String usuario,
            @RequestParam("password") String password
    ) throws Exception {
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            usuario,
                            password));
            if(authentication.isAuthenticated()){
                Usuario objUsuario = detalleUsuarioService.findByNomusuario(usuario);
                String token = generarToken(objUsuario);
                UsuarioSeguridadDto usuarioSeguridad =
                        new UsuarioSeguridadDto(objUsuario.getIdusuario(),
                                usuario,
                                token);
                return new ResponseEntity<>(usuarioSeguridad, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (Exception ex){
            throw new Exception("Usuario y/o password incorrecto.");
        }
    }

    private String generarToken(Usuario objUsuario){
        String clave = "@Cibertec2024";
        List<GrantedAuthority> grantedAuthorityList =
                detalleUsuarioService.obtenerListaRolesUsuario(objUsuario.getRoles());
        String token = Jwts
                .builder()
                .setId(objUsuario.getIdusuario().toString())
                .setSubject(objUsuario.getNomusuario())
                .claim("authorities",
                        grantedAuthorityList.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList())
                )
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 3000000))
                .signWith(SignatureAlgorithm.HS512, clave.getBytes())
                .compact();
        return token;
    }
}

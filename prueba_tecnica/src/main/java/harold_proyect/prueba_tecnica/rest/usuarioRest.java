/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harold_proyect.prueba_tecnica.rest;

import harold_proyect.prueba_tecnica.service.UsuarioService;
import harold_proyect.prueba_tecnica.model.Usuario;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author COMPUMAX
 */
@RestController
@RequestMapping("/usuario/")
public class usuarioRest {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios(){
        return ResponseEntity.ok(usuarioService.findAll());
    }
    
    @PostMapping
    public ResponseEntity<Usuario> createUsuarios(@RequestBody Usuario user){
        try {
            Usuario usuario = usuarioService.save(user);
            return ResponseEntity.created(new URI("/usuario/" + usuario.getId())).body(usuario);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}

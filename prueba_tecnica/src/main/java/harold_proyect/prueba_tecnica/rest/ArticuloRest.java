package harold_proyect.prueba_tecnica.rest;

import harold_proyect.prueba_tecnica.service.ArticuloService;
import harold_proyect.prueba_tecnica.model.Articulo;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author COMPUMAX
 */
@RestController
@RequestMapping("/articulo/")
public class ArticuloRest {

    @Autowired
    private ArticuloService usuarioService;

    @GetMapping
    public ResponseEntity<List<Articulo>> getArticulos() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @PostMapping
    public ResponseEntity<Articulo> createArticulos(@RequestBody Articulo art) {
        try {
            List<Articulo> articulos = usuarioService.findAll();
            for (Articulo articulo : articulos) {
                if (articulo.getNombre().equalsIgnoreCase(art.getNombre())) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
                }
            }
            Articulo usuario = usuarioService.save(art);
            return ResponseEntity.created(new URI("/usuario/" + usuario.getId())).body(usuario);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}

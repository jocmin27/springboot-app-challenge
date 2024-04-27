package com.example.springboot.app.controller;

import com.example.springboot.app.controller.model.UsuarioDTO;
import com.example.springboot.app.repository.UsuarioRepository;
import com.example.springboot.app.repository.model.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RequestMapping(path = "/api/domain-api/v1",produces = "application/json")
@Slf4j
public class SpringbootAppController {

    @Autowired
    UsuarioRepository usuarioRepository;


    /*@GetMapping(path = "/usuarios")
    public ResponseEntity<Object> usuarios() {
        return ResponseEntity.ok().body(usuarioRepository.findAll());
    }
*/
    @PostMapping(path = "/usuario")
    public ResponseEntity<String> guardarUsuario(@RequestBody Usuario us) {
        try {
            // Guardar el usuario en la base de datos
            usuarioRepository.save(us);

            // Devolver una respuesta de éxito
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("Usuario guardado correctamente");

        } catch (DataAccessException e) {
            // Loggear el error
            log.error("Error al guardar el usuario: {}", e.getMessage());
            // Devolver una respuesta de error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("Error interno del servidor al guardar el usuario");
        }
    }
}

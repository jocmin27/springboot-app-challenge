package com.example.springboot.app.repository;

import com.example.springboot.app.repository.model.Usuario;
import org.springframework.data.repository.CrudRepository;


public interface UsuarioRepository extends CrudRepository<Usuario,Integer> {

}

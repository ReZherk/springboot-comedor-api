package com.universidad.comedor.controller;

import com.universidad.comedor.model.Estudiante;
import com.universidad.comedor.repository.EstudianteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UserController {

 private final EstudianteRepository repo;

 public UserController(EstudianteRepository repo) {
  this.repo = repo;
 }

 @GetMapping("/me")
 public ResponseEntity<?> getPerfil(Authentication auth) {
  String codigo = (String) auth.getPrincipal();

  Optional<Estudiante> optional = repo.findByCodigo(codigo);

  if (optional.isPresent()) {
   return ResponseEntity.ok(optional.get());
  } else {
   return ResponseEntity.status(404).body("Usuario no encontrado");
  }
 }
}
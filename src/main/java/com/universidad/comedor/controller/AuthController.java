package com.universidad.comedor.controller;

import com.universidad.comedor.dto.*;
import com.universidad.comedor.model.Estudiante;
import com.universidad.comedor.repository.EstudianteRepository;
import com.universidad.comedor.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

 private final EstudianteRepository repo;
 private final JwtTokenProvider jwtProvider;

 public AuthController(EstudianteRepository repo, JwtTokenProvider jwtProvider) {
  this.repo = repo;
  this.jwtProvider = jwtProvider;
 }

 @PostMapping("/login")
 public ResponseEntity<?> login(@RequestBody LoginRequestDTO login) {
  Optional<Estudiante> estudiante = repo.findByCodigoAndDni(login.getCodigo(), login.getDni());
  if (estudiante.isPresent()) {
   String token = jwtProvider.generateToken(estudiante.get().getCodigo());
   return ResponseEntity.ok(new LoginResponseDTO(token));
  } else {
   return ResponseEntity.status(401).body("Código o DNI incorrecto.");
  }
 }
}

package com.universidad.comedor.controller;

import com.universidad.comedor.model.Estudiante;
import com.universidad.comedor.repository.EstudianteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

 private final EstudianteRepository repo;

 public AdminController(EstudianteRepository repo) {
  this.repo = repo;
 }

 @GetMapping("/estudiantes")
 public List<Estudiante> listar() {
  return repo.findAll();
 }

 @PostMapping("/estudiantes")
 public Estudiante guardar(@RequestBody Estudiante est) {
  return repo.save(est);
 }

 @DeleteMapping("/estudiantes/{id}")
 public void eliminar(@PathVariable Long id) {
  repo.deleteById(id);
 }
}

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

 @PutMapping("/estudiantes/{id}")
 public Estudiante actualizar(@PathVariable Long id, @RequestBody Estudiante nuevo) {
  return repo.findById(id).map(est -> {
   est.setCodigo(nuevo.getCodigo());
   est.setDni(nuevo.getDni());
   est.setNombre(nuevo.getNombre());
   est.setApellido(nuevo.getApellido());
   est.setCorreoInstitucional(nuevo.getCorreoInstitucional());
   est.setIdFacultad(nuevo.getIdFacultad());
   est.setIdEscuela(nuevo.getIdEscuela());
   return repo.save(est);
  }).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
 }

 @DeleteMapping("/estudiantes/{id}")
 public void eliminar(@PathVariable Long id) {
  repo.deleteById(id);
 }
}

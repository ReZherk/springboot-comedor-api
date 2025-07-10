package com.universidad.comedor.controller;

import com.universidad.comedor.model.Escuela;
import com.universidad.comedor.repository.EscuelaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facultades/{idFacultad}/escuelas")
public class EscuelaController {

 private final EscuelaRepository repo;

 public EscuelaController(EscuelaRepository repo) {
  this.repo = repo;
 }

 @GetMapping
 public List<Escuela> listarEscuelasPorFacultad(@PathVariable Long idFacultad) {
  return repo.findByFacultad_IdFacultad(idFacultad);
 }
}

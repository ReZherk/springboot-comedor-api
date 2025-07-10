package com.universidad.comedor.controller;

import com.universidad.comedor.model.Facultad;
import com.universidad.comedor.repository.FacultadRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facultades")
public class FacultadController {

 private final FacultadRepository repo;

 public FacultadController(FacultadRepository repo) {
  this.repo = repo;
 }

 @GetMapping
 public List<Facultad> listarFacultades() {
  return repo.findAll();
 }
}

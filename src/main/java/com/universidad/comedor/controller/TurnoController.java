package com.universidad.comedor.controller;

import com.universidad.comedor.model.Turno;
import com.universidad.comedor.model.Horario;
import com.universidad.comedor.repository.TurnoRepository;
import com.universidad.comedor.repository.HorarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

 private final TurnoRepository turnoRepo;
 private final HorarioRepository horarioRepo;

 public TurnoController(TurnoRepository turnoRepo, HorarioRepository horarioRepo) {
  this.turnoRepo = turnoRepo;
  this.horarioRepo = horarioRepo;
 }

 @GetMapping
 public List<Turno> obtenerTurnos() {
  return turnoRepo.findAll();
 }

 @GetMapping("/{id}/horarios")
 public List<Horario> horariosPorTurno(@PathVariable Long id) {
  return horarioRepo.findByTurnoIdTurno(id);
 }
}

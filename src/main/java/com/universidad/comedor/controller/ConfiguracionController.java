package com.universidad.comedor.controller;

import com.universidad.comedor.dto.HorarioDTO;
import com.universidad.comedor.dto.LimiteRacionDTO;
import com.universidad.comedor.dto.TurnoDTO;
import com.universidad.comedor.model.Horario;
import com.universidad.comedor.model.LimiteRaciones;
import com.universidad.comedor.model.Turno;
import com.universidad.comedor.repository.HorarioRepository;
import com.universidad.comedor.repository.LimiteRacionesRepository;
import com.universidad.comedor.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/config")
public class ConfiguracionController {

  @Autowired
  private TurnoRepository turnoRepo;

  @Autowired
  private LimiteRacionesRepository limiteRepo;

  @Autowired
  private HorarioRepository horarioRepo;

  // Traer todos los turnos y sus límites
  @GetMapping("/turnos")
  public List<Turno> listarTurnos() {
    return turnoRepo.findAll();
  }

  // Traer todos los horarios por turno
  @GetMapping("/turnos/{id}/horarios")
  public List<Horario> listarHorariosPorTurno(@PathVariable Long id) {
    return horarioRepo.findByTurnoIdTurno(id);
  }

  // Traer todos los límites de raciones
  @GetMapping("/limites")
  public List<LimiteRaciones> listarLimites() {
    return limiteRepo.findAll();
  }

  // ✅ Actualizar un límite global de turno
  @PutMapping("/turnos/{id}")
  public Turno actualizarTurno(@PathVariable Long id, @RequestBody TurnoDTO dto) {
    Turno turno = turnoRepo.findById(id).orElseThrow();
    turno.setLimiteGlobal(dto.getLimiteGlobal());
    return turnoRepo.save(turno);
  }

  // ✅ Actualizar límite de raciones por escuela
  @PutMapping("/limites")
  public void actualizarLimites(@RequestBody List<LimiteRacionDTO> limites) {
    for (LimiteRacionDTO dto : limites) {
      LimiteRaciones lr = limiteRepo.findAll().stream()
          .filter(l -> l.getIdFacultad().equals(dto.getIdFacultad())
              && l.getIdEscuela().equals(dto.getIdEscuela())
              && l.getIdTurno().equals(dto.getIdTurno()))
          .findFirst()
          .orElseThrow();
      lr.setRacionesMax(dto.getRacionesMax());
      limiteRepo.save(lr);
    }
  }

  // ✅ Actualizar horario
  @PutMapping("/horarios/{id}")
  public Horario actualizarHorario(@PathVariable Long id, @RequestBody HorarioDTO dto) {
    Horario horario = horarioRepo.findById(id).orElseThrow();
    horario.setHoraInicio(dto.getHoraInicio());
    horario.setHoraFin(dto.getHoraFin());
    return horarioRepo.save(horario);
  }
}

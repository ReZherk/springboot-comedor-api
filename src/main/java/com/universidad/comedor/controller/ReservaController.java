package com.universidad.comedor.controller;

import com.universidad.comedor.dto.ReservaRequestDTO;
import com.universidad.comedor.dto.ReservaResponseDTO;
import com.universidad.comedor.model.Reserva;
import com.universidad.comedor.repository.ReservaRepository;
import com.universidad.comedor.service.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ReservaController {

  private final ReservaService reservaService;
  private final ReservaRepository reservaRepo;

  public ReservaController(ReservaService reservaService, ReservaRepository reservaRepo) {
    this.reservaService = reservaService;
    this.reservaRepo = reservaRepo;
  }

  @PostMapping("/reservar")
  public ResponseEntity<ReservaResponseDTO> reservar(@RequestBody ReservaRequestDTO dto,
      Authentication auth) {
    String codigo = (String) auth.getPrincipal();
    String mensaje = reservaService.reservar(codigo, dto.getId_turno(), dto.getId_horario());
    return ResponseEntity.ok(new ReservaResponseDTO(mensaje));
  }

  @GetMapping("/mis-reservas")
  public List<Reserva> misReservas(Authentication auth) {
    String codigo = (String) auth.getPrincipal();
    return reservaRepo.findByIdEstudiante(
        reservaService.getEstudianteIdPorCodigo(codigo));
  }
}

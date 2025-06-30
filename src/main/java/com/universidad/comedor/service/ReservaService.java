package com.universidad.comedor.service;

import com.universidad.comedor.model.*;
import com.universidad.comedor.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ReservaService {

  private final ReservaRepository reservaRepo;
  private final EstudianteRepository estudianteRepo;
  private final LimiteRacionesRepository limiteRepo;

  public ReservaService(ReservaRepository reservaRepo, EstudianteRepository estudianteRepo,
      LimiteRacionesRepository limiteRepo) {
    this.reservaRepo = reservaRepo;
    this.estudianteRepo = estudianteRepo;
    this.limiteRepo = limiteRepo;
  }

  public String reservar(String codigoEstudiante, Long idTurno, Long idHorario) {
    Optional<Estudiante> optEst = estudianteRepo.findByCodigo(codigoEstudiante);
    if (optEst.isEmpty())
      return "Estudiante no encontrado";

    Estudiante est = optEst.get();
    LocalDate hoy = LocalDate.now();

    // 💡 CAMBIOS APLICADOS AQUÍ
    if (reservaRepo.existsByIdEstudianteAndFechaReservaAndIdTurno(est.getId_estudiante(), hoy, idTurno))
      return "Ya reservaste en este turno hoy";

    if (reservaRepo.existsByIdEstudianteAndFechaReserva(est.getId_estudiante(), hoy))
      return "Solo puedes hacer una reserva por día";

    long actuales = reservaRepo.countByIdFacultadAndIdEscuelaAndIdTurnoAndFechaReserva(
        est.getId_facultad(), est.getId_escuela(), idTurno, hoy);

    LimiteRacionesKey key = new LimiteRacionesKey(est.getId_facultad(), est.getId_escuela(), idTurno);
    LimiteRaciones limite = limiteRepo.findById(key).orElse(null);

    if (limite == null)
      return "No hay límite configurado para tu escuela y turno";

    if (actuales >= limite.getRaciones_max())
      return "Ya se agotaron las raciones para este turno";

    Reserva reserva = new Reserva();
    reserva.setIdEstudiante(est.getId_estudiante());
    reserva.setIdFacultad(est.getId_facultad());
    reserva.setIdEscuela(est.getId_escuela());
    reserva.setIdTurno(idTurno);
    reserva.setIdHorario(idHorario);
    reserva.setFechaReserva(hoy);

    reservaRepo.save(reserva);
    return "Reserva realizada con éxito";
  }

  public Long getEstudianteIdPorCodigo(String codigo) {
    return estudianteRepo.findByCodigo(codigo)
        .map(Estudiante::getId_estudiante)
        .orElse(null);
  }
}
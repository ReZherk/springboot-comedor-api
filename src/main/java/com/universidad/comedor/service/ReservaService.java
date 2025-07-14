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

    // Validar solo una reserva por turno al día
    if (reservaRepo.existsByIdEstudianteAndFechaReservaAndIdTurno(est.getIdEstudiante(), hoy, idTurno))
      return "Ya reservaste en este turno hoy. Solo se permite una reserva por turno.";

    // Verificar límite de raciones
    long actuales = reservaRepo.countByIdFacultadAndIdEscuelaAndIdTurnoAndFechaReserva(
        est.getIdFacultad(), est.getIdEscuela(), idTurno, hoy);

    LimiteRacionesKey key = new LimiteRacionesKey(est.getIdFacultad(), est.getIdEscuela(), idTurno);
    LimiteRaciones limite = limiteRepo.findById(key).orElse(null);

    if (limite == null)
      return "No hay límite configurado para tu escuela y turno";

    if (actuales >= limite.getRacionesMax())
      return "Ya se agotaron las raciones para este turno";

    Reserva reserva = new Reserva();
    reserva.setIdEstudiante(est.getIdEstudiante());
    reserva.setIdFacultad(est.getIdFacultad());
    reserva.setIdEscuela(est.getIdEscuela());
    reserva.setIdTurno(idTurno);
    reserva.setIdHorario(idHorario);
    reserva.setFechaReserva(hoy);

    reservaRepo.save(reserva);
    return "Reserva realizada con éxito";
  }

  public Long getEstudianteIdPorCodigo(String codigo) {
    return estudianteRepo.findByCodigo(codigo)
        .map(Estudiante::getIdEstudiante)
        .orElse(null);
  }
}

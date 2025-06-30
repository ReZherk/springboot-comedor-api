package com.universidad.comedor.repository;

import com.universidad.comedor.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

 boolean existsByIdEstudianteAndFechaReserva(Long idEstudiante, LocalDate fecha);

 boolean existsByIdEstudianteAndFechaReservaAndIdTurno(Long idEstudiante, LocalDate fecha, Long idTurno);

 long countByIdFacultadAndIdEscuelaAndIdTurnoAndFechaReserva(Long idFacultad, Long idEscuela, Long idTurno,
   LocalDate fecha);

 List<Reserva> findByIdEstudiante(Long idEstudiante);
}

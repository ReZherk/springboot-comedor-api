package com.universidad.comedor.repository;

import com.universidad.comedor.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HorarioRepository extends JpaRepository<Horario, Long> {
 List<Horario> findByTurnoIdTurno(Long idTurno);
}
package com.universidad.comedor.repository;

import com.universidad.comedor.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
 Optional<Estudiante> findByCodigoAndDni(String codigo, String dni);

 Optional<Estudiante> findByCodigo(String codigo);
}

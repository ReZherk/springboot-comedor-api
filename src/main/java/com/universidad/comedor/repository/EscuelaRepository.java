package com.universidad.comedor.repository;

import com.universidad.comedor.model.Escuela;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EscuelaRepository extends JpaRepository<Escuela, Long> {

 List<Escuela> findByFacultad_IdFacultad(Long idFacultad);
 // usa la propiedad embebida en la entidad Escuela
}

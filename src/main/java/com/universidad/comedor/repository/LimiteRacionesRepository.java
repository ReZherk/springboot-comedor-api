package com.universidad.comedor.repository;

import com.universidad.comedor.model.LimiteRaciones;
import com.universidad.comedor.model.LimiteRacionesKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LimiteRacionesRepository extends JpaRepository<LimiteRaciones, LimiteRacionesKey> {
}
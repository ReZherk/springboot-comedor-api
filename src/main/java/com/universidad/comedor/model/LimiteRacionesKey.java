package com.universidad.comedor.model;

import java.io.Serializable;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LimiteRacionesKey implements Serializable {
 private Long id_facultad;
 private Long id_escuela;
 private Long id_turno;
}

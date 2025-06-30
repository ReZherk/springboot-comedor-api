package com.universidad.comedor.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "LIMITERACIONES")
@IdClass(LimiteRacionesKey.class)
public class LimiteRaciones {

 @Id
 private Long id_facultad;

 @Id
 private Long id_escuela;

 @Id
 private Long id_turno;

 private int raciones_max;
}

package com.universidad.comedor.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(LimiteRacionesKey.class)
@Table(name = "LIMITERACIONES")
public class LimiteRaciones {

 @Id
 @Column(name = "id_facultad")
 private Long idFacultad;

 @Id
 @Column(name = "id_escuela")
 private Long idEscuela;

 @Id
 @Column(name = "id_turno")
 private Long idTurno;

 @Column(name = "raciones_max")
 private int racionesMax;
}

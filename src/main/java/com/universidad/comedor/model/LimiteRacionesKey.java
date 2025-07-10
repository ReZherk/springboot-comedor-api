package com.universidad.comedor.model;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LimiteRacionesKey implements Serializable {

 @Column(name = "id_facultad")
 private Long idFacultad;

 @Column(name = "id_escuela")
 private Long idEscuela;

 @Column(name = "id_turno")
 private Long idTurno;
}

package com.universidad.comedor.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Horario")
public class Horario {

 @Id
 @Column(name = "id_horario")
 private Long idHorario;

 @ManyToOne
 @JoinColumn(name = "id_turno")
 private Turno turno;

 @Column(name = "hora_inicio")
 private String horaInicio;

 @Column(name = "hora_fin")
 private String horaFin;
}

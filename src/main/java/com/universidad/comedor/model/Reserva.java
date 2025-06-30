package com.universidad.comedor.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Reserva")
public class Reserva {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id_reserva")
 private Long idReserva;

 @Column(name = "id_estudiante")
 private Long idEstudiante;

 @Column(name = "id_escuela")
 private Long idEscuela;

 @Column(name = "id_facultad")
 private Long idFacultad;

 @Column(name = "id_turno")
 private Long idTurno;

 @Column(name = "id_horario")
 private Long idHorario;

 @Column(name = "fecha_reserva")
 private LocalDate fechaReserva;
}
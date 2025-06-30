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
 private Long id_horario;

 @ManyToOne
 @JoinColumn(name = "id_turno")
 private Turno turno;

 private String hora_inicio;
 private String hora_fin;
}

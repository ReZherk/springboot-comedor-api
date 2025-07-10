package com.universidad.comedor.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Turno")
public class Turno {

 @Id
 @Column(name = "id_turno")
 private Long idTurno;

 private String nombre;

 @Column(name = "limite_global")
 private int limiteGlobal;
}

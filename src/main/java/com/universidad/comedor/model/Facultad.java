package com.universidad.comedor.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Facultad")
public class Facultad {

 @Id
 @Column(name = "id_facultad") // mantiene el mapeo a la columna con guión bajo
 private Long idFacultad;

 @Column(name = "nom_facultad")
 private String nombre;
}
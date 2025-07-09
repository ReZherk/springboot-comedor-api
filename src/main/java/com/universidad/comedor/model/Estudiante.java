package com.universidad.comedor.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Estudiante")
public class Estudiante {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id_estudiante;

 private Long id_facultad;
 private Long id_escuela;

 private String nombre;
 private String apellido;

 @Column(unique = true)
 private String codigo;

 @Column(length = 8)
 private String dni;

 private String correo_institucional;

 @Column(length = 20)
 private String rol;
}

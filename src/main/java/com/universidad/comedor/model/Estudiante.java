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
 @Column(name = "id_estudiante")
 private Long idEstudiante;

 @Column(name = "id_facultad")
 private Long idFacultad;

 @Column(name = "id_escuela")
 private Long idEscuela;

 private String nombre;
 private String apellido;

 @Column(name = "codigo", unique = true)
 private String codigo;

 @Column(name = "dni", length = 8)
 private String dni;

 @Column(name = "correo_institucional")
 private String correoInstitucional;

 @Column(name = "rol", length = 20)
 private String rol;
}
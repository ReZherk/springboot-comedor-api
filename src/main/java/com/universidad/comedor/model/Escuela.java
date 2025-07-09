package com.universidad.comedor.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Escuela")
public class Escuela {

 @Id
 private Long id_escuela;

 private String nombre;

 @ManyToOne
 @JoinColumn(name = "id_facultad") // Porque Escuela depende de Facultad
 private Facultad facultad;
}
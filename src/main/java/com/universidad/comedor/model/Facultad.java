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
 private Long id_facultad;

 private String nombre;
}
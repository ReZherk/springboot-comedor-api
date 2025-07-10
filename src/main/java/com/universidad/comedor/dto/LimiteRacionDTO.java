package com.universidad.comedor.dto;

import lombok.Data;

@Data
public class LimiteRacionDTO {
 private Long idFacultad;
 private Long idEscuela;
 private Long idTurno;
 private int racionesMax;
}

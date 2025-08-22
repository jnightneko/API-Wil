package com.api.parcial.dto;

import com.api.parcial.model.Proyecto;
import java.util.Date;
import java.util.List;

public record ProyectoDTO(
        Long id,
        Date fechaInicio,
        Date fechaFin,
        Double progreso
) {

    public static ProyectoDTO parse(Proyecto model) {
        return new ProyectoDTO(model.getIdproyecto(), 
                model.getDinicio(), 
                model.getDfin(), 
                model.getProgreso());
    }
}

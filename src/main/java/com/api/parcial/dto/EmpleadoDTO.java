package com.api.parcial.dto;

import com.api.parcial.model.Empleado;

public record EmpleadoDTO(
        Long id,
        String nombre,
        Long proyecto
) {
    
    public static EmpleadoDTO parse(Empleado model) {
        return new EmpleadoDTO(model.getId(), model.getNombre(), model.getProyecto());
    }
}

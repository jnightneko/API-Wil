package com.api.parcial.service;

import com.api.parcial.dto.EmpleadoDTO;
import com.api.parcial.model.Empleado;
import com.api.parcial.model.Proyecto;
import com.api.parcial.repository.EmpleadoRepository;
import com.api.parcial.repository.ProyectoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    
    public List<EmpleadoDTO> get() {
        return empleadoRepository.findAll()
                .stream()
                .map((model) -> EmpleadoDTO.parse(model))
                .toList();
    }

    public EmpleadoDTO create(EmpleadoDTO model) {
        Empleado data = Empleado.builder()
                .nombre(model.nombre())
                .proyecto(model.proyecto())
                .build();
        
        return EmpleadoDTO.parse(empleadoRepository.save(data));
    }
    
    public EmpleadoDTO update(EmpleadoDTO model) {
        Empleado data = empleadoRepository.findById(model.id()).orElseThrow();
        data.setNombre(model.nombre());
        data.setProyecto(model.proyecto());
        return EmpleadoDTO.parse(empleadoRepository.save(data));
    }
    
    public void delete(Long id) {
        empleadoRepository.deleteById(id);
    }
}

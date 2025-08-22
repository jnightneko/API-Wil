package com.api.parcial.service;

import com.api.parcial.dto.EmpleadoDTO;
import com.api.parcial.dto.ProyectoDTO;
import com.api.parcial.model.Empleado;
import com.api.parcial.model.Proyecto;
import com.api.parcial.repository.EmpleadoRepository;
import com.api.parcial.repository.ProyectoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProyectoService {
    
    private final ProyectoRepository proyectoRepository;
    
    public List<ProyectoDTO> get() {
        return proyectoRepository.findAll()
                .stream()
                .map((model) -> ProyectoDTO.parse(model))
                .toList();
    }

    public ProyectoDTO create(ProyectoDTO model) {
        Proyecto data = Proyecto.builder()
                .dfin(model.fechaFin())
                .dinicio(model.fechaInicio())
                .progreso(model.progreso())
                .build();
                
        return ProyectoDTO.parse(proyectoRepository.save(data));
    }
    
    public ProyectoDTO update(ProyectoDTO model) {
        Proyecto data = proyectoRepository.findById(model.id()).orElseThrow();
        data.setDfin(model.fechaFin());
        data.setDinicio(model.fechaInicio());
        data.setProgreso(model.progreso());
        return ProyectoDTO.parse(proyectoRepository.save(data));
    }
    
    public void delete(Long id) {
        proyectoRepository.deleteById(id);
    }
}

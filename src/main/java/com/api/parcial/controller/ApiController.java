package com.api.parcial.controller;

import com.api.parcial.dto.EmpleadoDTO;
import com.api.parcial.dto.ProyectoDTO;
import com.api.parcial.service.EmpleadoService;
import com.api.parcial.service.ProyectoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final EmpleadoService empleadoService;
    private final ProyectoService proyectoService;
    
    @GetMapping("/empleado")
    public List<EmpleadoDTO> getEmpleado() {
        return empleadoService.get();
    }
    @PostMapping("/empleado")
    public EmpleadoDTO createEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
        return empleadoService.create(empleadoDTO);
    }
    @PutMapping("/empleado/{id}")
    public EmpleadoDTO updateEmpleado(@PathVariable Long id, @RequestBody EmpleadoDTO empleadoDTO) {
        return empleadoService.update(new EmpleadoDTO(id, empleadoDTO.nombre(), empleadoDTO.proyecto()));
    }
    @DeleteMapping("/empleado/{id}")
    public void deleteEmpleado(@PathVariable Long id) {
        empleadoService.delete(id);
    }
    
    
    @GetMapping("/proyecto")
    public List<ProyectoDTO> getProyecto() {
        return proyectoService.get();
    }
    @PostMapping("/proyecto")
    public ProyectoDTO createProyecto(@RequestBody ProyectoDTO empleadoDTO) {
        return proyectoService.create(empleadoDTO);
    }
    @PutMapping("/proyecto/{id}")
    public ProyectoDTO updateProyecto(@PathVariable Long id, @RequestBody ProyectoDTO empleadoDTO) {
        return proyectoService.update(new ProyectoDTO(id, empleadoDTO.fechaInicio(), empleadoDTO.fechaFin(), empleadoDTO.progreso()));
    }
    @DeleteMapping("/proyecto/{id}")
    public void deleteProyecto(@PathVariable Long id) {
        proyectoService.delete(id);
    }
}

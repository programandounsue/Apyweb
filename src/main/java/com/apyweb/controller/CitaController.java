package com.apyweb.controller;

import com.apyweb.model.Cita;
import com.apyweb.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaRepository citaRepository;

    // Crear  cita
    @PostMapping
    public Cita crearCita(@RequestBody Cita cita) {
        return citaRepository.save(cita);
    }

   
    @GetMapping
    public List<Cita> obtenerCitas() {
        return citaRepository.findAll();
    }

    // Actualizar una cita
    @PutMapping("/{id}")
    public ResponseEntity<Cita> actualizarCita(@PathVariable Long id, @RequestBody Cita detallesCita) {
        Cita cita = citaRepository.findById(id).orElseThrow();
        cita.setPaciente(detallesCita.getPaciente());
        cita.setFecha(detallesCita.getFecha());
        cita.setHora(detallesCita.getHora());
        Cita citaActualizada = citaRepository.save(cita);
        return ResponseEntity.ok(citaActualizada);
    }

    // Eliminar una cita
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCita(@PathVariable Long id) {
        Cita cita = citaRepository.findById(id).orElseThrow();
        citaRepository.delete(cita);
        return ResponseEntity.noContent().build();
    }
}

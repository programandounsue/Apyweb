package com.apyweb.repository;
import com.apyweb.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CitaRepository extends JpaRepository<Cita, Long> {
}
package com.example.demo.repository;

import com.example.demo.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Persona,Long> {

}

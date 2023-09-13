package com.example.hibernatedemo.Repo;

import com.example.hibernatedemo.Models.Kompis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface KompisRepo extends JpaRepository<Kompis, Long> {
    List<Kompis> findByNamn(String namn);
    List<Kompis> findByAdress(String adress);
    List<Kompis> findByTelefonNummer(String telefonNummer);
}


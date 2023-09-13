package com.example.hibernatedemo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Kompis {
    @Id @GeneratedValue
    Long id;

    public Kompis(String namn, String adress, String telefonNummer) {
        this.namn = namn;
        this.adress = adress;
        this.telefonNummer = telefonNummer;
    }

    String namn;
    String adress;
    String telefonNummer;
}

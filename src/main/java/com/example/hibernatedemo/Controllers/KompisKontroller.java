package com.example.hibernatedemo.Controllers;

import com.example.hibernatedemo.Models.Kompis;
import com.example.hibernatedemo.Repo.KompisRepo;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;


@RestController
public class KompisKontroller {
    private final KompisRepo kr;
    private static final Logger log = LoggerFactory.getLogger(KompisKontroller.class);


    public KompisKontroller(KompisRepo kr){
        this.kr = kr;
    }


    @RequestMapping("/add")
    public void addNewKompis (@RequestParam String namn,@RequestParam String adress,@RequestParam String telefonNummer) {
        Kompis newFriend = new Kompis(namn,adress,telefonNummer);
        kr.save(newFriend);
    }

    @RequestMapping("/all")
    public List<Kompis> findAll () {
        return kr.findAll();
    }

    @RequestMapping("/findById/{id}")
    public Kompis findById(@PathVariable Long id){
        return kr.findById(id).orElse(null);
    }

    @RequestMapping("/findByName/{name}")
    public List<Kompis> findById(@PathVariable String name){
        if(kr.findByNamn(name) != null){
            return kr.findByNamn(name);
        }
        else {
            return null;
        }
    }
    @RequestMapping("/findByAdress/{adress}")
    public List<Kompis> findByAdress(@PathVariable String adress){
        if(kr.findByAdress(adress) != null){
            log.info("Found by adress");
            return kr.findByAdress(adress);
        }
        else {
            return null;
        }
    }

    @RequestMapping("/update")
    public List<Kompis> updateKompis(@RequestBody Kompis k){


            Kompis kompisAttUppdatera = kr.findAll().stream().filter(x -> x.getId() == k.getId()).findFirst().orElse(null);

            if(kompisAttUppdatera == null){
                kr.save(k);
                System.out.println("ID är null");

            } else {

                System.out.println("ID är INTE null");
                kompisAttUppdatera.setAdress(k.getAdress());
                kompisAttUppdatera.setNamn(k.getNamn());
                kompisAttUppdatera.setTelefonNummer(k.getTelefonNummer());
                kr.save(kompisAttUppdatera);

            }



        return kr.findAll();

    }




}

package com.example.hibernatedemo;

import com.example.hibernatedemo.Models.Kompis;
import com.example.hibernatedemo.Repo.KompisRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateDemoApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo(KompisRepo kr){
        return args -> {
            kr.save(new Kompis("adde","odensala","0859143277"));
            kr.save(new Kompis("rickard","kyrkan","0859141111"));
            kr.save(new Kompis("sandahl","skogen","0859143121"));
            kr.save(new Kompis("johan","weda","0859141237"));
            kr.save(new Kompis("emil","märsta","0859143277"));
        };
    }

}

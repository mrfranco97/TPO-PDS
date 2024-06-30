package com.francomartin.find_your_guide.seeders;


import com.francomartin.find_your_guide.FindYourGuideApplication;
import com.francomartin.find_your_guide.models.Ciudad;
import com.francomartin.find_your_guide.repositories.CiudadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CiudadSeeder implements CommandLineRunner {

    @Autowired
    private CiudadRepository ciudadRepository;
    private static Logger logger = LoggerFactory.getLogger(FindYourGuideApplication.class);

    @Override
    public void run(String... args) throws Exception {
        if (ciudadRepository.count() == 0) {
            List<Ciudad> ciudades = Arrays.asList(
                    new Ciudad(1L, "Buenos Aires", "Argentina"),
                    new Ciudad(2L, "Madrid", "España"),
                    new Ciudad(3L, "París", "Francia"),
                    new Ciudad(4L, "Londres", "Reino Unido"),
                    new Ciudad(5L, "Nueva York", "Estados Unidos")
            );

            ciudadRepository.saveAll(ciudades);
            logger.info("Ciudades insertadas en la base de datos");
        } else {
            logger.info("Ciudades ya existen en la base de datos. No se realizó ninguna inserción.");
        }
    }
}

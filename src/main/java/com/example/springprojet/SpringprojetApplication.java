package com.example.springprojet;

import Dao.AdresseRepository;
import Dao.KontoRepository;
import Dao.UserRepository;
import Entity.Adresse;
import Entity.Konto;
import Entity.Role;
import Entity.User;
import Security.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;

@SpringBootApplication(scanBasePackages= {"Controller", "Service", "Entity", "Dao", "Security"})
@EnableJpaRepositories("Dao")
@EntityScan("Entity")
public class SpringprojetApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringprojetApplication.class, args);
        System.out.println("Server is running");
    }
@Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
}

    @Bean
    @Transactional
    CommandLineRunner start(AccountService accountService, KontoRepository kontoRepository, UserRepository userRepository,
                          AdresseRepository adresseRepository  ) {


    return args -> {
        if (true){
            User user1 = new User("Hans","Franck",null, 35, "Hfra%25",null,null);
            User user2 = new User("Nono","Willy",null, 27, "5640w",null,null);
            User user3 = new User("Bauer","Ali",null, 16, "Bb!0",null,null);
            User user4 = new User("Priso","Jacques",null, 41, "kui$3",null,null);

            Adresse adresse1 = new Adresse(null, "Am zollstock", 27, 35390, "Gießen");
            Adresse adresse2 = new Adresse(null, "Am Ruegenberg", 12, 29525, "Uelzen");
            Adresse adresse3 = new Adresse(null, "Gruebergerstasse", 8, 30165, "Hannover");
            Adresse adresse4 = new Adresse(null, "Am Bahnhof", 5, 29556, "Suderburg");


            Konto konto1 = new Konto(null,"GIROKONTO");
            Konto konto2 = new Konto(null,"BASICKONTO");

            user1.addAdresse(adresse1);
            user2.addAdresse(adresse2);

            user3.addAdresse(adresse4);
            user4.addAdresse(adresse3);

            user1.setKonto(konto1);
            user3.setKonto(konto2);
            //In DB speichern
            adresseRepository.save(adresse1);
            adresseRepository.save(adresse2);
            adresseRepository.save(adresse3);
            adresseRepository.save(adresse4);

            kontoRepository.save(konto1);
            kontoRepository.save(konto2);


            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
            userRepository.save(user4);

        }

        if (true) {
            accountService.addNewRole(new Role(null,"USER"));
            accountService.addNewRole(new Role(null,"ADMIN"));
            accountService.addNewRole(new Role(null,"CUSTOMER_MANAGER"));
            accountService.addNewRole(new Role(null,"PRODUCT_MANAGER"));

            accountService.addNewUser(new User("Meyer","Sarah",null, 25, "Ms@25",null,null));
            accountService.addNewUser(new User("klaiber","Karim",null, 19, "kka!10",null,null));
            accountService.addNewUser(new User("Weber","Hug",null, 31, "Whu3&",null,null));

            accountService.addRoleToUser("Meyer", "USER");
            accountService.addRoleToUser("klaiber", "USER");
            accountService.addRoleToUser("Weber", "ADMIN");

        }
    };
    }
}

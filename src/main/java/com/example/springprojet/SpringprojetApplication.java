package com.example.springprojet;

import Dao.AdresseRepository;
import Dao.KontoRepository;
import Dao.UserRepository;
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
        System.out.println("Server run");
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

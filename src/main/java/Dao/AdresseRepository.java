package Dao;

import Entity.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdresseRepository extends JpaRepository<Adresse, Long> {

    @Query("select u from User u")
    List<Adresse> findAllAdresses();

     Adresse findById(String id);
}

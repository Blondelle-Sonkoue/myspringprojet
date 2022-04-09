package Dao;

import Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.idUser = :id")
        List<User> findUserByName(@Param(value = "id") Long id);
    @Query("select u from User u")
        List<User> findAllUsers();
    @Query("select u.name from User u")
    List<String> findUserByName();
    @Query("select u.vorname from User u")
         List<String> findUserByVorname();
    @Query("select u.age from User u where u.age > :age")
         List<User> findAllUsersByAge(@Param( value = "age")int age);
      User findByName(String name);
}

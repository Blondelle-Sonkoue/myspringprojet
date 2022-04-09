package Service;

import Entity.User;

import java.util.List;
import java.util.Optional;

public interface LoginServiceInterface {
    public boolean testName(String name);
    public boolean testAge(int age);
    public boolean testEmail(String email);
    public boolean testPassword(String pwd);
    public boolean saveUser (User user);
    public boolean deleteUser(String idUser) ;
    public List<User> findAllUsers ();
    public Optional<User> findUserById (String idUser);
    public boolean testLoginDaten (String name, String pwd);
}

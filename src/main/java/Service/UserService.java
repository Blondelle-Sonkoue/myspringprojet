package Service;

import Dao.UserRepository;
import Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public List<User> findAllUsers(){
        List<User> userList = userRepository.findAllUsers();
        return userList;
    }
    public List<String> findUserByName(){
        return userRepository.findUserByName();
    }
    public List<String> findUserByVorname(){
        return userRepository.findUserByVorname();
    }
    public List<User> findAllUsersByAgeMoreThanX(int age){
        return userRepository.findAllUsersByAge(age);
    }
    public User loadUserByUsername(String name){
        return userRepository.findByName(name);
    }
    public User addUser(User user){
        return userRepository.save(user);
    }
    public User findById(Long id){
        Optional<User> user = userRepository.findById(id);
        return ( user).isPresent()? user.get() : null;
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }
    public boolean deleteUser(Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}

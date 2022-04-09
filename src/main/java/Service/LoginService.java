package Service;

import Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class LoginService implements LoginServiceInterface{
    // name muss mehr als 3 Character  und keine spezielle Sonderzeichnen !"§$%&/()=? erhalten
    @Override
    public boolean testName(String name){
        return name.length() < 4 ? false : testSonderzeichnen(name) ? false : true;
    }
    @Override
    public boolean testAge(int age){
        return age > 17 ? true : false;
    }
    @Override
    public boolean testEmail(String email){
        String regex = ("[A-Za-z0-9_.]+@[a-z0-9-]+\\.[a-z]{1,3}+");
        if(email.matches(regex)){
            return true;
        }
        return false;
    }
    @Override
    public boolean testPassword(String pwd) {
        int countKlasse = 0;
        if (testKleinbuchstabe(pwd)) {
            countKlasse++;
        }
        if (testGroßbuchstabe(pwd)) {
            countKlasse++;
        }
        if (testZahl(pwd)) {
            countKlasse++;
        }
        if (testSonderzeichnen(pwd)) {
            countKlasse++;
        }
        return countKlasse >= 2 ? true : false;
    }
    private boolean testZahl(String wort) {
        String regex =".*[0-9].*";
        return wort.matches(regex);
    }
    private boolean testKleinbuchstabe(String wort) {
        String regex =".*[a-z].*";
        return wort.matches(regex);
    }
    private boolean testGroßbuchstabe(String wort) {
        String regex =".*[A-Z].*";
        return wort.matches(regex);
    }
    private boolean testSonderzeichnen(String wort) {
        String regex =".*["+ Pattern.quote("!\"§$%&/()=?") +"].*";
        return wort.matches(regex);
    }

        @Override
        public boolean saveUser (User user){
            return false;
        }
        @Override
        public boolean deleteUser (String idUser){
            return false;
        }
        @Override
        public List<User> findAllUsers () {
            return null;
        }
        @Override
        public Optional<User> findUserById (String idUser){
            return Optional.empty();
        }
        @Override
        public boolean testLoginDaten (String name, String pwd){
            return false;
        }
    }


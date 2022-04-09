package Service;

import Dao.AdresseRepository;
import Entity.Adresse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdresseService {
    @Autowired

     AdresseRepository adresseRepository;
    public List<Adresse> findAllAdresses(){
        return adresseRepository.findAllAdresses();
       }


    public Adresse save(Adresse adresse) {
        return adresseRepository.save(adresse);
    }
}

package Controller;

import Entity.Adresse;
import Entity.User;
import Service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adresses")

public class AdresseController {
    @Autowired
    AdresseService adresseService;
    @GetMapping(path = "/allAdresses", produces = {MediaType.APPLICATION_NDJSON_VALUE})
    public List<Adresse> findAllAdresses(){
        return adresseService.findAllAdresses();
    }
    @PostMapping("/save")
    public Adresse saveAdresse(Adresse adresse){
        return adresseService.save(adresse);
    }
}

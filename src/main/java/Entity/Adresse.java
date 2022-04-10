package Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String strasse;
    private int nummer;
    private int plz;
    private String stadt;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "adresseList",fetch = FetchType.LAZY)
    private List<User> UserList;

    public  Adresse(){

    }

    public Adresse( Long id, String strasse, int nummer, int plz, String stadt) {
        this.id = id;
        this.strasse = strasse;
        this.nummer = nummer;
        this.stadt = stadt;
        this.plz = plz;
    }
    public void adduser(User user){
        if(UserList == null) UserList = new ArrayList<>();
        UserList.add(user);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int  nummer) {
        this.nummer = nummer;
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }


}

package Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;
    private String name;
    private String vorname;
    private String stadt;

    @JsonIgnore
    private static String password;
    private String email;
    private String role;
    private int age;

    @ManyToMany (fetch = FetchType.LAZY)
    private static Collection<Role> roleCollection = new ArrayList<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name =" user_adresse",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name = "adresse_id")
    )
    private List<Adresse> adresseList;

    @OneToOne
    private Konto konto;

    public User(String name, String vorname, String email, int age, String password, String role , String stadt) {
        this.name = name;
        this.vorname = vorname;
        this.stadt = stadt;
        this.password = password;
        this.email = email;
        this.role = role;
        this.age = age;
        roleCollection = new ArrayList<>();
    }

    public User() {

    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public static <role> List<role> getRoleCollection() {
        return (List<role>) roleCollection;
    }


    public void addRole(Role role){
        roleCollection.add(role);
    }


    public void addAdresse(Adresse adresse){
        if(adresseList == null) adresseList = new ArrayList<>();
        adresseList.add(adresse);
    }
}

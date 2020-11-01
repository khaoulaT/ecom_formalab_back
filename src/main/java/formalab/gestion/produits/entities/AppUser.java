package formalab.gestion.produits.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.xml.bind.v2.TODO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
//UserDetails is an interface so we use implements instead of extends
public class AppUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // auto increment
    private Long id;

    @NotEmpty (message = "Email is required") //Or @NotNull: notnull yaani aslan m baathtouch l valeur aslan
    @Email
    private String email;

    @NotEmpty (message = "Name is required")
    private String name;

    @NotEmpty(message = "Password can't be empty")
    private String password;

    private Date created;

    public AppUser(@NotEmpty @Email String email, @NotEmpty String name, @NotEmpty String password) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.created= new Date();
    }

    public AppUser(@NotEmpty String name, @NotEmpty String password, List<GrantedAuthority> authorities) {
        this.name = name;
        this.password = password;
    }

    public AppUser() {
        this.created= new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //TODO: madhabik l get mtaa l password tetfasa5 bch m yejbdha 7ad
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    //Override methods
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;// bch tkolou heka l login mte3k
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // lezem tkoun true yaani non expired
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // moch bloqué
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // sesion non exipré
    }

    @Override
    public boolean isEnabled() {
        return true; // phase valider men and l admin tkoun false fl db w tetbadel true wa9t ivalidi l adin
    }
}

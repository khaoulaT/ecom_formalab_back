package formalab.gestion.produits.services;

import formalab.gestion.produits.Repositories.UserRepository;
import formalab.gestion.produits.entities.AppUser;
import formalab.gestion.produits.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Bean // m naawdch naamlelha instance // w spring yet7akem fiha kimea l authowired
    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); //methode de hashage //a7sen tari9a w akther secrité
    }

    public List<AppUser> findAll(){
        return userRepository.findAll();
    }

    public AppUser findById(Long id){
        return userRepository.findById(id).get();
    }

    public AppUser save(AppUser user){
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //TODO: get name and pass from DB
        return new AppUser("khawla", passwordEncoder().encode("password"),AuthorityUtils.NO_AUTHORITIES);
    }
}

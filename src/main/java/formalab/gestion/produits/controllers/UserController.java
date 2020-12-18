package formalab.gestion.produits.controllers;

import formalab.gestion.produits.security.JwtUtils;
import formalab.gestion.produits.security.JwtResponse;
import formalab.gestion.produits.security.LoginRequest;
import formalab.gestion.produits.entities.AppUser;
import formalab.gestion.produits.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getAllUsers(){
        List<AppUser> users= userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable Long id){
        AppUser user= userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(value = {"/register"})
    public ResponseEntity<AppUser> createNewUser(@Valid @RequestBody AppUser user){
        AppUser createdUser= userService.save(user);//insert to db
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest loginRequest){

        //step 1 : authenticate
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        //save to security context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //step2: loadUserByUsername
        UserDetails userDetails = userService.loadUserByUsername(loginRequest.getUsername());

        //step3: generate jwt token
        String token = jwtUtils.generateToken(userDetails);
        JwtResponse jwtResponse= new JwtResponse(token);

        return jwtResponse;
    }

    @DeleteMapping("/users/{id}")
    public  ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

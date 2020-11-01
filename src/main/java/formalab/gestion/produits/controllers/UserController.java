package formalab.gestion.produits.controllers;

import formalab.gestion.produits.entities.AppUser;
import formalab.gestion.produits.entities.Category;
import formalab.gestion.produits.entities.Product;
import formalab.gestion.produits.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"","/"})
    public ResponseEntity<List<AppUser>> getAllUsers(){
        List<AppUser> users= userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable Long id){
        AppUser user= userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(value = {"/register"})
    public ResponseEntity<AppUser> createNewUser(@Valid @RequestBody AppUser user){
        AppUser createdUser= userService.save(user);//insert to db
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

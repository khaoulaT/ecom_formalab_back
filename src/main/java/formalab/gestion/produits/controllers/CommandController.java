package formalab.gestion.produits.controllers;

import formalab.gestion.produits.entities.Command;
import formalab.gestion.produits.services.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/commands")
public class CommandController {

    @Autowired
    private CommandService commandService;

    //commands list
    @GetMapping({"","/"})
    public ResponseEntity<List<Command>> getAllCommands(){
        List<Command> commands= commandService.findAll();
        return new ResponseEntity<>(commands, HttpStatus.OK);
    }
    //command by id
    @GetMapping({"/{id}"})
    public ResponseEntity<Command> getCommandById(@PathVariable Long id){
        Command command= commandService.findById(id);
        return new ResponseEntity<>(command, HttpStatus.OK);
    }
    //new command
    @PostMapping({"","/"})
    public ResponseEntity<Command> createNewCommand(@Valid @RequestBody Command command){
        Command createdCommand= commandService.save(command);
        return new ResponseEntity<>(createdCommand, HttpStatus.CREATED);
    }
    //delete command
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommand(@PathVariable Long id){
       commandService.delete(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

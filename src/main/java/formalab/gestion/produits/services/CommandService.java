package formalab.gestion.produits.services;

import formalab.gestion.produits.entities.Command;
import formalab.gestion.produits.repositories.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandService {

    @Autowired
    private CommandRepository commandRepository;

    public List<Command> findAll(){
        return commandRepository.findAll();
    }

    public Command findById(Long id){
        return commandRepository.findById(id).get();
    }

    public Command save(Command command){
        return commandRepository.save(command);
    }

    public void delete(Long id){
        commandRepository.deleteById(id);
    }
}

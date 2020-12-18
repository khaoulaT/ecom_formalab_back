package formalab.gestion.produits.controllers;

import org.springframework.web.bind.annotation.*;

//RestController DON'T return view
@CrossOrigin(origins = "*")
@RestController//@RestController to return JSON or you can just use @Controller
public class HomeController {
    //Navigator use only GET Methods
    //@RequestMapping(value="/hello",methode="GET")//Default Methode is GET
    @GetMapping("/hello")
    public String sayHello(){//methode java
        //return "view";//If it was @Controller
        return "Hello Everyone !";
    }

    @GetMapping("/hello/{name}")//Methode with path parameter
    public String sayHellowithname(@PathVariable String name){
        return "Hello "+name;
    }

    @PostMapping("/bye")
    public String goodbye(){
        return "Goodbye :)";
    }
}

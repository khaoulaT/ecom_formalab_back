package formalab.gestion.produits.controllers;

import org.springframework.web.bind.annotation.*;

//moch server aadi m iraja3ech view
//bch iraja3lek json // si nn tajem taamel @controller akhw
@RestController
public class HomeController {

    //route //navig yebaath ken b methode GET // par defaut te5ou get
//    @RequestMapping(value="/hello",methode="..get")
    @GetMapping("/hello")
    //methode java
    public String sayHello(){
        //kiyebda controller aadi
        //return "view";
        return "say hello";
    }

    @GetMapping("/hello/{name}")
    //autre methode pathparam
    public String sayHellowithname(@PathVariable String name){

        return "Hello "+name;
    }

    @PostMapping("/bye")
    public String goodbye(){
        return "Goodbye :)";
    }
}

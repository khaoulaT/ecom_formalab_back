package formalab.gestion.produits.controllers;

import formalab.gestion.produits.entities.Product;
import formalab.gestion.produits.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Component
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        //ken m taamlch new iraja3lek error null !!!!
        //productService = new ProductService();// t3awadhha bel autowired
        return productService.findAll();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Long id){
        return  productService.findById(id);
    }

    //le produit est envoyer dans le BODY de la requete (RequestBody)
    //le produit vas etre envoyé sous format JSON !!! (NOT AS OBJECT)
    @PostMapping("/products")
    public Product createNewProduct(@RequestBody Product product){
        productService.save(product);
        //insert to db
        return product;
    }

    @DeleteMapping("/product/{id}")
    public  void deleteProduct(@PathVariable Long id){
         productService.delete(id);
    }

}

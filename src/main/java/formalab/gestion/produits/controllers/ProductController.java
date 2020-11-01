package formalab.gestion.produits.controllers;

import formalab.gestion.produits.entities.Product;
import formalab.gestion.produits.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Component
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = {"","/"})
    public ResponseEntity<List<Product>> getAllProducts(){
        //ken m taamlch new iraja3lek error null !!!!
        //productService = new ProductService();// t3awadhha bel autowired
        List<Product> products= productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product product= productService.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    //le produit est envoyer dans le BODY de la requete (RequestBody)
    //le produit vas etre envoyé sous format JSON !!! (NOT AS OBJECT)
    @PostMapping(value = {"","/"})
    public ResponseEntity<Product> createNewProduct(@Valid @RequestBody Product product){

        Product createdProduct= productService.save(product);
        //insert to db
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

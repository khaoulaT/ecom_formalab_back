package formalab.gestion.produits.controllers;

import formalab.gestion.produits.entities.Product;
import formalab.gestion.produits.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@Component
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired//Don't forget it
    private ProductService productService;

    @GetMapping(value = {"","/"})
    public ResponseEntity<List<Product>> getAllProducts(){
        //We should Create new productService or it will return null as an ERROR!!
        //productService = new ProductService();//This is REPLACED by @Autowired
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
    @PostMapping(value = {"","/"})//@Valid: Used to validate the requirement in the product entity Ex: @NotNull
    public ResponseEntity<Product> createNewProduct(@Valid @RequestBody Product product){
        Product createdProduct= productService.save(product);//insert into db
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

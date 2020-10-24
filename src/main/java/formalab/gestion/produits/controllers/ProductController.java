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


    // class Arraylist implementation mn el list
    //    public static List<Product> products= new ArrayList<>();
    public List<Product> products= new ArrayList<>(Arrays.asList(
            new Product(1L,"products1","desc1",100.2),
            new Product(2L,"products2","desc1",100.2),
            new Product(3L, "products3","desc1",100.2)
    ));

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        //ken m taamlch new iraja3lek error null !!!!
        return products;
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Long id){
        for (Product product: this.products){
            if (product.getId() == id ){
                return product;
            }
        }
        return null; // !!!! 404 NOT FOUND
    }

    //le produit est envoyer dans le BODY de la requete (RequestBody)
    //le produit vas etre envoyé sous format JSON !!! (NOT AS OBJECT)
    @PostMapping("/products")
    public Product createNewProduct(@RequestBody Product product){
        products.add(product);
        //insert to db
        return product;
    }

    @DeleteMapping("/product/{id}")
    public  List<Product> deleteProduct(@PathVariable Long id){
        for (Product product: products){
            if (product.getId() == id){
                products.remove(product);
                break;
            }
        }
        return products;
    }

}

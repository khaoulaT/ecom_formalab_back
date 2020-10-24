package formalab.gestion.produits.services;

import formalab.gestion.produits.entities.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//injection de dépendance
@Service
public class ProductService {
    // class Arraylist implementation mn el list
    //    public static List<Product> products= new ArrayList<>();
    public List<Product> products= new ArrayList<>(Arrays.asList(
            new Product(1L,"products1","desc1",100.2),
            new Product(2L,"products2","desc1",100.2),
            new Product(3L, "products3","desc1",100.2)
    ));

    public  List<Product> findAll(){
        return products;
    }

    public  Product findById(Long id){
        for (Product product: products){
            if (product.getId() == id ){
                return product;
            }
        }
        return null; // !!!! 404 NOT FOUND
    }


    public void save(Product product) {
        products.add(product);
    }


    public void  delete(Long id) {
        for (Product product: products){
            if (product.getId() == id){
                products.remove(product);
                break;
            }
        }
    }
}

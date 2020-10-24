package formalab.gestion.produits;

import formalab.gestion.produits.controllers.ProductController;
import formalab.gestion.produits.entities.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProduitsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProduitsApplication.class, args);

//		ProductController.products.add( new Product("products1","desc1",100.2));


	}

}

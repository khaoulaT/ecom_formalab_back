package formalab.gestion.produits.services;

import formalab.gestion.produits.repositories.ProductRepository;
import formalab.gestion.produits.entities.Product;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

//injection de dépendance
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
       return productRepository.findById(id).get();
    }

    public Product save(Product product) {
        return  productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}

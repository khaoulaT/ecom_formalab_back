package formalab.gestion.produits.services;

import formalab.gestion.produits.Repositories.CategoryRespository;
import formalab.gestion.produits.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRespository categoryRespository;

    public List<Category> findAll() {
        return categoryRespository.findAll();
    }
    public Category findById(Long id){
        return categoryRespository.findById(id).get();
    }

    public void save(Category category) {
        categoryRespository.save(category);
    }

    public void  delete(Long id) {
        categoryRespository.deleteById(id);
    }
}

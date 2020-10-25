package formalab.gestion.produits.controllers;

import formalab.gestion.produits.entities.Category;
import formalab.gestion.produits.entities.Product;
import formalab.gestion.produits.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //tnajem m tektebch value= ..

    @GetMapping({"","/"})
    public List <Category> getAllCategories(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id){
        return  categoryService.findById(id);
    }

    @GetMapping("/{id}/products")
    public List<Product> getCategoryProducts(@PathVariable Long id){
        List<Product> products= categoryService.findById(id).getProducts();
        return  products;
    }


    @PostMapping(value = {"","/"})
    public Category createNewCategory(@RequestBody Category category){
        categoryService.save(category);
        //insert to db
        return category;
    }

    @DeleteMapping("/{id}")
    public  void deleteCategory(@PathVariable Long id){
        categoryService.delete(id);
    }
}

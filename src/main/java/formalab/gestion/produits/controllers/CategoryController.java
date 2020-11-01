package formalab.gestion.produits.controllers;

import formalab.gestion.produits.entities.Category;
import formalab.gestion.produits.entities.Product;
import formalab.gestion.produits.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")//General URL
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = {"","/"})//You can remove 'value ='
    public ResponseEntity<List <Category>> getAllCategories(){
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<List<Product>> getCategoryProducts(@PathVariable Long id){
        List<Product> products= categoryService.findById(id).getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping(value = {"","/"})
    public ResponseEntity<Category> createNewCategory(@Valid @RequestBody Category category){
        categoryService.save(category);//insert into db
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

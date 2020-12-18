package formalab.gestion.produits.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity//annotation to tell it's an entity(DB table)
@Table(name = "products")//To change table's name
//class name must start with uppercase
public class Product {

    //@JsonIgnore//annotation pour ne pas afficher cet attribut dans le resultat Json: l'utilité pour sensitive data
    @Id // @Id pour dire que cet attribut est le primary key
    @GeneratedValue(strategy = GenerationType.AUTO) //auto increment
    private Long id;

    //@Column(name = "product_name")//pour changer le nom de le column
    @NotNull(message = "Product name is required")
    @Size(min = 3, message = "Product name must be at least 3 characters")
    private String name;

    @NotNull(message = "description is required")
    private String description;

    @NotNull(message = "price is required")
    private Double price;

    @NotNull(message = "currency is required")
    private String currency;

    @Column(name = "category_id")
    @JsonProperty( "category_id")
    private Long categoryId;

    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    @JsonIgnore // bech tna7i l loup mtaa yo93ed yejbed fl category wl categ tejbd l produit pour l'infini !!
    private Category category;

    //il faut un constructeur vide par defaut pour pouvoir envoyer l objet en RequestBody
    public Product(){
    }

    public Product(Long id, String name, String description, Double price, String currency) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.currency = currency;
    }

    //nestaamlouha fl insert maghir id khater el id auto increment
    public Product(String name, String description, Double price, String currency) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.currency = currency;
    }

    public Product(String name, String description, Double price, String currency, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.currency = currency;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}

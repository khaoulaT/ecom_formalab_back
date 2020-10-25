package formalab.gestion.produits.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

//hedhi bch t9olou eli howa table fl db
@Entity
//hedhi bch tbadelou esmou
@Table(name = "products")
//class maj
public class Product {

    // nameProduct
    //    @JsonIgnore//annotation pour ne pas afficher cet attribut dals le resultat Json: l'utilité pour sensitive data
    @Id // @Id pour dire que cet attribut est le primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // auto increment
    private Long id;
    //  pour changer le nom de le column
    //  @Column(name = "product_name")
    private String name;
    private String description;
    private Double price;

    @Column(name = "category_id")
    @JsonProperty( "category_id")
    private Long categoryId;

    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    @JsonIgnore // bech tna7i l loup mtaa yo93ed yejbed fl category wl categ tejbd l produit pour l'infini !!
    private Category category;

    //il faut un construucteur par defaut pour pouvoir envoyer l objet en RequestBody
    public Product(){
    }

    public Product(Long id, String name, String description, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    //nestaamlouha fl insert maghir id khater l id auto icrement
    public Product(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(String name, String description, Double price, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

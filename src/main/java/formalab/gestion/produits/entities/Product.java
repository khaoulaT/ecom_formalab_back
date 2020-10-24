package formalab.gestion.produits.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

//class maj
public class Product {

    // nameProduct
//    @JsonIgnore//annotation pour ne pas afficher cet attribut dals le resultat Json: l'utilité pour sensitive data
    private Long id;

    private String name;
    private String description;
    private Double price;

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
}

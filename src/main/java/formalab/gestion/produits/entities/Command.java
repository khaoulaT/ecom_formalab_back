package formalab.gestion.produits.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Command {

    @Id
    @GeneratedValue
    private Long id;

    private Date creation;

//    @OneToMany
//    @JoinColumn(name = "product_id")
    @NotNull(message = "product is required")
    private String product;

    @NotNull(message = "quantity is required")
    private Double quantity;

    @NotNull(message = "total amount is required")
    private Double amount;

    public Command() {
        this.creation= new Date();
    }

    public Command(@NotNull(message = "product is required") String product, @NotNull(message = "quantity is required") Double quantity, @NotNull(message = "total amount is required") Double amount) {
        this.product = product;
        this.quantity = quantity;
        this.amount = amount;

        this.creation= new Date();
    }

    public Command(Long id, @NotNull(message = "product is required") String product, @NotNull(message = "quantity is required") Double quantity, @NotNull(message = "total amount is required") Double amount) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.amount = amount;

        this.creation= new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}

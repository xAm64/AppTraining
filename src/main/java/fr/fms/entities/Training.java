package fr.fms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Training implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @Size(max=45)
    private String description;
    @NotNull
    @DecimalMin("0.10")
    private double price;
    @Min(0)
    private int quantity;
    @ManyToOne
    private Category category;

    public Training (String name, String description, double price, int quantity, Category category){
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public Object getId() {
        return id;
    }
}
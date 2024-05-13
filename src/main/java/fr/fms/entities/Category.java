package fr.fms.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Category implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @Size(max= 65)
    private String  description;

    @ToString.Exclude
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Collection<Training> trainings;

    public Category(String name, String description){
        this.name = name;
        this.description = description;
    }
}

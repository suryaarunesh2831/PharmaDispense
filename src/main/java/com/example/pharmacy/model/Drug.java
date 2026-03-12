package com.example.pharmacy.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drugId;
    String genericName;
    String BrandName;
    String strength;
    String route;
    String classification;
    String status;
    @ManyToMany
    @JoinTable(name="Interaction Table", joinColumns = @JoinColumn(name="Drug ID"),
            inverseJoinColumns = @JoinColumn(name="Interaction ID"))
    List<DrugInteraction>drugInteractions=new ArrayList<>();
}

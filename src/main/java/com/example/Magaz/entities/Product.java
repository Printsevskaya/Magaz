package com.example.Magaz.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

        @Id
        private UUID id = UUID.randomUUID();
        @NotNull
        @ManyToOne
        private Magazine nameMagazine;
        private String nameProduct;

        public Product(UUID id, Magazine nameMagazine, String nameProduct) {
            this.id = id;
            this.nameMagazine = nameMagazine;
            this.nameProduct = nameProduct;
        }
}

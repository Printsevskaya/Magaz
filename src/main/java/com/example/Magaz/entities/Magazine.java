package com.example.Magaz.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.UUID;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Magazine {
    @Id
    private UUID id = UUID.randomUUID();
    @NotNull
    private String nameMagazine;
    private String addressMagazine;







    public Magazine(UUID id, String nameMagazine, String addressMagazine) {
        this.id = id;
        this.nameMagazine = nameMagazine;
        this.addressMagazine = addressMagazine;
    }




//    public Magazine() {
//
//    }
//    @NotNull
//    public String getName() {
//        return nameMagazine;
//    }
//    @NotNull
//    public void setName(String nameMagazine) {
//        this.nameMagazine = nameMagazine;
//    }
//
//    public String getAddress() {
//        return addressMagazine;
//    }
//
//    public void setAddress(String addressMagazine) {
//        this.addressMagazine = addressMagazine;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    @Id
//    public UUID getId() {
//        return id;
//    }
}

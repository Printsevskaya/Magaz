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
public class Consumer {
    @Id
    private UUID id = UUID.randomUUID();
    @NotNull
    private String nameConsumer;

    public Consumer(UUID id, String nameConsumer) {
        this.id = id;
        this.nameConsumer = nameConsumer;
    }
}

package com.example.test.tacos;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
public class Taco {

    @Size(min=5, message="Name Must be at least 5 characters long")
    private String name;
    @Size(min=1, message="You Must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

    private Long id;
    private Date createdAt;
}

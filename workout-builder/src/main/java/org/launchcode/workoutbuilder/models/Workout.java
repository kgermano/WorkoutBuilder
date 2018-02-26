package org.launchcode.workoutbuilder.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
public class Workout {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @NotNull
    private String description;


    @ManyToOne
    private Category category;

    @ManyToMany(mappedBy = "workouts")
    private List<Routine> routines;

    public Workout(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public Workout() {
    }

    public int getId() {
        return id;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}

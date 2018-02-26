package org.launchcode.workoutbuilder.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Routine {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=25)
    private String name;


    @ManyToOne
    private Category category;

    @ManyToMany
    private List<Workout> workouts;

    public Routine() {}

    public Routine(String name) {
        this.name = name;
    }

    public void addItem(Workout item) {workouts.add(item);
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

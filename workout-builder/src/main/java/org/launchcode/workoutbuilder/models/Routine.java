package org.launchcode.workoutbuilder.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Routine{

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=25)
    private String name;

    @ManyToOne
    private User user;

    @ManyToOne
    private Category category;


    @ManyToMany
    private List<Workout> workouts;

    public Routine() {}

    public Routine(String name, List<Workout> workouts, Category category) {
        this.name = name;
        this.workouts =  workouts;
        this.category = category;

    }

    public void addItem(Workout item) {workouts.add(item);
    }

    public void addItemList(List<Workout> routineItemList) {new ArrayList<>();}

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
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

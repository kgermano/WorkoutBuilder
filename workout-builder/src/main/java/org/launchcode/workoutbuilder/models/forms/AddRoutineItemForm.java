package org.launchcode.workoutbuilder.models.forms;

import org.launchcode.workoutbuilder.models.Category;
import org.launchcode.workoutbuilder.models.Routine;
import org.launchcode.workoutbuilder.models.Workout;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AddRoutineItemForm {

    private Routine routine;
    private Category category;
    private Iterable<Workout> workouts;

    @NotNull
    private int routineId;

    @NotNull
    private int workoutId;

    @NotNull
    private int categoryId;

    public AddRoutineItemForm() {}


    public AddRoutineItemForm(Iterable<Workout> workouts, Routine routine, Category category) {

        this.routine = routine;
        this.workouts = workouts;
        this.category = category;

    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }

    public Iterable<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(Iterable<Workout> workouts) {
        this.workouts = workouts;
    }

    public int getRoutineId() {
        return routineId;
    }

    public void setRoutineId(int routineId) {
        this.routineId = routineId;
    }

    public int getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(int workoutId) {
        this.workoutId = workoutId;
    }
}

package org.launchcode.workoutbuilder.models.forms;

import org.launchcode.workoutbuilder.models.Routine;
import org.launchcode.workoutbuilder.models.Workout;

import javax.validation.constraints.NotNull;

public class AddRoutineItemForm {

    private Routine routine;
    private Iterable<Workout> workouts;



    @NotNull
    private int routineId;

    @NotNull
    private int workoutId;


    public AddRoutineItemForm() {}


    public AddRoutineItemForm(Iterable<Workout> workouts, Routine routine) {

        this.routine = routine;
        this.workouts = workouts;


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

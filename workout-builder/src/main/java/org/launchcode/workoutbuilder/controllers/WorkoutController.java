package org.launchcode.workoutbuilder.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
@RequestMapping("workout")
public class WorkoutController {

    ArrayList<String> workouts = new ArrayList<>();

    @RequestMapping(value= "")
    public String index(Model model) {


        workouts.add("upper body");
        workouts.add("lower body");
        workouts.add("core");
        workouts.add("full body");


        model.addAttribute("workouts", workouts);
        model.addAttribute("title", "Workouts");
        return "workout/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddWorkoutForm(Model model) {

        model.addAttribute("title", "Your Workout List");

        return "workout/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddWorkoutForm(Model model, @RequestParam String workoutName) {

        workouts.add(workoutName);

        return "redirect:";


    }
}

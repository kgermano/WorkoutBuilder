package org.launchcode.workoutbuilder.controllers;


import org.launchcode.workoutbuilder.models.Category;
import org.launchcode.workoutbuilder.models.Workout;
import org.launchcode.workoutbuilder.models.data.CategoryDao;
import org.launchcode.workoutbuilder.models.data.WorkoutDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
@RequestMapping("workout")
public class WorkoutController {

    @Autowired
    private WorkoutDao workoutDao;

    @Autowired
    private CategoryDao categoryDao;




    @RequestMapping(value= "")
    public String index(Model model) {

        model.addAttribute("workouts", workoutDao.findAll());
        model.addAttribute("title", "All Exercises");

        return "workout/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddWorkoutForm(Model model) {

        model.addAttribute("title", "Exercises");
        model.addAttribute(new Workout());
        model.addAttribute("categories", categoryDao.findAll());

        return "workout/add";
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddWorkoutForm(@ModelAttribute @Valid Workout newWorkout, Errors errors, @RequestParam int categoryId, Model model) {

        if (errors.hasErrors()){
            model.addAttribute("title", "Exercises");

            return "workout/add";

        }
        Category cat = categoryDao.findOne(categoryId);
        newWorkout.setCategory(cat);
        workoutDao.save(newWorkout);
        return "redirect:";

    }



    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveWorkoutForm(Model model) {
        model.addAttribute("workouts", workoutDao.findAll());
        model.addAttribute("title", "Remove Exercise");
        return "workout/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveWorkoutForm(@RequestParam int[] workoutIds) {
        for (int workoutId : workoutIds) {
            workoutDao.delete(workoutId);
        }
        return "redirect:";
    }
}

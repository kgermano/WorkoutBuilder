package org.launchcode.workoutbuilder.controllers;


import org.launchcode.workoutbuilder.models.Category;
import org.launchcode.workoutbuilder.models.Routine;
import org.launchcode.workoutbuilder.models.Workout;
import org.launchcode.workoutbuilder.models.data.CategoryDao;
import org.launchcode.workoutbuilder.models.data.RoutineDao;
import org.launchcode.workoutbuilder.models.data.WorkoutDao;
import org.launchcode.workoutbuilder.models.forms.AddRoutineItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.lang.Math.random;

@Controller
@RequestMapping(value = "routine")
public class RoutineController {

    @Autowired
    private RoutineDao routineDao;

    @Autowired
    private WorkoutDao workoutDao;

    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping(value ="")
    public String index(Model model) {
        model.addAttribute("title", "Your Workouts");
        model.addAttribute("routines", routineDao.findAll());

        return "routine/index";

    }

    @RequestMapping(value ="add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add Workout");
        model.addAttribute(new Routine());
        model.addAttribute("categories", categoryDao.findAll());

        return "routine/add";

    }
//////CREATING RANDOM LIST OF WORKOUTS//////////


    @RequestMapping(value="add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Routine routine, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Workout");
            return "routine/add";
        }
       /* Random rand = new Random();
        List<Workout> randomWorkouts = new ArrayList<>();
        for(int i = 0; i < 7; i++){
            int randomIndex = rand.nextInt(workouts.size());
            routineDao.getClass(workoutDao.workouts.randomIndex));
        }*/
        routineDao.save(routine);


        return "redirect:view/" + routine.getId();
    }



    @RequestMapping(value = "view/{routineId}", method = RequestMethod.GET)
    public String viewRoutine(Model model, @PathVariable int routineId) {

        Routine routine = routineDao.findOne(routineId);
        model.addAttribute("routine", routine);
        model.addAttribute("title", routine.getName());
        model.addAttribute("categories", categoryDao.findAll());
        return "routine/view";
    }

   /* @RequestMapping(value = "add-exercise/{routineId}", method = RequestMethod.GET)
    public String addItem(Model model, @PathVariable int routineId) {

        Routine routine = routineDao.findOne(routineId);
        AddRoutineItemForm form = new AddRoutineItemForm(workoutDao.findAll(),routine);

        model.addAttribute("title", "Add exercise to workout: " + routine.getName());
        model.addAttribute("form", form);

        return "routine/add-exercise";
    }*/

    @RequestMapping(value = "add-exercise", method = RequestMethod.POST)
    public String addItem(Model model, @ModelAttribute @Valid AddRoutineItemForm form, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("form", form);
            return "routine/add-exercise";
        }

        Workout theWorkout = workoutDao.findOne(form.getWorkoutId());
        //Category theCategory = categoryDao.findOne(form.getCategoryId());
        Routine theRoutine = routineDao.findOne(form.getRoutineId());
        theRoutine.addItem(theWorkout);
        routineDao.save(theRoutine);

        return "redirect:/routine/view/" +theRoutine.getId();
    }

}



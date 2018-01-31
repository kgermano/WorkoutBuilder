package org.launchcode.workoutbuilder.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {


    @RequestMapping(value="workout/individual", method = RequestMethod.GET)
    public String getSearchResultsViaAjax(Model model) {
        model.addAttribute("title", "Individual Workout");
        return "workout/individual";
    }

   @RequestMapping(value="workout/individual", method = RequestMethod.POST)
     public String processSearchResultViaAjax(Model model, @PathVariable(value = "exercise_id") Integer exercise_id, String workouts)
    {
       workouts = String.valueOf(exercise_id);
       model.addAttribute("workouts", workouts);
       model.addAttribute("title", "Individual Workout");

        return "redirect";
    }
}

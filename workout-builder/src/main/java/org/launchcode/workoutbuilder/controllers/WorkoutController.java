package org.launchcode.workoutbuilder.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WorkoutController {

    @RequestMapping(value= "")
    @ResponseBody
    public String index() {

        return "New Workout";
    }
}

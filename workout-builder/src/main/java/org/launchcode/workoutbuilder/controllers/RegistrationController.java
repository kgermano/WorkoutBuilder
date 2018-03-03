package org.launchcode.workoutbuilder.controllers;

import org.launchcode.workoutbuilder.models.User;
import org.launchcode.workoutbuilder.models.data.RoutineDao;
import org.launchcode.workoutbuilder.models.data.UserDao;
import org.launchcode.workoutbuilder.models.forms.LoginForm;
import org.launchcode.workoutbuilder.models.forms.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class RegistrationController extends AbstractController {

    @RequestMapping(value = "")
    public String index(Model model, HttpServletRequest request) {
        User currentUser = getUserFromSession(request.getSession());
        model.addAttribute("routines", routineDao.findByUser(currentUser));
        model.addAttribute("user", currentUser);
        return "signup/index";
    }

    @RequestMapping(value = "/registration")
    public String registrationForm(Model model) {

        model.addAttribute(new RegistrationForm());
        model.addAttribute("title", "Register to create workouts!");
        return "signup/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute @Valid RegistrationForm form, Errors errors, HttpServletRequest request) {

        if (errors.hasErrors()) {
            return "signup/registration";
        }

        User existingUser = userDao.findByUserName(form.getUserName());

        if (existingUser != null) {
            errors.rejectValue("userName", "userName.alreadyexists", "A user with that username already exists");
            return "signup/registration";
        }

        User newUser = new User(form.getUserName(), form.getPassword());
        userDao.save(newUser);
        setUserInSession(request.getSession(), newUser);

        return "redirect:";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute(new LoginForm());
        model.addAttribute("title", "Log In");
        return "signup/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute @Valid LoginForm form, Errors errors, org.apache.catalina.servlet4preview.http.HttpServletRequest request) {
        if (errors.hasErrors()) {
            return "signup/login";
        }

        User theUser = userDao.findByUserName(form.getUserName());
        String password = form.getPassword();

        if (theUser == null) {
            errors.rejectValue("userName", "user.invalid", "The given username does not exist");
            return "signup/login";
        }


        if (!theUser.isMatchingPassword(password)) {
            errors.rejectValue("password", "password.invalid", "Invalid password");
            return "signup/login";

        }
        setUserInSession(request.getSession(), theUser);

        return "redirect:";
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "/login";
    }

}
package org.launchcode.workoutbuilder;


import org.launchcode.workoutbuilder.controllers.AbstractController;
import org.launchcode.workoutbuilder.controllers.RegistrationController;
import org.launchcode.workoutbuilder.models.User;
import org.launchcode.workoutbuilder.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LoginInterceptor extends HandlerInterceptorAdapter{

    //user session verification

    @Autowired
    UserDao userDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        List<String> authorizedPages = Arrays.asList("/login", "/registration");

        if (!authorizedPages.contains(request.getRequestURI())) {

            Integer userId = (Integer) request.getSession().getAttribute(AbstractController.userSessionKey);

            if (userId != null) {
                User user = userDao.findOne(userId);


            if (user != null)
                return true;
            }

        response.sendRedirect("/login");
            return false;
        }

        return true;
    }
}

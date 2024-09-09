package com.eazybytes.eazyschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = {"", "/", "home"})
    public String displayHomePage(Model model) {
        /*
         * Role of Model in Spring MVC:
         * 1. Data Holder for the View: The Model object is used to hold data that you want to pass from the controller to the view.
         * It acts as a container for attributes (data) that need to be displayed on the view (e.g., a web page).
         * 2. Adding Attributes: You can add attributes (key-value pairs) to the Model using the addAttribute() method. These
         * attributes are then accessible in the view (e.g., a Thymeleaf template) using the attribute name as a key.
         *
         * In this example, the key "username" is associated with the value "John Doe", and this key-value pair is stored in the Model.
         *
         * Passing Data to the View: When the controller method returns the name of the view (e.g., "home.html"), the Model is
         * automatically passed to that view. The view template can then access the data in the Model and display it to the user. \
         *
         * View Rendering: The view engine (e.g., Thymeleaf, JSP) processes the view template and renders the HTML output by replacing
         * placeholders with the actual data from the Model. For example, in a Thymeleaf template, you might use:
         * <p>Welcome, <span th:text="${username}"></span></p>
         *
         * */
        model.addAttribute("username", "John Doe");
        return "home.html";
    }

}

package com.eazybytes.eazyschool.controller;

import com.eazybytes.eazyschool.model.Holiday;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class HolidaysController {

    /*
     * @PathVariable is used when you want to capture a dynamic value from the URL path itself, rather than from query parameters
     * (which are handled by @RequestParam). This is useful in RESTful APIs where specific resources are accessed via unique
     * identifiers.
     *
     * http://localhost:8080/holidays/all
     * http://localhost:8080/holidays/federal
     * http://localhost:8080/holidays/festival
     * */
    @GetMapping("/holidays/{display}")
    public String displayHolidays(@PathVariable String display, Model model) {
        switch (display) {
            case "festival" -> model.addAttribute("festival", true);
            case "federal" -> model.addAttribute("federal", true);
            default -> {
                model.addAttribute("festival", true);
                model.addAttribute("federal", true);
            }
        }

        List<Holiday> holidays = Arrays.asList(
                new Holiday(" Jan 1 ", "New Year's Day", Holiday.Type.FESTIVAL),
                new Holiday(" Oct 31 ", "Halloween", Holiday.Type.FESTIVAL),
                new Holiday(" Nov 24 ", "Thanksgiving Day", Holiday.Type.FESTIVAL),
                new Holiday(" Dec 25 ", "Christmas", Holiday.Type.FESTIVAL),
                new Holiday(" Jan 17 ", "Martin Luther King Jr. Day", Holiday.Type.FEDERAL),
                new Holiday(" July 4 ", "Independence Day", Holiday.Type.FEDERAL),
                new Holiday(" Sep 5 ", "Labor Day", Holiday.Type.FEDERAL),
                new Holiday(" Nov 11 ", "Veterans Day", Holiday.Type.FEDERAL)
        );
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }
        return "holidays.html";
    }

}

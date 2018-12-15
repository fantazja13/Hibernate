package pl.coderslab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/person")
public class PersonDetailsController {

    @ModelAttribute("skillsToChoose")
    public Set<String> skillsToChoose() {
        Set<String> skillsSet = new HashSet<>();
        skillsSet.add("Java");
        skillsSet.add("JavaScript");
        skillsSet.add("PHP");
        skillsSet.add("Ruby");
        skillsSet.add("Python");
        skillsSet.add("C#");
        return skillsSet;
    }

    @ModelAttribute("hobbiesToChoose")
    public Set<String> hobbiesToChoose() {
        Set<String> hobbiesSet = new HashSet<>();
        hobbiesSet.add("Sport");
        hobbiesSet.add("Muzyka");
        hobbiesSet.add("Podróże");
        hobbiesSet.add("Jedzenie");
        hobbiesSet.add("Gry komputerowe");
        hobbiesSet.add("Gry planszowe");
        return hobbiesSet;
    }

    @GetMapping("/")
    public String showPersonDetailsForm(){

        return "person-details-form";
    }

}

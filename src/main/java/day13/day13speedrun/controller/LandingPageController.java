package day13.day13speedrun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import day13.day13speedrun.model.Employee;

@Controller
@RequestMapping(path={"/","/index"})
public class LandingPageController {
    
    //getMapping to retrieve a page of sorts>>
    //but first you need a amofo model right? 
    //like what are you pointing to?
    @GetMapping
    public ModelAndView showForm(){
        Employee emp = new Employee();
        ModelAndView mav = new ModelAndView();
        mav.addObject("Employee", emp);
        // this binds the attributes making it available.
        mav.setViewName("index");
        // HERE!!!
        return mav;
    }
}

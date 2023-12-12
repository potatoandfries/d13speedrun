package day13.day13speedrun.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import day13.day13speedrun.model.Employee;
import day13.day13speedrun.services.Contacts;

@Controller
@RequestMapping(path={"/contact"})
public class EmployeeForm {
    
    @Autowired
    Contacts cont;

    @PostMapping
    public ModelAndView submitForm(@ModelAttribute("Employee") Employee emp){
        
        ModelAndView mav = new ModelAndView("success");
        cont.ProcessContactData(emp);
        System.out.println(emp.getId());
        mav.setStatus(HttpStatusCode.valueOf(201));
        
        return mav;
    }

    

}



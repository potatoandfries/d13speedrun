package day13.day13speedrun.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import day13.day13speedrun.model.Employee;

@Controller
@RequestMapping(path="/getinfo")
public class GetEmployeeDetails {
    
    @GetMapping
    public ModelAndView showForm(){
    Employee emp = new Employee();
    ModelAndView mav = new ModelAndView();
    mav.addObject("Employee", emp);
    mav.setViewName("getinfo");
    return mav;
    }


    @GetMapping(path={"/{id}"})
    public ModelAndView viewContact(@ModelAttribute("Employee") Employee emp) {
        Path filePath = Paths.get("C:\\Users\\orbis\\data", emp.getId()+".txt");
        ModelAndView mav = new ModelAndView("employeeinfo");
        
        if (Files.exists(filePath)) {
            try {
                // Read data from the file
                String fileContent = Files.readString(filePath);
                mav.addObject("employeeinfo", fileContent);
                
                return mav;
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the IOException (maybe log it or display an error message)
            }
        } else {
            // File not found
            mav.setStatus(HttpStatus.valueOf(201));; // Use HttpStatus enum for setting status
            mav.setViewName("failed.html");
        }
        
        return mav;
        }   
}

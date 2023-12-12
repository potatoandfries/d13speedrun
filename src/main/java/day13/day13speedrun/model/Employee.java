package day13.day13speedrun.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Employee {
    
    @NotBlank
    @Size(min=3,max=64)
    private String name;
    @Email
    private String email;
    @NotBlank
    @Pattern(regexp = "[0-9]{7,}") // 0-9 , 8 numbers
    private String phoneNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employee(){
        
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }

    
}

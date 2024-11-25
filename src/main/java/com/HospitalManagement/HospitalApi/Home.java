package com.HospitalManagement.HospitalApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @RequestMapping("/")
    public String Greet(){
        return "Home Page";
    }
}

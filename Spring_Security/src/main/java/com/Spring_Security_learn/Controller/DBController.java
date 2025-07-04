package com.Spring_Security_learn.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/application")
public class DBController {

    @GetMapping("/Home")
    public String route1(Principal principal) {
        return "I am Home Page   " ;
    }

    @GetMapping("/Category_Viwe")
    public String route2(Principal principal) {
        return "I am CategoryViwe Page   " ;
    }

    @GetMapping("/ProductViwe")
    public String route3(Principal principal) {
        return "I am Product_Viwe Page   " ;
    }

    @GetMapping("/ProductAdd")
    public String route4(Principal principal) {
        return "I am Product_Add Page   ";
    }

    @GetMapping("/CategoryAdd")
    public String route5(Principal principal) {
        return "I am Category_Add Page   " ;
    }




}

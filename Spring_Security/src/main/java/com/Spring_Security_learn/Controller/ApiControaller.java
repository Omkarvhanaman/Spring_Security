package com.Spring_Security_learn.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class ApiControaller
{
    @GetMapping("/route1")
    public String route1(Principal principal)
    {
        return "This is Protected Route1  "+principal.getName();
    }

    @GetMapping("/route2")
    public String route2(Principal principal)
    {
        return "This is Protected Route2  " +principal.getName();
    }

}
/*

  There are 3-4 type handal UserName and Password

1) Using Properties File
                 1) Spring.security.user.name=""
                    Spring.security.user.password=""
                    common Application properties => Google meet all methoed
         this is singal User Config.

 2)  InMemoryUserDetailsManager   :-  using UserDetailsService  data stored in Memory  not DB.



*/
package com.Spring_Security_learn.Service;


import com.Spring_Security_learn.Repository.userRepo;
import com.Spring_Security_learn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomeUserService implements UserDetailsService
{

    @Autowired
    private userRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     User user= userRepo.findByUsername(username).orElseThrow(()->new RuntimeException("User Not found   "+username ));
     return user;
    }
}

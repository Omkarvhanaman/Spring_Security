package com.Spring_Security_learn.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role
{
     @Id
    private  String  roleid;
    private String name;

    //users
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users=new ArrayList<>();

}

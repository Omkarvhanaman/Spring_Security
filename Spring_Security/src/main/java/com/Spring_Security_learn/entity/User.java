package com.Spring_Security_learn.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements UserDetails
{
   @Id
   private String id;

   private String username;

   private String password;

   //Role Connection
   @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   private List <Role> roles=new ArrayList<>();


   //
   @Override
   public Collection<? extends GrantedAuthority> getAuthorities()
   {
   Set<GrantedAuthority> collection=roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
      return collection;
   }

   @Override
   public String getUsername() {
      return this.username;
   }
   @Override
   public String getPassword() {
      return this.password;
   }

   @Override
   public boolean isAccountNonExpired() {
      return true;
   }

   @Override
   public boolean isAccountNonLocked() {
      return true;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }

   @Override
   public boolean isEnabled() {
      return true;
   }
}

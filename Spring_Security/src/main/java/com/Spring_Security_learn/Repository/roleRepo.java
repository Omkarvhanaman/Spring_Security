package com.Spring_Security_learn.Repository;


import com.Spring_Security_learn.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface roleRepo extends JpaRepository<Role,String>
{
    Optional<Role> findByName(String name);
}

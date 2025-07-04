package com.Spring_Security_learn.Repository;

import com.Spring_Security_learn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepo extends JpaRepository<User,String>
{

    Optional<User> findByUsername(String UserName);
}

package com.demo.db_secure.repositories;

import java.util.Optional;

import com.demo.db_secure.domains.users.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface UserRepo extends CrudRepository<User, Long>{
    @Query("SELECT p FROM User p WHERE p.userName = ?1")
    Optional<User> findByUserName(String userName);
}

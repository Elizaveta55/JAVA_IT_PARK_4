package com.company.app.repositories;

import com.company.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long>{
    Optional<User> findByConfirmString(String confirmString);
    Optional<User> findByEmail(String email);
}

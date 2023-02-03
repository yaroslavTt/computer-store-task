package com.example.app.repository;

import com.example.app.model.user.AuthenticationToken;
import com.example.app.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Long> {

    AuthenticationToken findByUser(User user);
}

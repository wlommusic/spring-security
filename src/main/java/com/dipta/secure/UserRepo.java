package com.dipta.secure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dipta.secure.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
User findUserByName(String name);
}

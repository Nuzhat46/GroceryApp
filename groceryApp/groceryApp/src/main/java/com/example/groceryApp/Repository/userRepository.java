package com.example.groceryApp.Repository;

import com.example.groceryApp.Model.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<user, Long> {

}

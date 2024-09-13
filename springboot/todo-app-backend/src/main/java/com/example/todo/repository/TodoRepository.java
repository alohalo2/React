package com.example.todo.repository;

import com.example.todo.entitiy.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import  java.util.List;

import java.util.Collection;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByMemberUsername(String username);
}

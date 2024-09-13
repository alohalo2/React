package com.example.todo.service;

import com.example.todo.dto.TodoDto;
import com.example.todo.entitiy.Member;

import java.util.List;

public interface TodoService {
    List<TodoDto> post(TodoDto todoDto, Member member);

    List<TodoDto> findAll(Member member);

    List<TodoDto> deleteById(Long id, Member member);

    List<TodoDto> modify(TodoDto todoDto, Member member);
}

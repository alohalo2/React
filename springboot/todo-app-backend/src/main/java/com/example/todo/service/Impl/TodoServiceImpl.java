package com.example.todo.service.Impl;

import com.example.todo.dto.TodoDto;
import com.example.todo.entitiy.Member;
import com.example.todo.repository.TodoRepository;
import com.example.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.todo.entitiy.Todo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    @Override
    public List<TodoDto> post(TodoDto todoDto, Member member) {
        todoRepository.save(todoDto.toEntity(member));
        return todoRepository.findByMemberUsername(member.getUsername()).stream().map(Todo::toDto).toList();
    }

    @Override
    public List<TodoDto> findAll(Member member) {
        return todoRepository.findByMemberUsername(member.getUsername()).stream().map(Todo::toDto).toList();
    }

    @Override
    public List<TodoDto> deleteById(Long id, Member member) {
        todoRepository.deleteById(id);
        return todoRepository.findByMemberUsername(member.getUsername()).stream().map(Todo::toDto).toList();
    }

    @Override
    public List<TodoDto> modify(TodoDto todoDto, Member member) {
        todoDto.setChecked(!todoDto.isChecked());

        todoRepository.save(todoDto.toEntity(member));
        return todoRepository.findByMemberUsername(member.getUsername()).stream().map(Todo::toDto).toList();
    }


}

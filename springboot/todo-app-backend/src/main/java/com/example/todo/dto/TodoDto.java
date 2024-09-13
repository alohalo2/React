package com.example.todo.dto;

import com.example.todo.entitiy.Member;
import com.example.todo.entitiy.Todo;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoDto {
    private Long id;
    private String text;
    private boolean checked;
    private Long member_id;

    public Todo toEntity(Member member) {
        return Todo.builder()
                    .id(this.id)
                    .text(this.text)
                    .checked(this.checked)
                    .member(member)
                    .build();
    }
}

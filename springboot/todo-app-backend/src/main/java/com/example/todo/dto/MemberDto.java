package com.example.todo.dto;

import com.example.todo.entitiy.Member;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {
    private Long id;
    private String username;
    private String password;
    private String role;
    private String token;

    public Member toEntitiy(){
        return Member.builder()
                .id(this.id)
                .username(this.username)
                .password(this.password)
                .role(this.role)
                .build();
    }

}

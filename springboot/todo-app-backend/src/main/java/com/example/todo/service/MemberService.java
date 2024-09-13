package com.example.todo.service;


import com.example.todo.dto.MemberDto;

public interface MemberService {

    MemberDto join(MemberDto memberDto);

    MemberDto login(MemberDto memberDto);
}

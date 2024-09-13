package com.bit.boardappbackend.service.impl;

import com.bit.boardappbackend.dto.MemberDto;
import com.bit.boardappbackend.entity.Member;
import com.bit.boardappbackend.jwt.JwtProvider;
import com.bit.boardappbackend.repository.MemberRepository;
import com.bit.boardappbackend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;
    private final JwtProvider jwtProvider;

    @Override
    public Map<String, String> usernameCheck(String username) {
        Map<String, String> userCheckMsgMap = new HashMap<>();

        long usernameCheck = memberRepository.countByUsername(username);

        if(usernameCheck == 0)
            userCheckMsgMap.put("usernameCheckMsg", "available username");
        else
            userCheckMsgMap.put("usernameCheckMsg", "invalid username");

        return userCheckMsgMap;
    }

    @Override
    public Map<String, String> nicknameCheck(String nickname) {
        Map<String, String> nicknameCheckMsgMap = new HashMap<>();

        long nicknameCheck = memberRepository.countByNickname(nickname); // long인 이유는 countByNickname이 count로 오기 때문이다.

        if(nicknameCheck == 0)
            nicknameCheckMsgMap.put("nicknameCheckMsg", "available username");
        else
            nicknameCheckMsgMap.put("nicknameCheckMsg", "invalid username");

        return nicknameCheckMsgMap;
    }

    @Override
    public MemberDto join(MemberDto memberDto) {
        memberDto.setRole("ROLE_USER");
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));

        MemberDto joinedMemberDto = memberRepository.save(memberDto.toEntiy()).toDto();

        joinedMemberDto.setPassword("");

        return joinedMemberDto;
    }

    @Override
    public MemberDto login(MemberDto memberDto) {
        Member member = memberRepository.findByUsername(memberDto.getUsername()).orElseThrow(
                () -> new RuntimeException("uesrname not exist")
        );

        if(!passwordEncoder.matches(memberDto.getPassword(), member.getPassword())) {
            throw new RuntimeException("wrong password");
        }

        MemberDto loginedMemberDto = member.toDto();

        loginedMemberDto.setPassword("");
        loginedMemberDto.setToken(jwtProvider.createJwt(member));

        return loginedMemberDto;
    }


}

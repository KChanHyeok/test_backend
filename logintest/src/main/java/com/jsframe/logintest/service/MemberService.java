package com.jsframe.logintest.service;

import com.jsframe.logintest.entity.Member;
import com.jsframe.logintest.repository.MemberRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public String joinMember(Member member) {
        String result = null;
        try {
            memberRepository.save(member);
            result = "가입 성공";
        }catch (Exception e){
            e.printStackTrace();
            result = "가입 실패";
        }
        return result;
    }
}

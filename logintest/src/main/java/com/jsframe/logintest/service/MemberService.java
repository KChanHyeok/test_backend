package com.jsframe.logintest.service;

import com.jsframe.logintest.entity.Member;
import com.jsframe.logintest.repository.MemberRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Log
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String joinMember(Member member) {
        String result = null;
        try {
            if(member.getMemberPwd()!=null){
                member.setMemberPwd(encoder.encode(member.getMemberPwd()));
            }
            memberRepository.save(member);
            result = "가입 성공";
        }catch (Exception e){
            e.printStackTrace();
            result = "가입 실패";
        }
        return result;
    }

    public Map<String, Object> loginMember(Member member) {

        Map<String, Object> result = new HashMap<>();

        Member dbMember = null;
        try{
            dbMember = memberRepository.findById(member.getMemberId()).orElseGet(Member::new);
            if(dbMember.getMemberId()!=null){
                if(encoder.matches(member.getMemberPwd(), dbMember.getMemberPwd())){
                    result.put("state","로그인 완료");
                    result.put("memberId",dbMember.getMemberId());
                    result.put("memberName", dbMember.getMemberName());
                }else {
                    result.put("state","비밀번호가 틀림");
                }
            }else {
                result.put("state","해당아이디 없음");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public String repetitionCheckId(String memberId) {
        String result = "사용가능";
        try{
            memberRepository.findById(memberId).get();
            result = "사용불가";
        }catch (Exception e){
            e.printStackTrace();
        }
        return  result;

    }
}

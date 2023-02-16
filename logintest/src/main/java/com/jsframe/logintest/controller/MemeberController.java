package com.jsframe.logintest.controller;

import com.jsframe.logintest.entity.Member;
import com.jsframe.logintest.service.MemberService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Log
public class MemeberController {

    @Autowired
    private MemberService mServ;

@PostMapping("/joinMember")
private String joinMember(@RequestBody Member member){
    log.info("joinMember()");

  return mServ.joinMember(member);
}

@GetMapping("/repetitionCheckId")
    private String repetitionCheckId(@RequestParam String memberId){
    log.info("repetitionCheckId");
    return mServ.repetitionCheckId(memberId);
}

@PostMapping("/loginMember")
    private Map<String, Object> loginMember(@RequestBody Member member){
    return mServ.loginMember(member);
}

    }

package com.jsframe.logintest.controller;

import com.jsframe.logintest.entity.Member;
import com.jsframe.logintest.service.MemberService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    }

package com.jsframe.logintest.controller;

import com.jsframe.logintest.entity.Feed;
import com.jsframe.logintest.service.FeedService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@Log
public class FeedController {

    @Autowired
    private FeedService fServ;

    @PostMapping("/insertFeed")
    public String insertFeed(@RequestPart(value = "uploadImage") List<MultipartFile> files,
                             @RequestPart(value = "data") Feed newfeed, HttpSession session) {
        log.info("insertFeed()");
        log.info(files + "파일 확인");
        log.info(newfeed + "데이터 확인");
        log.info(session + " 세션 데이터");

        return fServ.insertFeed(newfeed, files, session);
    }

    @GetMapping("/FeedInquiry")
    public List<Feed> FeedInquiry(@RequestParam Integer page, HttpSession session){
        log.info("FeedInquiry");

        return fServ.FeedInquiry(page, session);
    }

    @DeleteMapping("/deleteFeed")
    public String deleteFeed(@RequestBody Feed feed, HttpSession session) {
        log.info("deleteFeed()");
        return fServ.deleteFeed(feed, session);
    }
}

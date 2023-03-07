package com.jsframe.logintest.service;

import com.jsframe.logintest.entity.Feed;
import com.jsframe.logintest.entity.FeedFile;
import com.jsframe.logintest.repository.FeedFileRepository;
import com.jsframe.logintest.repository.FeedRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Log
public class FeedService {

    @Autowired
    private FeedFileRepository feedFileRepository;

    @Autowired
    private FeedRepository feedRepository;

    public String insertFeed(Feed newfeed, List<MultipartFile> files, HttpSession session) {
        String result = null;

        try {
            Feed saveFeed = feedRepository.save(newfeed);
            if(files != null) {
                List<FeedFile> feedFiles = fileupload(saveFeed,files,session);
                log.info("feedFiles : " + feedFiles);
                saveFeed.setFfList(feedFiles);
            }
            result = "ok";
        }catch (Exception e){
            result = "fail";
        }

        return result;
    }

    private List<FeedFile> fileupload(Feed newFeed, List<MultipartFile> files, HttpSession session) throws Exception {
        log.info("fileupload()");

        List<FeedFile> feedFiles = new ArrayList<>();
        String realPath = session.getServletContext().getRealPath("/");
        log.info("realPath : " + realPath);
        
        realPath += "images/";
        File folder = new File(realPath);
        
        if(folder.isDirectory() == false){
            folder.mkdir();
        }
        
        for(MultipartFile mf : files) {
            String orname = mf.getOriginalFilename(); // 업로드 파일명 가져오기
            if(orname.equals("")){
                //업로드하는 파일이 없는 상태.
                return null;
            }

            FeedFile ff = new FeedFile();
            ff.setFeedCode(newFeed.getFeedNumber());
            ff.setFeedFileImg(orname);
            String sysname = System.currentTimeMillis() + orname.substring(orname.lastIndexOf("."));
            ff.setFeedFileSaveimg(sysname);
            //업로드하는 파일을 upload 폴더에 저장.
            File file = new File(realPath + sysname);
            //파일 저장(upload 폴더)
            mf.transferTo(file);

            //파일 정보를 DB에 저장
            feedFiles.add(feedFileRepository.save(ff));
        }
        return feedFiles;
    }
}

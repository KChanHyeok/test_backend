package com.jsframe.logintest.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "feed")
public class Feed {

    @Id
    private long feedNumber = System.currentTimeMillis();

    @Column(nullable = false, length = 2000)
    private String feedContent;

    @Column(nullable = false, length = 50)
    private String feedDate;

//    회원 외래키
    @Column(length = 20)
    private String memberId;

    //파일 외래키
    @Transient
    private List<FeedFile> ffList;
}
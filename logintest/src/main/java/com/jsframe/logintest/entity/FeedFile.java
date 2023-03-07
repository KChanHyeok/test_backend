package com.jsframe.logintest.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "feedFile")
public class FeedFile {
    @Id
    private long feedFileCode = System.currentTimeMillis();

    @Column(nullable = false, length = 50)
    private long feedCode;

    @Column(nullable = false, length = 100)
    private String feedFileImg;

    @Column(nullable = false, length = 100)
    private String feedFileSaveimg;
}

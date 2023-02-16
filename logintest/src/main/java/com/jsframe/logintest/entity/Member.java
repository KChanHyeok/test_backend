package com.jsframe.logintest.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="member")
public class Member {
    @Id
    @Column(length = 30)
    private String memberId;

    @Column(nullable = false, length = 10)
    private String memberName;

    @Column(nullable = true, length = 100)
    private String memberPwd;

}

package com.jsframe.logintest.repository;

import com.jsframe.logintest.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String > {
}

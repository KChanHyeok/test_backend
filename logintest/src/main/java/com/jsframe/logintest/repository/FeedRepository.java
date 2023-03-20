package com.jsframe.logintest.repository;

import com.jsframe.logintest.entity.Feed;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FeedRepository extends CrudRepository<Feed, Long> {

    List<Feed> findAll(Pageable feedPageable);
}

package com.jsframe.logintest.repository;

import com.jsframe.logintest.entity.FeedFile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FeedFileRepository extends CrudRepository<FeedFile, Long> {

    List<FeedFile> findAllByFeedCode(Long feedCode);
}

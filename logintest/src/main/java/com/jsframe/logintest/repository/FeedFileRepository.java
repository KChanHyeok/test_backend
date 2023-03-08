package com.jsframe.logintest.repository;

import com.jsframe.logintest.entity.FeedFile;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface FeedFileRepository extends CrudRepository<FeedFile, Long> {
    @Transactional
    void deleteAllByFeedCode(Long feedCode);

    List<FeedFile> findAllByFeedCode(Long feedCode);
}

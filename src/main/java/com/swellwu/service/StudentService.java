package com.swellwu.service;

import com.swellwu.config.aop.InsertLogs;
import com.swellwu.config.aop.LogsEnum;
import com.swellwu.config.aop.SearchLogs;
import com.swellwu.po.Student;
import org.apache.ibatis.annotations.Insert;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * <p>Description:</p>
 *
 * @author xinjian.wu
 * @date 2017-07-02
 */
public interface StudentService {

    Student getStudentById(Integer id);

    void insert(Student student);

    void delete(Integer id);
}

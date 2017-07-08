package com.swellwu.service.impl;

import com.swellwu.config.aop.InsertLogs;
import com.swellwu.config.aop.LogsEnum;
import com.swellwu.config.aop.SearchLogs;
import com.swellwu.dao.StudentMapper;
import com.swellwu.po.Student;
import com.swellwu.po.StudentExample;
import com.swellwu.service.StudentService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Description:</p>
 *
 * @author xinjian.wu
 * @date 2017-07-02
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    @SearchLogs(parentCode = LogsEnum.MEM_M1,funcCode = LogsEnum.MEM_M1_F1)
    public Student getStudentById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    @InsertLogs(parentCode = LogsEnum.MEM_M1, funcCode = LogsEnum.MEM_M1_F2)
    public void insert(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public void delete(Integer id) {
        studentMapper.deleteByPrimaryKey(id);
    }
}

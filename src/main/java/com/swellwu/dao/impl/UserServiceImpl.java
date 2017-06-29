package com.swellwu.dao.impl;

import com.swellwu.dao.UserService;
import com.swellwu.mapper.UserMapper;
import com.swellwu.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * <p>Description:</p>
 *
 * @author xinjian.wu
 * @date 2017-06-29
 */
@Service
@CacheConfig(cacheNames = "users")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    @Cacheable(key = "#p0")
    public User findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    @CachePut(key = "#p0.id")
    public User insert(User user) {
        userMapper.insert(user);
        return user;
    }
}

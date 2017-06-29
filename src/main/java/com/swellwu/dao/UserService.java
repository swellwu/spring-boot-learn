package com.swellwu.dao;

import com.swellwu.po.User;

/**
 * <p>Description:</p>
 *
 * @author xinjian.wu
 * @date 2017-06-29
 */

public interface UserService {

    User findById(Long id);

    User insert(User user);
}

package org.example.mockito.dao;

import org.example.mockito.entity.User;

import javax.annotation.Resource;

/**
 * ClassName: UserDao
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/10 16:43
 */

public interface UserDao {
    User getUser(Long id);

    User edit(User user);
}

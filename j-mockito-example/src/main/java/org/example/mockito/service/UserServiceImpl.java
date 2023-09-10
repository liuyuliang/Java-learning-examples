package org.example.mockito.service;

import org.example.mockito.dao.UserDao;
import org.example.mockito.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserServiceImpl
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/10 16:42
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public User edit(User user) {
        return userDao.edit(user);
    }
}

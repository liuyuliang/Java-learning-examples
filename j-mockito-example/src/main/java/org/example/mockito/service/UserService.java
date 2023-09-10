package org.example.mockito.service;

import org.example.mockito.entity.User;

/**
 * ClassName: UserService
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/10 16:40
 */
public interface UserService {
    User getUser(Long id);

    User edit(User user);
}

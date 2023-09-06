package org.example.mybatis.mapper;

import org.example.mybatis.entity.User;
import org.springframework.stereotype.Repository;

/**
 * ClassName: R
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/6 10:55
 */


@Repository
public interface UserMapper {
    int insertUser(User user);

    User getByUserNameAndPassword(User user);
}

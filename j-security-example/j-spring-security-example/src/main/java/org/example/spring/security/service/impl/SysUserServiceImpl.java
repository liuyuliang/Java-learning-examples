package org.example.spring.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.spring.security.entity.SysUser;
import org.example.spring.security.service.SysUserService;
import org.example.spring.security.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

/**
* @author gugnv
* @description 针对表【sys_user(用户表)】的数据库操作Service实现
* @createDate 2023-10-20 17:09:22
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

}





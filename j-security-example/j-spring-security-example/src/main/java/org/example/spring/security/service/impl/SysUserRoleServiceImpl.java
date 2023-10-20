package org.example.spring.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.spring.security.entity.SysUserRole;
import org.example.spring.security.service.SysUserRoleService;
import org.example.spring.security.mapper.SysUserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author gugnv
* @description 针对表【sys_user_role】的数据库操作Service实现
* @createDate 2023-10-20 17:09:26
*/
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole>
    implements SysUserRoleService{

}





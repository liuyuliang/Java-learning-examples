package org.example.spring.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.spring.security.entity.SysRole;
import org.example.spring.security.service.SysRoleService;
import org.example.spring.security.mapper.SysRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author gugnv
* @description 针对表【sys_role(角色表)】的数据库操作Service实现
* @createDate 2023-10-20 17:09:12
*/
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole>
    implements SysRoleService{

}





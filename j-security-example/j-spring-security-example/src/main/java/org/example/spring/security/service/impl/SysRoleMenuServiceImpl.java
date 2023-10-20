package org.example.spring.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.spring.security.entity.SysRoleMenu;
import org.example.spring.security.service.SysRoleMenuService;
import org.example.spring.security.mapper.SysRoleMenuMapper;
import org.springframework.stereotype.Service;

/**
* @author gugnv
* @description 针对表【sys_role_menu】的数据库操作Service实现
* @createDate 2023-10-20 17:09:18
*/
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu>
    implements SysRoleMenuService{

}





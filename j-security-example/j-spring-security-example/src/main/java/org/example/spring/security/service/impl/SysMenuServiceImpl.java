package org.example.spring.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.spring.security.entity.SysMenu;
import org.example.spring.security.service.SysMenuService;
import org.example.spring.security.mapper.SysMenuMapper;
import org.springframework.stereotype.Service;

/**
* @author gugnv
* @description 针对表【sys_menu(菜单表)】的数据库操作Service实现
* @createDate 2023-10-20 17:07:52
*/
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu>
    implements SysMenuService{

}





package org.example.spring.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.spring.security.entity.SysMenu;
import org.example.spring.security.entity.SysRoleMenu;
import org.example.spring.security.entity.SysUser;
import org.example.spring.security.entity.SysUserRole;
import org.example.spring.security.mapper.SysMenuMapper;
import org.example.spring.security.mapper.SysRoleMenuMapper;
import org.example.spring.security.mapper.SysUserRoleMapper;
import org.example.spring.security.service.SysUserService;
import org.example.spring.security.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gugnv
 * @description 针对表【sys_user(用户表)】的数据库操作Service实现
 * @createDate 2023-10-20 17:09:22
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
        implements SysUserService, UserDetailsService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name", username);
        SysUser sysUser = sysUserMapper.selectOne(queryWrapper);
        if (sysUser == null) {
            throw new UsernameNotFoundException("用户名未找到");
        }
//        根据用户名查找角色
        QueryWrapper userRoleQuery = new QueryWrapper();
        userRoleQuery.eq("user_id", sysUser.getId());
        List<SysUserRole> sysUserRole = sysUserRoleMapper.selectList(userRoleQuery);
//        根据角色查询菜单
        QueryWrapper roleMenu = new QueryWrapper();
        List<Long> roleList = sysUserRole.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        roleMenu.in("role_id", roleList);


        List<SysRoleMenu> sysRoleMenu = sysRoleMenuMapper.selectList(roleMenu);
//        根据菜单查询权限
        List<Long> menuList = sysRoleMenu.stream().map(SysRoleMenu::getMenuId).collect(Collectors.toList());
        QueryWrapper menu = new QueryWrapper();
        menu.in("id", menuList);
        List<SysMenu> sysMenu = sysMenuMapper.selectList(roleMenu);
        List<String> perms = sysMenu.stream().map(SysMenu::getPerms).collect(Collectors.toList());
        sysUser.setAuthorities(AuthorityUtils.createAuthorityList(perms));
        return null;

    }
}





package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo = userDao.findByUserName(username);

        User user = new User(userInfo.getUsername(),"{noop}"+ userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getList(userInfo.getRoles()));

        return user;
    }

    public List<SimpleGrantedAuthority> getList(List<Role> list) {

        ArrayList<SimpleGrantedAuthority> arrayList = new ArrayList<>();

        for (Role role : list) {
            arrayList.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }

        return arrayList;
    }
}

package com.panshi.demo.service;

import com.panshi.demo.domain.UserDao;
import com.panshi.demo.domain.UserVo;

public interface UserService {
    UserVo query(int page, int limit, String name);

    void stuAdd(UserDao user);

    void stuDelete(String id);

    void updateUser(UserDao user);
}

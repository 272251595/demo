package com.panshi.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panshi.demo.domain.UserDao;
import com.panshi.demo.domain.UserVo;
import com.panshi.demo.mapper.UserMapper;
import com.panshi.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public UserVo query(int page, int limit, String name) {
        int startId=(page-1)*limit;

        int i = userMapper.queryAll(name);
        List<UserDao> list = userMapper.queryLick(startId,limit,name);
        UserVo vo = new UserVo();
        vo.setCount(i);
        vo.setData(list);

        return vo;

    }
    @Override
    public void stuAdd(UserDao user){
       
        userMapper.stuAdd(user);
    }

    @Override
    public void stuDelete(String id) {
       
        userMapper.studelete(id);
    }
	@Override
	public void updateUser(UserDao user) {
		userMapper.updateUser(user);
		
	}
}

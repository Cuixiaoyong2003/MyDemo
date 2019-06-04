package com.cxy.by.app.dao;

import org.springframework.stereotype.Component;

import com.cxy.by.rpc.pojo.User;

@Component
public interface UserDao {

	public User findUserById(long id);
}

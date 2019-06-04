package com.cxy.by.app.service;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.cxy.by.app.dao.UserDao;
import com.cxy.by.rpc.pojo.User;
import com.cxy.by.rpc.service.UserService;

/**
 * 
 * @author admin
 * @version 1.0.0.0
 *          特别注意：这里的service要引dubbo的，因为作为一个dubbo服务提供者，启动时需要知道发布的服务是在哪，不使用dubbo提供的@service注解会出现问题的。
 *
 */
/*@Service(timeout = 6000, version = "1.0", group = "demo-dubbo", retries = 0, interfaceClass = UserService.class)*/
@Service(timeout = 6000, version = "1.0", group = "demo-dubbo", retries = 0, interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {

	/*
	 * public Object login(int userId, String password) { // TODO Auto-generated
	 * method stub return null; }
	 */

	@Resource
	UserDao userDao;

	public User findUserById(long id) {
		return this.userDao.findUserById(id);
	}

}

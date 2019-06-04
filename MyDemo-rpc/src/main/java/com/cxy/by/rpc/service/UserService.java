package com.cxy.by.rpc.service;

import com.cxy.by.rpc.pojo.User;

/**
 * 用户数据服务接口
 * 
 * @author admin
 *
 */
public interface UserService {

	/* Object login(int userId, String password); */
	User findUserById(long id);

}

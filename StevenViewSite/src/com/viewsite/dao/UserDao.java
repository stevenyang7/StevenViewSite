package com.viewsite.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.viewsite.domain.User;

/**
 * 用户DAO
 * 
 * @author: 刘壮洪
 * @version: 2013-7-24 上午12:00:52
 */
@Repository
public class UserDao extends BaseDao<UserDao> {

	/**
	 * GET_USER_BY_USERNAME: 获取具体用户名的User PO对象HQL语句
	 * 
	 * @since Version 1.0
	 */
	private final String GET_USER_BY_USERNAME = "from User u where u.userName = ?";

	/**
	 * QUERY_USER_BY_USERNAME: 模糊查询具体用户名的User PO对象
	 * 
	 * @since Version 1.0
	 */
	private final String QUERY_USER_BY_USERNAME = "from User u where u.userName like ?";

	/**
	 * 根据用户名查询User对象
	 * 
	 * @author: 刘壮洪
	 * @param userName
	 *            用户名
	 * @return 对应userName的User对象，如果不存在，返回null。
	 * @version: 2013-7-24 上午12:03:48
	 */
	public User getUserByUserName(String userName) {
		List<User> users = (List<User>) find(GET_USER_BY_USERNAME, userName);
		if (users.size() == 0) {
			return null;
		} else {
			return users.get(0);
		}
	}

	/**
	 * 根据用户名为模糊查询条件，查询出所有前缀匹配的User对象
	 * 
	 * @author: 刘壮洪
	 * @param userName
	 *            用户名查询条件
	 * @return 用户名前缀匹配的所有User对象
	 * @version: 2013-7-24 上午12:04:17
	 */
	public List<User> queryUserByUserName(String userName) {
		return (List<User>) find(QUERY_USER_BY_USERNAME, userName + "%");
	}

}

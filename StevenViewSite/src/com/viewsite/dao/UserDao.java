package com.viewsite.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.viewsite.domain.User;

/**
 * �û�DAO
 * 
 * @author: ��׳��
 * @version: 2013-7-24 ����12:00:52
 */
@Repository
public class UserDao extends BaseDao<UserDao> {

	/**
	 * GET_USER_BY_USERNAME: ��ȡ�����û�����User PO����HQL���
	 * 
	 * @since Version 1.0
	 */
	private final String GET_USER_BY_USERNAME = "from User u where u.userName = ?";

	/**
	 * QUERY_USER_BY_USERNAME: ģ����ѯ�����û�����User PO����
	 * 
	 * @since Version 1.0
	 */
	private final String QUERY_USER_BY_USERNAME = "from User u where u.userName like ?";

	/**
	 * �����û�����ѯUser����
	 * 
	 * @author: ��׳��
	 * @param userName
	 *            �û���
	 * @return ��ӦuserName��User������������ڣ�����null��
	 * @version: 2013-7-24 ����12:03:48
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
	 * �����û���Ϊģ����ѯ��������ѯ������ǰ׺ƥ���User����
	 * 
	 * @author: ��׳��
	 * @param userName
	 *            �û�����ѯ����
	 * @return �û���ǰ׺ƥ�������User����
	 * @version: 2013-7-24 ����12:04:17
	 */
	public List<User> queryUserByUserName(String userName) {
		return (List<User>) find(QUERY_USER_BY_USERNAME, userName + "%");
	}

}

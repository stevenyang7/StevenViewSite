package com.viewsite.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * �û�PO��
 * 
 * @author: ��׳��
 * @version: 2013-7-23 ����8:17:24
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "t_user")
public class User {

	/**
	 * userId: �û�ID
	 * 
	 * @since Version 1.0
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	/**
	 * username: �û���
	 * 
	 * @since Version 1.0
	 */
	@Column(name = "user_name")
	private String username;

	/**
	 * password: ����
	 * 
	 * @since Version 1.0
	 */
	@Column(name = "password")
	private String password;

	/**
	 * lastLoginTime: ����¼ʱ��
	 * 
	 * @since Version 1.0
	 */
	@Column(name = "last_login_time")
	private Date lastLoginTime;

	/**
	 * lastLoginIP: ����¼IP��ַ
	 * 
	 * @since Version 1.0
	 */
	@Column(name = "last_login_ip")
	private String lastLoginIP;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIP() {
		return lastLoginIP;
	}

	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}

}

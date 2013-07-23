package com.viewsite.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * DAO���࣬����DAO����ֱ�Ӽ̳����DAO���������Ը��ù��õķ����������Ի�÷��͵ĺô���
 * 
 * @author: ��׳��
 * @version: 2013-7-23 ����11:47:23
 */

public class BaseDao<T> {

	private Class<T> entityClass;

	@Autowired
	private HibernateTemplate hibernateTemplate;

	/**
	 * ͨ�������ȡ����ȷ���ķ�����
	 * 
	 */

	public BaseDao() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class) params[0];
	}

	/**
	 * ����ID����POʵ��
	 * 
	 * @author: ��׳��
	 * @param id
	 *            ����PO�����ID
	 * @return ������Ӧ�ĳ־û�POʵ��
	 * @version: 2013-7-23 ����11:49:27
	 */
	public T load(Serializable id) {
		return (T) getHibernateTemplate().load(entityClass, id);
	}

	/**
	 * ����ID��ȡPOʵ��
	 * 
	 * @author: ��׳��
	 * @param id
	 *            ����PO�����ID
	 * @return ������Ӧ�ĳ־û�POʵ��
	 * @version: 2013-7-23 ����11:50:24
	 */
	public T get(Serializable id) {
		return (T) getHibernateTemplate().get(entityClass, id);
	}

	/**
	 * ��ȡPO�����ж���
	 * 
	 * @author: ��׳��
	 * @return ���е�PO�����б�
	 * @version: 2013-7-23 ����11:51:49
	 */
	public List<T> loadAll() {
		return getHibernateTemplate().loadAll(entityClass);
	}

	/**
	 * �������PO��������
	 * 
	 * @author: ��׳��
	 * @param entity
	 *            Ҫ���浽���ݿ��PO����
	 * @version: 2013-7-23 ����11:52:31
	 */
	public void save(T entity) {
		getHibernateTemplate().save(entity);
	}

	/**
	 * ɾ��PO����
	 * 
	 * @author: ��׳��
	 * @param entity
	 *            ��Ҫ�����ݿ���ɾ����PO����
	 * @version: 2013-7-23 ����11:53:38
	 */
	public void remove(T entity) {
		getHibernateTemplate().delete(entity);
	}

	/**
	 * ����PO����
	 * 
	 * @author: ��׳��
	 * @param entity
	 *            ��Ҫ�����PO����
	 * @version: 2013-7-23 ����11:54:22
	 */

	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}

	/**
	 * ִ�в���������HQL��ѯ
	 * 
	 * @author: ��׳��
	 * @param hql
	 *            ����ѯ��HQL���
	 * @version: 2013-7-23 ����11:57:06
	 */

	public List find(String hql) {
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * ִ�д�������HQL��ѯ
	 * 
	 * @author: ��׳��
	 * @param hql
	 *            ����ѯ��HQL���
	 * @param params
	 *            ����
	 * @return ��ѯ���
	 * @version: 2013-7-23 ����11:56:12
	 */
	public List find(String hql, Object... params) {
		return this.getHibernateTemplate().find(hql, params);
	}

	/**
	 * ���ӳټ��ص�ʵ��POִ�г�ʼ��
	 * 
	 * @author: ��׳��
	 * @version: 2013-7-23 ����11:56:00
	 */

	public void initialize(Object entity) {
		this.getHibernateTemplate().initialize(entity);
	}

	/**
	 * ��ȡhibernate����
	 * 
	 * @author: ��׳��
	 * @version: 2013-7-23 ����11:55:39
	 */

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

}

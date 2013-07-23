package com.viewsite.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * DAO基类，其它DAO可以直接继承这个DAO，不但可以复用共用的方法，还可以获得泛型的好处。
 * 
 * @author: 刘壮洪
 * @version: 2013-7-23 下午11:47:23
 */

public class BaseDao<T> {

	private Class<T> entityClass;

	@Autowired
	private HibernateTemplate hibernateTemplate;

	/**
	 * 通过反射获取子类确定的泛型类
	 * 
	 */

	public BaseDao() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class) params[0];
	}

	/**
	 * 根据ID加载PO实例
	 * 
	 * @author: 刘壮洪
	 * @param id
	 *            具体PO对象的ID
	 * @return 返回相应的持久化PO实例
	 * @version: 2013-7-23 下午11:49:27
	 */
	public T load(Serializable id) {
		return (T) getHibernateTemplate().load(entityClass, id);
	}

	/**
	 * 根据ID获取PO实例
	 * 
	 * @author: 刘壮洪
	 * @param id
	 *            具体PO对象的ID
	 * @return 返回相应的持久化PO实例
	 * @version: 2013-7-23 下午11:50:24
	 */
	public T get(Serializable id) {
		return (T) getHibernateTemplate().get(entityClass, id);
	}

	/**
	 * 获取PO的所有对象
	 * 
	 * @author: 刘壮洪
	 * @return 所有的PO对象列表
	 * @version: 2013-7-23 下午11:51:49
	 */
	public List<T> loadAll() {
		return getHibernateTemplate().loadAll(entityClass);
	}

	/**
	 * 保存具体PO对象属性
	 * 
	 * @author: 刘壮洪
	 * @param entity
	 *            要保存到数据库的PO对象
	 * @version: 2013-7-23 下午11:52:31
	 */
	public void save(T entity) {
		getHibernateTemplate().save(entity);
	}

	/**
	 * 删除PO对象
	 * 
	 * @author: 刘壮洪
	 * @param entity
	 *            需要从数据库中删除的PO对象
	 * @version: 2013-7-23 下午11:53:38
	 */
	public void remove(T entity) {
		getHibernateTemplate().delete(entity);
	}

	/**
	 * 更改PO对象
	 * 
	 * @author: 刘壮洪
	 * @param entity
	 *            需要变更的PO对象
	 * @version: 2013-7-23 下午11:54:22
	 */

	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}

	/**
	 * 执行不带参数的HQL查询
	 * 
	 * @author: 刘壮洪
	 * @param hql
	 *            待查询的HQL语句
	 * @version: 2013-7-23 下午11:57:06
	 */

	public List find(String hql) {
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 执行带参数的HQL查询
	 * 
	 * @author: 刘壮洪
	 * @param hql
	 *            待查询的HQL语句
	 * @param params
	 *            参数
	 * @return 查询结果
	 * @version: 2013-7-23 下午11:56:12
	 */
	public List find(String hql, Object... params) {
		return this.getHibernateTemplate().find(hql, params);
	}

	/**
	 * 对延迟加载的实体PO执行初始化
	 * 
	 * @author: 刘壮洪
	 * @version: 2013-7-23 下午11:56:00
	 */

	public void initialize(Object entity) {
		this.getHibernateTemplate().initialize(entity);
	}

	/**
	 * 获取hibernate对象
	 * 
	 * @author: 刘壮洪
	 * @version: 2013-7-23 下午11:55:39
	 */

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

}

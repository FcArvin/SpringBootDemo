/**
 * @author Arvin_Cheng
 *
 */
package com.example.demo.service;

import java.util.List;

import com.example.demo.po.TbSbuser;

public interface UserService{
	
	/**
	 * 新增操作
	 */
	public int saveUser(TbSbuser obj);
	
	/**
	 * 更新操作
	 */
	public int updateUser(TbSbuser obj);
	
	/**
	 * 删除操作
	 */
	public int deleteUser(String id);
	
	/**
	 * 通过ID查询User信息操作
	 */
	public Object queryUserInfoById(String id);
	
	/**
	 * 查询所有用户信息
	 */
	public Object queryUserInfo(TbSbuser obj);
	
	/**
	 * 查询所有用户信息
	 */
	public List<TbSbuser> queryUserInfoPaged(TbSbuser obj, Integer page, Integer pageSize);
}
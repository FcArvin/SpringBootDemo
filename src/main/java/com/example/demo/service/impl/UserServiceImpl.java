/**
 * @author Arvin_Cheng
 *
 */
package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import com.example.demo.mapper.TbSbuserMapper;
import com.example.demo.po.TbSbuser;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private TbSbuserMapper tbsbuserMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int saveUser(TbSbuser obj) {
		return tbsbuserMapper.insert(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateUser(TbSbuser obj) {
		return tbsbuserMapper.updateByPrimaryKeySelective(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteUser(String id) {
		return tbsbuserMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Object queryUserInfoById(String id) {
		return tbsbuserMapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Object queryUserInfo(TbSbuser obj) {
		return tbsbuserMapper.selectOne(obj);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<TbSbuser> queryUserInfoPaged(TbSbuser obj, Integer page, Integer pageSize) {
		//开始分页
		PageHelper.startPage(page, pageSize);
		
		Example example = new Example(TbSbuser.class);
		Example.Criteria criteria = example.createCriteria();
		
		//以下是查询条件
		if (!StringUtils.isEmpty(obj.getUsername())) {
			//这里的 “username” 表示的是实体类中的属性
			criteria.andLike("username", "%" + obj.getUsername() + "%");
		}
		//以下是排序，同样也是实体类中的属性
		example.orderBy("createdate").desc();
		
		List<TbSbuser> userList = tbsbuserMapper.selectByExample(example);
		
		return userList;
	}

	
}
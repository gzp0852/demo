//package com.example.user.service.impl;
//
//import com.example.common.bean.PageBean;
//import com.example.common.util.PageBeanField;
//import com.example.user.dao.UserDao;
//import com.example.user.entity.User;
//import com.example.user.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @Author 10376
// * @Date 2018/3/13
// */
//@Service
//@Transactional(rollbackFor = Exception.class)
//public class UserServiceImpl implements UserService {
//
//	@Autowired
//	private UserDao userDao;
//
//	@Override
//	public PageBean<User> queryAllByPage(Integer pageSize, Integer pageNum) {
//		PageBean<User> pageBean = new PageBean<>();
//		pageBean.setSize(pageSize);
//		pageBean.setPageNum(pageNum);
//		int begin = (pageNum - 1) * pageSize;
//		//查询用户数据
//		Map map = new HashMap(8);
//		map.put(PageBeanField.BEGIN.getField(), begin);
//		map.put(PageBeanField.PAGESIZE.getField(), pageSize);
//		List<User> users = userDao.queryAllByPage(map);
//		pageBean.setData(users);
//		//查询总记录条数
//		int count = userDao.queryCount(map);
//		pageBean.setTotalCount(count);
//		int totalPage = (count - 1) / pageSize + 1;
//		pageBean.setTotalPage(totalPage);
//		return pageBean;
//	}
//
//	@Override
//	public User getUser(String userName) {
//		return userDao.getUser(userName);
//	}
//}

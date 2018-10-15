/*
package com.example.user.service.impl;

import com.example.common.bean.SessionUser;
import com.example.common.util.Md5;
import com.example.common.util.Result;
import com.example.common.util.ResultCode;
import com.example.common.util.ResultUtils;
import com.example.user.dao.LoginDao;
import com.example.user.entity.User;
import com.example.user.service.LoginService;
import com.example.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

*/
/**
 * @Author 10376
 * @Date 2018/3/13
 *//*

@Service
@Transactional(rollbackFor = Exception.class)
public class LoginServiceImpl implements LoginService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private LoginDao loginDao;
	@Autowired
	private UserService userService;
	*/
/*@Autowired
	private RedisClient redisClient;
	@Autowired
	private WebSocketProduct product;*//*


	@Override
	public Result login(Map map, HttpServletRequest request) {
		String userName = (String) map.get("userName");
		String password = (String) map.get("password");

		// 根据用户名查询用户
		User user = userService.getUser(userName);
		// 用户不存在的话
		if (user == null) {
			logger.info("用户名不存在");
			return ResultUtils.warn(ResultCode.LOGIN_ERROR);
		}
		// 用户存在，密码不正确，返回登录失败用户名或者密码错误。
		if (!Md5.encode(password).equals(user.getPassword())) {
			logger.info("密码错误");
			return ResultUtils.warn(ResultCode.LOGIN_ERROR);
		}

		// 获取登录用户的ip
		String loginIp;
		// 用户真实ip的XFF头
		String xffHeader = "x-forwaeded-for";
		if (request.getHeader(xffHeader) == null) {
			loginIp = request.getRemoteAddr();
			logger.info("用户登录ip：" + loginIp);
		} else {
			loginIp = request.getHeader(xffHeader);
			logger.info("用户登录2ip：" + loginIp);
		}

		Map<String, Object> data = new HashMap<>();
		// 修改登陆时间
		String time = user.getLastLoginTime();
		String latestLoginTime = "";
		if (time != null && "".equals(time)) {
			latestLoginTime = time;
		}

		// TODO
		// 登录前判断用户是否已经登录，是的话将前一个用户下线。
	*/
/*	List<String> tokenList = redisClient.lrange(Constant.USER, 0, -1);
		int index = 0;
		if (tokenList != null && !tokenList.isEmpty()) {
			for (String str : tokenList) {
				SessionUser sessionUser = redisClient.get(str, SessionUser.class);
				if (sessionUser.getUserId().equals(user.getUserId())) {
					redisClient.del(str);
					redisClient.lrem(Constant.USER, index, str);
					// 下线此用户在另一个客户端
					product.offLine(str);
					continue;
				}
				index++;
			}
		}*//*

		// SessionUser
		SessionUser sessionUser = new SessionUser();
		sessionUser.setUserId(user.getUserId());
		sessionUser.setLoginDate(new Date());
		sessionUser.setLoginIp(loginIp);
		sessionUser.setUsername(user.getUserName());
		// 生成token
		String token = Md5.encode(user.getUserName() + UUID.randomUUID());
		logger.info(token);

		// token对应的是对象，并将token存入缓存
		*/
/*redisClient.set(token, sessionUser, null);
		redisClient.rpush(Constant.USER, token);*//*


		data.put("user", user);
		data.put("token", token);
		return ResultUtils.success(data);
	}
}
*/

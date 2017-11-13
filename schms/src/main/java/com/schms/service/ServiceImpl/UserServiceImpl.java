package com.schms.service.ServiceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.schms.dao.RoleDao;
import com.schms.dao.UserDao;
import com.schms.domain.User;
import com.schms.domain.security.UserRole;
import com.schms.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User localUser = userDao.findByUsername(user.getUsername());
		if(null != localUser){
			LOG.info("user {} already exist. Nothing will be done.", user.getUsername());
		}else{
			for(UserRole ur : userRoles){
				roleDao.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			localUser = userDao.save(user);
		}
		return localUser;
	}

	@Override
	public User saveUser(User user) {
		return userDao.save(user);
	}

}

package com.shopix.serviceImpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopix.beans.Role;
import com.shopix.beans.User;
import com.shopix.beans.UserRole;
import com.shopix.dao.RoleDao;
import com.shopix.dao.UserDao;
import com.shopix.dao.UserRoleDao;
import com.shopix.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private UserRoleDao userRoleDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private UserDao userDao;

	@Override
	public int save(User user) {
//		userDao.save(user);
		for (UserRole userRole : user.getUserRoles()) {
//			System.out.println("heeeeeeeeeeeeee");
//			userRoleDao.save(userRole);
//			Role role = userRole.getRole();
//			roleDao.save(role);
//			userRole.setRole(role);
//			userRoleDao.save(userRole);
			System.out.println("))))))))))))))))))))))))))))))))))))");
			System.out.println(userRole.getRole());
			System.out.println("))))))))))))))))))))))))))))))))))))");
		}
		return 1;
	}

}

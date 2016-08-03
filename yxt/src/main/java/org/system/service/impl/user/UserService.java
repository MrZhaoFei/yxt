package org.system.service.impl.user;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.system.entity.user.User;
import org.system.mapper.user.UserMapper;
import org.system.service.iface.user.IUserService;

@Service
public class UserService implements IUserService {
	@Resource
	private UserMapper mapper;

	@Override
	@Cacheable(value = "permissionCache", key = "#userMap[id]+'_permission'")
	public List<Map<String, Object>> getPermission(Map<String, Object> userMap) {
		return mapper.getPermission(userMap);
	}

	@Override
	public List<Map<String, Object>> getUserList(User user) {
		return mapper.queryAll(user);
	}

	@Override
	public int updateUser(User user) {
		return mapper.update(user);
	}
}

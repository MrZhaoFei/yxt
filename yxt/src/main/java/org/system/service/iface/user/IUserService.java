package org.system.service.iface.user;

import java.util.List;
import java.util.Map;

import org.system.entity.user.User;

public interface IUserService {
	public List<Map<String, Object>> getPermission(Map<String, Object> userMap);

	public List<Map<String, Object>> getUserList(User user);

	public int updateUser(User user);
}

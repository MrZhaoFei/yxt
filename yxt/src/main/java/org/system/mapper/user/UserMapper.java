package org.system.mapper.user;

import java.util.List;
import java.util.Map;

import org.core.mapper.IBaseMapper;
import org.system.entity.user.User;

public interface UserMapper extends IBaseMapper<User> {

	List<Map<String, Object>> getPermission(Map<String, Object> userMap);
}
package org.system.controller.impl.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.core.result.CodeEnum;
import org.core.result.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.system.Global;
import org.system.controller.iface.user.IUserController;
import org.system.entity.user.User;
import org.system.service.iface.user.IUserService;

@Controller
public class UserController implements IUserController {
	@Resource
	private IUserService userService;

	@Override
	public Map<String, Object> test1(User user, BindingResult result) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Map<String, Object>> userList = userService.getUserList(user);
		if (userList != null && userList.size() > 0) {
			resultMap.put(Global.DATA_TOTAL, user.getTotal());
			resultMap.put(Global.DATA_ROWS, userList);
			return ResultMap.convertMap(CodeEnum.SUCCESS, resultMap);
		} else {
			return ResultMap.convertMap(CodeEnum.FAIL);
		}
	}

	@Override
	public Map<String, Object> test2(Integer userId, User user, BindingResult result) {
		user.setId(userId);
		if (userService.updateUser(user) > 0) {
			return ResultMap.convertMap(CodeEnum.SUCCESS);
		} else {
			return ResultMap.convertMap(CodeEnum.FAIL);
		}
	}
}

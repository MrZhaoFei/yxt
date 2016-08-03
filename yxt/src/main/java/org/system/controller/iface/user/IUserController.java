package org.system.controller.iface.user;

import java.util.Map;

import org.core.annotation.RequiresPermissions;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.system.entity.user.User;

/**
 * @ClassName IUserController
 * @author <font color="red"><b>LiuMrLiu</b></font>
 * @date 2016年3月18日 下午5:31:07
 * @version 1.0
 * @description 用户信息处理类
 */
@RequestMapping(value = { "/user" })
public interface IUserController {

	/**
	 * 新增用户
	 * 
	 * @param user
	 * @param result
	 * @return {@link Map}
	 */
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	@ResponseBody
	@RequiresPermissions("user:test1")
	public Map<String, Object> test1(@Validated({User.queryUser.class}) User user, BindingResult result);
	/**
	 * 修改用户
	 * 
	 * @param user
	 * @param result
	 * @return {@link Map}
	 */
	@RequestMapping(value = "/test2/{userId}", method = RequestMethod.PUT)
	@ResponseBody
	@RequiresPermissions("user:test2")
	public Map<String, Object> test2(@PathVariable("userId") Integer userId, @Validated({User.updateUser.class}) User user, BindingResult result);
}
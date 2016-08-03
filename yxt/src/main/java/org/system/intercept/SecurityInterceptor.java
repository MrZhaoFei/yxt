package org.system.intercept;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.core.annotation.RequiresPermissions;
import org.core.result.CodeEnum;
import org.core.result.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.system.Global;
import org.system.service.iface.user.IUserService;

import com.alibaba.fastjson.JSON;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * @ClassName SecurityInterceptor
 * @author <font color="red"><b>LiuGangQiang</b></font>
 * @date 2016年2月11日 下午6:08:59
 * @version 1.0
 * @description 权限拦截器
 */
public class SecurityInterceptor extends HandlerInterceptorAdapter {
	Logger log = LoggerFactory.getLogger(SecurityInterceptor.class);

	@Resource
	IUserService userService;
	@Resource
	private CacheManager cache;

	private boolean validate(List<Map<String, Object>> permissionList, String[] strings) {
		for (String permission : strings) {
			for (Map<String, Object> map : permissionList) {
				if (permission.equals(map.get("resource"))) {
					return true;
				}
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod method = (HandlerMethod) handler;
			// 判断方法是否含有注解
			RequiresPermissions permissions = method.getMethodAnnotation(RequiresPermissions.class);
			if (permissions != null) {
				String key = request.getHeader("token");
				Map<String, Object> userMap = new HashMap<>();
				Element obj = cache.getCache(Global.CACHE_USER).get(key);
				if (obj != null) {
					userMap = (Map<String, Object>) obj.getObjectValue();
				}
				// 获取权限
				List<Map<String, Object>> permissionList = userService.getPermission(userMap);
				if (validate(permissionList, permissions.value())) {
					return true;
				} else {
					response.setCharacterEncoding("UTF-8");
					response.setContentType("application/json");
					if (obj == null) {
						/* 返回json */
						response.getWriter().write(JSON.toJSONString(ResultMap.convertMap(CodeEnum.UNSIGNATURE)));
					} else {
						/* 返回json */
						response.getWriter().write(JSON.toJSONString(ResultMap.convertMap(CodeEnum.UNAUTHORIZED)));
					}
				}
			} else {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json");
				response.getWriter().write(JSON.toJSONString(ResultMap.convertMap(CodeEnum.SYSTEM_ERROR)));
			}
			return false;
		}
		return true;
	}
}

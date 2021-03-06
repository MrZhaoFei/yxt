package org.system.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.core.result.CodeEnum;
import org.core.result.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.alibaba.fastjson.JSON;

/**
 * <font color="green">全局异常处理拦截器</font>
 * 
 * @ClassName MyExceptionResolver
 * @author Friday-LiuGangQiang
 * @date 2015年10月12日 上午11:53:25
 *
 * @version 1.0
 */

public class MyExceptionResolver extends SimpleMappingExceptionResolver {
	Logger LOG = LoggerFactory.getLogger(MyExceptionResolver.class);

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		if (handler instanceof HandlerMethod) {
			HandlerMethod method = (HandlerMethod) handler;
			/* 非json异常直接跳转页面 */
			if (method.getMethodAnnotation(ResponseBody.class) == null) {
				LOG.error("Exception ", ex);
				return super.doResolveException(request, response, handler, ex);
			} else {
				/* Json异常设置响应格式和响应的字符编码 */
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json");
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				try {
					response.getWriter().write(JSON.toJSONString(ResultMap.convertMap(CodeEnum.SYSTEM_ERROR)));
				} catch (IOException e) {
					e.printStackTrace();
				}
				LOG.error("Json exception ", ex);
				return new ModelAndView();
			}
		}
		return super.doResolveException(request, response, handler, ex);
	}
}
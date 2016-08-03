package org.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName RequiresPermissions
 * @author <font color="red"><b>LiuGangQiang</b></font>
 * @date 2016年2月10日 下午9:37:10
 * @version 1.0
 * @description 权限资源标识注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequiresPermissions {

	String[] value();
}

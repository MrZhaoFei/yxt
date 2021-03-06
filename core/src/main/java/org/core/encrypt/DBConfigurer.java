package org.core.encrypt;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @ClassName DBConfigurer
 * @author <font color="red"><b>LiuGangQiang</b></font>
 * @date 2016年2月17日 下午4:04:32
 * @version 1.0
 * @description 数据配置文件加密生成类
 */
public class DBConfigurer extends PropertyPlaceholderConfigurer {

	private final static String key = "scyxtyzg";

	private final static String URL = "url";

	private final static String USER = "user";

	private final static String PASSWORD = "password";

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)
			throws BeansException {

		String url = props.getProperty("url");
		if (url != null)
			try {
				props.setProperty(URL, DESUtil.decrypt(url, key));
			} catch (Exception e) {
				e.printStackTrace();
			}
		String user = props.getProperty("user");
		if (user != null)
			try {
				props.setProperty(USER, DESUtil.decrypt(user, key));
			} catch (Exception e) {
				e.printStackTrace();
			}

		String password = props.getProperty("password");
		if (password != null)
			try {
				props.setProperty(PASSWORD, DESUtil.decrypt(password, key));
			} catch (Exception e) {
				e.printStackTrace();
			}
		super.processProperties(beanFactory, props);
	}

	public static String getKey() {
		return key;
	}
	
}

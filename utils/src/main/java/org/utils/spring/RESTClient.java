package org.utils.spring;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class RESTClient {
	static ExecutorService pool = Executors.newFixedThreadPool(20);
	private static Logger log = LoggerFactory.getLogger(RESTClient.class);
	private static HttpClient httpClient = HttpClientBuilder.create().build();
	private static RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(10000)
			.build();// 设置请求和传输超时时间

	public static void post(String url, String method, Map<String, Object> param) {

		pool.execute(new Runnable() {
			@Override
			public void run() {
				HttpPost post = new HttpPost(url + method);
				post.setConfig(requestConfig);
				// 设置需要提交的参数
				List<NameValuePair> list = new ArrayList<NameValuePair>();
				for (Entry<String, Object> entry : param.entrySet()) {
					Object objValue = entry.getValue();
					list.add(new BasicNameValuePair(entry.getKey(), objValue == null ? "" : objValue.toString()));
				}
				try {
					post.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
					long startTime = System.currentTimeMillis();
					HttpResponse response = httpClient.execute(post);
					String resposeText = EntityUtils.toString(response.getEntity());
					if (response.getStatusLine().getStatusCode() == HttpStatus.OK.value()) {
						log.info("send  to [{}] success times [{}] response [{}] param:[{}]", url + method, System.currentTimeMillis()-startTime,resposeText, param);
					}else{
						log.warn("send  to [{}] fail times [{}] response [{}] param:[{}]", url + method,  System.currentTimeMillis()-startTime,resposeText, param);
					}
				} catch (IOException e) {
					log.error("send  to [{}] error message:{}", url + method, e);
					e.printStackTrace();
				}
			}
		});
	}

	public static String postForSynchronize(String url, String method, Map<String, Object> param) {
		HttpPost post = new HttpPost(url + method);
		post.setConfig(requestConfig);
		// 设置需要提交的参数
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		for (Entry<String, Object> entry : param.entrySet()) {
			list.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
		}
		try {
			post.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
			long startTime = System.currentTimeMillis();
			HttpResponse response = httpClient.execute(post);
			String resposeText = EntityUtils.toString(response.getEntity());
			if (response.getStatusLine().getStatusCode() == HttpStatus.OK.value()) {
				log.info("send  to [{}] success times [{}] response [{}] param:[{}]", url + method,  System.currentTimeMillis()-startTime,resposeText, param);
				return resposeText;
			}else{
				log.warn("send  to [{}] fail times [{}]  response [{}] param:[{}]", url + method,  System.currentTimeMillis()-startTime,resposeText, param);
			}
		} catch (IOException e) {
			log.error("send  to [{}] error message:{}", url + method, e);
			e.printStackTrace();
		}
		return null;
	}
}

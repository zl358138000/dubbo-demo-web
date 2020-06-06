package com.od.dubbotest.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.od.dubbotest.api.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping(value="/sh")
public class ShAction {
	
	@Reference HelloService helloService;
	
	@RequestMapping

	public String say(String name) {
                Logger log = LoggerFactory.getLogger(ShAction.class);
                String marker = "ShAction";
		log.info(marker, "HelloAction接收到请求:", name);
		String str = "<h1>这是Dubbo 消费者端(springboot)</h1>";
		str += "<h2>这里是上海站的页面</h2>";
                str+="<h2>这里是上海站新加入的功能，灰度测试</h2>";
		str += helloService.hello(name);
		log.info(marker, "HelloService返回到结果:", str);
		return str;
	}
}

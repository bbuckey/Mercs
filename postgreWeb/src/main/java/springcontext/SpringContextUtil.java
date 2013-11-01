package springcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextUtil {

	private static ApplicationContext context = 
    		new ClassPathXmlApplicationContext("employee-servlet.xml");
	
	
	private ApplicationContext getApplicationContextBean(){
		return context;
	}
	
}

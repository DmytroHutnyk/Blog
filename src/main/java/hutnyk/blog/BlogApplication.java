package hutnyk.blog;

import hutnyk.blog.Controller.Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(BlogApplication.class, args);
		Controller controller = applicationContext.getBean(Controller.class);
		controller.startApplication();
	}

}

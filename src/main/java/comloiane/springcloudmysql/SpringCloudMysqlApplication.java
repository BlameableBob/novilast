package comloiane.springcloudmysql;


import comloiane.springcloudmysql.model.Contact;
import comloiane.springcloudmysql.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.sql.Date;
import java.util.stream.LongStream;

@SpringBootApplication
public class SpringCloudMysqlApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringCloudMysqlApplication.class, args);
	}



}

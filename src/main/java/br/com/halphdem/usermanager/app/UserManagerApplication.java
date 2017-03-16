package br.com.halphdem.usermanager.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.session.data.mongo.JdkMongoSessionConverter;
import org.springframework.session.data.mongo.config.annotation.web.http.EnableMongoHttpSession;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.halphdem.usermanager.config.MongoConfiguration;

@Configuration
@Import({ MongoConfiguration.class})
@EnableMongoHttpSession
@EnableMongoRepositories("br.com.halphdem.usermanager.repositories")
@SpringBootApplication(scanBasePackages={
		"br.com.halphdem.usermanager.controllers",
		"br.com.halphdem.usermanager.controllers.rest",
		"br.com.halphdem.usermanager.infra",
		"br.com.halphdem.usermanager.services"
})
public class UserManagerApplication {
	
    @Bean
    public JdkMongoSessionConverter jdkMongoSessionConverter() {
            return new JdkMongoSessionConverter(); 
    }

	public static void main(String[] args) {
		SpringApplication.run(UserManagerApplication.class, args);
	}
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	    resolver.setPrefix("/WEB-INF/views/");
	    resolver.setSuffix(".jsp");
	    resolver.setExposedContextBeanNames("carrinhoCompras");
	    return resolver;
	}
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		
		messageSource.setBasename("/WEB-INF/messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(1);
		
		
		return messageSource;
	}
	
	@Bean
	public FormattingConversionService mvcConversionService() {
		DefaultFormattingConversionService 
			defaultFormattingConversionService = new DefaultFormattingConversionService();
		
		DateFormatterRegistrar dateFormatterRegistrar = new DateFormatterRegistrar();
		
		dateFormatterRegistrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
		
		dateFormatterRegistrar.registerFormatters(defaultFormattingConversionService);
		
		return defaultFormattingConversionService;
		
	}
	
	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
		
	}
}

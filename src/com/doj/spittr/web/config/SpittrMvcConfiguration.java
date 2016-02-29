package com.doj.spittr.web.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.doj.spittr.utils.SpittrConstant;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.doj.spittr")
@PropertySource("classpath:MailSetup.properties")
public class SpittrMvcConfiguration extends WebMvcConfigurerAdapter{
	@Autowired
	private Environment env;
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/scripts/**")
				.addResourceLocations("/web-resources/scripts/")
				.setCachePeriod(31556926);
		registry.addResourceHandler("/images/**")
				.addResourceLocations("/web-resources/images/")
				.setCachePeriod(31556926);
		registry.addResourceHandler("/css/**")
				.addResourceLocations("/web-resources/css/")
				.setCachePeriod(31556926);
		registry.addResourceHandler("/fonts/**")
				.addResourceLocations("/web-resources/fonts/")
				.setCachePeriod(31556926);

	}

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		registry.addInterceptor(localeChangeInterceptor);
	}
	
	/*@Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }*/
	
	@Bean
	public TilesViewResolver configureTilesViewResolver() {
		return new TilesViewResolver();
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		cookieLocaleResolver.setDefaultLocale(Locale.ENGLISH);
		return cookieLocaleResolver;
	}

	@Bean
	public TilesConfigurer configureTilesConfigurer() {
		TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions(new String[] { SpittrConstant.TILES });
		return configurer;
	}
	@Bean
	public CommonsMultipartResolver multipartResolver(){
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(1000000);
		return multipartResolver;
	}
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	    converters.add(mappingJackson2HttpMessageConverter());
	    converters.add(byteArrayHttpMessageConverter());
	}

	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
	    converter.setObjectMapper(objectMapper);
	    return converter;
	}

	@Bean
	public ByteArrayHttpMessageConverter byteArrayHttpMessageConverter() {
	    ByteArrayHttpMessageConverter arrayHttpMessageConverter = new ByteArrayHttpMessageConverter();
	    arrayHttpMessageConverter.setSupportedMediaTypes(getSupportedMediaTypes());
	    return arrayHttpMessageConverter;
	}
	
	@Bean
	public SimpleMailMessage preConfiguredMessage(){
		SimpleMailMessage simpleMailMessage= new SimpleMailMessage();
		simpleMailMessage.setFrom("thisforabhi@gmail.com");
		simpleMailMessage.setSubject("Forgot password");
		return simpleMailMessage;
	}
	@Bean
	public JavaMailSenderImpl mailSender(){
		JavaMailSenderImpl javaMailSenderImpl= new JavaMailSenderImpl();
		javaMailSenderImpl.setHost(env.getProperty("mail.host"));
		javaMailSenderImpl.setUsername(env.getProperty("senderUsername"));
		javaMailSenderImpl.setPassword(env.getProperty("senderPassword"));		
		javaMailSenderImpl.setJavaMailProperties(additionalProperties());
		javaMailSenderImpl.setPort(Integer.parseInt(env.getProperty("mail.port").toString()));
		return javaMailSenderImpl;
		
	}
	final Properties additionalProperties() {
		final Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("mail.transport.protocol", env.getProperty("mail.transport.protocol"));
		hibernateProperties.setProperty("mail.smtp.auth", env.getProperty("mail.smtp.auth"));
		hibernateProperties.setProperty("mail.smtp.starttls.enable",env.getProperty("mail.smtp.starttls.enable"));
		hibernateProperties.setProperty("mail.debug", env.getProperty("mail.smtp.starttls.enable"));
		return hibernateProperties;
	}

	private List<MediaType> getSupportedMediaTypes() {
	    List<MediaType> list = new ArrayList<MediaType>();
	    list.add(MediaType.IMAGE_JPEG);
	    list.add(MediaType.IMAGE_PNG);
	    list.add(MediaType.APPLICATION_OCTET_STREAM);
	    return list;
	}



}

/**
 * 
 */
package com.doj.spittr.persistence.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.doj.spittr.entities.DAppImage;
import com.doj.spittr.entities.DAppMaster;
import com.doj.spittr.entities.Dflwr;
import com.doj.spittr.entities.Dlgn;
import com.doj.spittr.entities.Dtweet;
import com.doj.spittr.entities.Dusr;
import com.doj.spittr.entities.DusrRole;
import com.doj.spittr.entities.PasswordManagement;

/**
 * @author Dinesh.Rajput
 *
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:persistence.properties")
@EnableJpaRepositories(basePackages = "com.doj.spittr.repositories")
public class SpittrPersistenceConfig {
	
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	@Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(datasource());
        sessionFactory.setPackagesToScan(new String[] { "com.doj.spittr.entities" });
        sessionFactory.setHibernateProperties(additionalProperties());
        return sessionFactory;
     }

	

	@Autowired
	private Environment env;

	public SpittrPersistenceConfig() {
		super();
	}

	@Bean
	public DataSource datasource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		return dataSource;
	}
	 @Autowired
	    @Bean(name = "sessionFactory")
	    public SessionFactory getSessionFactory(DataSource dataSource) {
	    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	    	sessionBuilder.addAnnotatedClass(Dlgn.class);
	    	sessionBuilder.addAnnotatedClass(Dusr.class);
	    	sessionBuilder.addAnnotatedClass(DAppMaster.class);
	    	sessionBuilder.addAnnotatedClass(Dflwr .class);
	    	sessionBuilder.addAnnotatedClass(DAppImage.class);
	    	sessionBuilder.addAnnotatedClass(Dtweet.class);
	    	sessionBuilder.addAnnotatedClass(DusrRole.class);
	    	sessionBuilder.addAnnotatedClass(PasswordManagement.class);
	    	
	    	return sessionBuilder.buildSessionFactory();
	    }

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(datasource());
		em.setPackagesToScan("com.doj.spittr.entities");

		final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		
		return em;
	}

	@Bean
	public PlatformTransactionManager transactionManager(
			final EntityManagerFactory emf) {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	final Properties additionalProperties() {
		LOGGER.info("setting the hibernate properties");
		final Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto",
				env.getProperty("hibernate.hbm2ddl.auto"));
		hibernateProperties.setProperty("hibernate.dialect",
				env.getProperty("hibernate.dialect"));
		hibernateProperties.setProperty("hibernate.show_sql",
				env.getProperty("hibernate.show_sql"));
		hibernateProperties.setProperty("hibernate.use_sql_comments",
				env.getProperty("hibernate.use_sql_comments"));
		hibernateProperties.setProperty("hibernate.format_sql",
				env.getProperty("hibernate.format_sql"));
		return hibernateProperties;
	}

}

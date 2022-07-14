package my.anna.springdemo.mvcandhibernate.REST;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

// Example of Spring configuration without XML (applicationContext.xml) and web.xml 
// - requires maven-war-plugin in pom

@Configuration
@ComponentScan(basePackages = "my.anna.springdemo.mvcandhibernate")
@EnableWebMvc
@EnableTransactionManagement
public class MyConfig {
	
	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/my_db?useSSL=false");
			dataSource.setUser("remote_user");
			dataSource.setPassword("12345");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("my.anna.springdemo.mvcandhibernate.entities");
		
		Properties hibProperties = new Properties();
		hibProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		hibProperties.setProperty("hibernate.show_sql", "true");
		
		sessionFactory.setHibernateProperties(hibProperties);
		
		return sessionFactory;
	}
	
	@Bean
	public HibernateTransactionManager hibernateTransactionManager() {
		
		HibernateTransactionManager tm = new HibernateTransactionManager();
		tm.setSessionFactory(sessionFactory().getObject());
		return tm;
		
	}

}

package gau.shoppingbackend.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"gau.backendshopping.dto"})
@EnableTransactionManagement

public class HibernateConfig {
	private final static String DATABASE_URL="jdbc:h2:tcp://localhost/~/onlineshopping";
	private final static String DATABASE_DRIVER="org.h2.Driver";
	private final static String DATABASE_DAILECT="org.hibernate.dialect.H2Dailect";
	private final static String DATABASE_USERNAME="sa";
	private final static String DATABASE_PASSWORD="";
	
	
	//dataSource bean will be available
	@Bean
	private DataSource getDataSource() {
		BasicDataSource dataSource =	new BasicDataSource();
		
		
		//providing the database connection information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;
	}
	
	
	//sessionFactory bean will be available
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("gau.shoppingbackend.dto");
		
		return builder.buildSessionFactory();
		
	}
	
	
	
	//All the hibernate property will be returned in this method
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		
		properties.put("hibernate.dailect", DATABASE_DAILECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		return null;
	}
	
	
	//transaction manager bean
	@Bean
	public HibernateTransactionManager geHibernateTransactionManager(SessionFactory sessionfactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionfactory);
		return transactionManager;
	}
}


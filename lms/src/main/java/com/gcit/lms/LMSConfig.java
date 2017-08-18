package com.gcit.lms;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.gcit.lms.dao.AuthorDAO;
import com.gcit.lms.dao.BookDAO;
import com.gcit.lms.dao.BorrowerDAO;
import com.gcit.lms.dao.BranchDAO;
import com.gcit.lms.dao.CopiesDAO;
import com.gcit.lms.dao.GenreDAO;
import com.gcit.lms.dao.LoanDAO;
import com.gcit.lms.dao.PublisherDAO;


@Configuration
public class LMSConfig {
	
	public String driver = "com.mysql.jdbc.Driver";
	public String url = "jdbc:mysql://gcitsolutions.cel9vdzh4eep.us-east-1.rds.amazonaws.com:3306/library";
	public String username = "gcitsolutions";
	public String password = "gcitsolutions";
	
	@Bean
	public BasicDataSource datasource(){
		
		BasicDataSource datasource = new BasicDataSource();
		
		datasource.setDriverClassName(driver);
		datasource.setUrl(url);
		datasource.setUsername(username);
		datasource.setPassword(password);
		
		return datasource;
	}
	
	@Bean
	public JdbcTemplate template(){
		
		return new JdbcTemplate(datasource());
	}
	
	public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
	
	
	@Bean
	public PlatformTransactionManager txManager() {
		DataSourceTransactionManager dsManager = new DataSourceTransactionManager();
		dsManager.setDataSource(datasource());
		return dsManager;
	}
	
	@Bean
	public AuthorDAO adao()	{
		return new AuthorDAO();
	}
	
	@Bean
	public BookDAO bdao()	{
		return new BookDAO();
	}
	
	@Bean
	public BranchDAO branchDao()	{
		return new BranchDAO();
	}
	
	@Bean
	public CopiesDAO cdao()	{
		return new CopiesDAO();
	}
	
	@Bean
	public GenreDAO gdao()	{
		return new GenreDAO();
	}
	
	@Bean
	public LoanDAO ldao()	{
		return new LoanDAO();
	}
	
	@Bean
	public PublisherDAO pdao()	{
		return new PublisherDAO();
	}
	
	@Bean
	public BorrowerDAO borrowerDao()	{
		return new BorrowerDAO();
	}

}

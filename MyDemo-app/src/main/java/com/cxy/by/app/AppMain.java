package com.cxy.by.app;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author admin
 * @version 1.0.0.0 Service服务springboot核心启动类
 *
 */
@ImportResource(locations = { "classpath:dubboprovider.xml" })
@MapperScan("com.cxy.by.app.dao")
@ComponentScan(basePackages = { "com.cxy.by.app" }, includeFilters = { @Filter(classes = { Service.class }) })
@SpringBootApplication
public class AppMain {

	/**
	 * 加载数据源，以spring.datasource打头
	 * 
	 * @return
	 */
	@Bean(initMethod = "init", destroyMethod = "close")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return new DruidDataSource();
	}

	/**
	 * 加载数据接口实现类，即Mybatis数据映射文件
	 * 
	 * @return
	 * @throws Exception
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		/* 加载mybatis的映射文件 */
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:/mybatis_mapping/*Mapper.xml"));
		return sqlSessionFactoryBean.getObject();
	}

	public static void main(String[] args) throws IOException {
		SpringApplication.run(AppMain.class, args);
		System.out.println("------demo-app-service服务已启动------");
	}
}

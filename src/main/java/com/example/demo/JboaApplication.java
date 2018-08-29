package com.example.demo;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

import java.util.Properties;

@SpringBootApplication
/*@MapperScan("com.example.demo.repository.department") //扫描Dao包
@EnableTransactionManagement //开启事务*//*
@EnableAspectJAutoProxy
@EnableAutoConfiguration
@ComponentScan("com.example.demo.repository.department") //指定扫描的mapper接口所在的包 @MapperScan("com.blog.mapper") //启动注解事务管理
@EnableTransactionManagement
@RestController*/

public class JboaApplication {
/*
	*/
/*@Bean
	public PageHelper pageHelper(){
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("offsetAsPageNum","true");
		properties.setProperty("rowBoundsWithCount","true");
		properties.setProperty("reasonable","true");
		properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
		pageHelper.setProperties(properties);
		return pageHelper;
	}*//*

	 private static final String MAPPER_SCAN_BASE_PACKAGE = "com.blog.mapper";
	 private static final String TYPE_ALIASES_PACKAGE = "com.blog.model";
	 private static final String MAPPER_LOCATION = "classpath:/mybatis*/
/*.xml";
	 @Bean
	 @Autowired
	 public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
	 	final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
	 	sqlSessionFactoryBean.setDataSource(dataSource); // 分页插件
		  PageHelper pageHelper = new PageHelper(); Properties properties = new Properties();
		  properties.setProperty("reasonable", "true"); properties.setProperty("supportMethodsArguments", "true");
		  properties.setProperty("returnPageInfo", "check"); properties.setProperty("params", "count=countSql");
		  pageHelper.setProperties(properties); //添加插件
		  sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper}); //mybatis.typeAliasesPackage：指定domain类的基包，即指定其在*Mapper.xml文件中可以使用简名来代替全类名（看后边的UserMapper.xml介绍）
		 sqlSessionFactoryBean.setTypeAliasesPackage(TYPE_ALIASES_PACKAGE); */
/* mybatis.mapperLocations：指定*Mapper.xml的位置 如果不加会报org.apache.ibatis.binding.BindingException: Invalid bound statement (not found): com.blog.mapper.MessageMapper.findMessageInfo异常 因为找不到*Mapper.xml，也就无法映射mapper中的接口方法。 *//*

		 sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
		 return sqlSessionFactoryBean.getObject();
	 }
*/

	public static void main(String[] args) {

		SpringApplication.run(JboaApplication.class, args);
	}
}

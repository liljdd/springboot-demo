package com.ant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @SpringBootApplication相当于以下三个注解：
 *     1. @Configuration，就是java配置bean容器
 * 　　2. @EnableAutoConfiguration：启用 Spring 应用程序上下文的自动配置，
 * 　　3. @ComponentScan：组件自动配置
 *
 * @MapperScan("com.ant.mapper") 将项目中对应的mapper(dao)类的路径加进来
 * spring boot只会扫描启动类当前包和以下的包  。 如果将 spring boot 放在 包  com.ant.controller 里面的话 ，
 * 它会扫描 com.ant.controller 和 com.ant.controller.* 里面的所有的 ；
 * 还有一种解决方案是 在启动类的上面添加 @ComponentScan(basePackages = {"com.ant.*"})
 *
 * @EnableTransactionManagement 启用注解事务管理
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.ant.mapper")
public class SpringbootDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }
}

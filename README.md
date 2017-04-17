# SSM集成的基础项目，项目使用Maven管理

# MyBatis3.3.0

# Spring[MVC]4.1.2.RELEASE

项目使用Spring4.1.2.RELEASE + SpringMVC4.1.2.RELEASE + Mybatis3.3.0

项目集成了Mybatis分页插件和通用Mapper插件

项目使用的mysql数据库，根据需要可以切换为其他数据库

集成分页插件 5.0.0 版本，注意配置变化：
```xml
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
    <property name="dataSource" ref="dataSource"/>
    <property name="mapperLocations">
        <array>
            <value>classpath:mapper/*.xml</value>
        </array>
    </property>
    <property name="typeAliasesPackage" value="com.isea533.mybatis.model"/>
    <property name="plugins">
        <array>
            <bean class="com.github.pagehelper.PageInterceptor">
                <!-- 这里的几个配置主要演示如何使用，如果不理解，一定要去掉下面的配置 -->
                <property name="properties">
                    <value>
                        helperDialect=mysql
                        reasonable=true
                        supportMethodsArguments=true
                        params=count=countSql
                        autoRuntimeDialect=true
                    </value>
                </property>
            </bean>
        </array>
    </property>
</bean>
```
- 拦截器 `com.github.pagehelper.PageInterceptor`
- 原来的 `dialect` 变成了 `helperDialect`，这是基于 PageHelper 方式的分页
- 具体变化看文档

## Spring Boot集成MyBatis的基础项目

### https://github.com/abel533/MyBatis-Spring-Boot

## MyBatis工具

### http://www.mybatis.tk

## 推荐使用Mybatis通用Mapper3

### https://github.com/abel533/Mapper

## 推荐使用Mybatis分页插件PageHelper

### https://github.com/pagehelper/Mybatis-PageHelper

## 作者信息

- 作者博客：http://blog.csdn.net/isea533

- 作者邮箱：abel533@gmail.com

- Mybatis工具群（推荐）： <a target="_blank" href="http://shang.qq.com/wpa/qunwpa?idkey=7c2f018e4cddc7d4aad04fc312b2d69361a0a896a4f59219a7914953a57bffc2"><img border="0" src="http://pub.idqqimg.com/wpa/images/group.png" alt="Mybatis工具群(2)" title="Mybatis工具群(2)"></a>

- Mybatis工具群（2000 人已满）： <a target="_blank" href="http://shang.qq.com/wpa/qunwpa?idkey=29e4cce8ac3c65d14a1dc40c9ba5c8e71304f143f3ad759ac0b05146e0952044"><img border="0" src="http://pub.idqqimg.com/wpa/images/group.png" alt="Mybatis工具" title="Mybatis工具"></a>

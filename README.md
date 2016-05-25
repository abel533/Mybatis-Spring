#SSM集成的基础项目，项目使用Maven管理

#MyBatis3.3.0

#Spring[MVC]4.1.2.RELEASE

#Oracle

项目使用Spring4.1.2.RELEASE + SpringMVC4.1.2.RELEASE + Mybatis3.3.0 + Oracle

项目集成了Mybatis分页插件和通用Mapper插件

项目使用的Oracle数据库，根据需要可以切换为其他数据库

##注意主键

```java
public class Country {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select SEQ_COUNTRY.nextval from dual")
    private Integer id;

    //省略其他
```

##注意通用Mapper配置
```xml
<bean class="tk.mybatis.spring.mapper.MapperScannerConfigurer">
    <property name="basePackage" value="com.isea533.mybatis.mapper"/>
    <!-- 3.2.2版本新特性，markerInterface可以起到mappers配置的作用，详细情况需要看Marker接口类 -->
    <property name="markerInterface" value="com.isea533.mybatis.util.MyMapper"/>
    <!-- 通用Mapper通过属性注入进行配置，默认不配置时会注册Mapper<T>接口 -->
    <property name="properties">
        <value>
            ORDER=BEFORE
        </value>
    </property>
</bean>
```
主要是`ORDER=BEFORE`，这个可以保证序列先执行

##新增国家输出的日志

```
DEBUG [http-apr-8091-exec-4] - JDBC Connection [com.alibaba.druid.proxy.jdbc.ConnectionProxyImpl@43daa112] will be managed by Spring
DEBUG [http-apr-8091-exec-4] - ==>  Executing: select SEQ_COUNTRY.nextval from dual
DEBUG [http-apr-8091-exec-4] - <==      Total: 1
DEBUG [http-apr-8091-exec-4] - ==>  Preparing: INSERT INTO country ( id,countryname,countrycode ) VALUES( ?,?,? )
DEBUG [http-apr-8091-exec-4] - ==> Parameters: 200(Integer), 测试(String), CS(String)
DEBUG [http-apr-8091-exec-4] - <==    Updates: 1
```

##如何运行本项目

先通过项目sql文件下的sql创建数据库的基本环境，如果没有表空间，就先执行**创建表空间和用户.sql**

之后使用新建的用户登录，然后执行 **创建表-序列-数据.sql**

准备好数据库之后，修改`src/main/resources/config.properties`配置：
```
# 数据库配置
jdbc.driverClass = oracle.jdbc.driver.OracleDriver
jdbc.url = jdbc:oracle:thin:@//192.168.16.137:1521/orcl
jdbc.user = mybatis
jdbc.password = mybatis
```

保持上面的配置和自己的数据库一致即可。

##Spring Boot集成MyBatis的基础项目

###https://github.com/abel533/MyBatis-Spring-Boot

##MyBatis工具

###http://www.mybatis.tk

##推荐使用Mybatis通用Mapper3

###https://github.com/abel533/Mapper

##推荐使用Mybatis分页插件PageHelper

###https://github.com/pagehelper/Mybatis-PageHelper

##作者信息

- 作者博客：http://blog.csdn.net/isea533

- 作者邮箱：abel533@gmail.com

- Mybatis工具群： 211286137 (Mybatis相关工具插件等等)

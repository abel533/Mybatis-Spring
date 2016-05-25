--创建临时表空间
create temporary tablespace mybatis_temp 
tempfile 'C:\oracle\product\10.2.0\oradata\mybatis\mybatis_temp.dbf' 
size 32m 
autoextend on 
next 32m maxsize 2048m
extent management local;
--创建数据表空间
create tablespace mybatis
logging
datafile 'C:\oracle\product\10.2.0\oradata\mybatis\mybatis.dbf' 
size 32m 
autoextend on 
next 32m maxsize 2048m
extent management local;

--
create user mybatis identified by mybatis
default tablespace mybatis
temporary tablespace mybatis_temp;

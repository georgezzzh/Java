## Linux开机启动MYSQL
    ./mysqld_safe &
 详细内容参考<a href="https://blog.csdn.net/king_1421484363/article/details/73277771">Linux平台MYSQL的开关</a>
## 命令行开启命令
    mysql -uroot -p
然后键入密码即可
### 显示所有数据库
    show databases;
### 选中某个数据库
    use world; #这里world是一个数据库
### 显示某个数据库中的所有表
    show tables;
### 显示表的结构
    desc user;#user是一张table
### 修改某一列的类型
    ALTER TABLE user MODIFY password CHAR(32);
### 修改某一列成为自增长
    alter table user auto_increment=1000;
    //指定1000为此后的增长值
### 删除表中的某项
    delete from user where userId=12345;
### 增加新值
    insert into user(username,password) values("george","12345");

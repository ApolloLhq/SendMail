# SendMail
### 基于SpringBoot的发送邮件小程序
默认环境Maven | Jdk1.8 | MySQL5.7

本程序主要包含两个功能
1.拉取数据库邮箱列表
2.发送邮件

数据库功能基于Hibernate，只需要创建对应的数据库，程序运行的表自动创建。
数据库名默认指定为send_mail
修改application.properties中数据库名和账号密码
修改application.yml中发送邮件相关配置，其中username password host 为需要修改的地方

项目打包成可执行jar
> mvn package -DskipTests=true

环境配置好情况下，使用一下命令启动程序.程序启动后执行SpringBootRunner给定的任务。
> java -jar SendMail-1.0.jar > server.log 2>&1 &

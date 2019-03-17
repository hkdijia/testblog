# MyBlog



#### 关于本地开发
可直接导入该项目于本地，修改配置文件中的数据库连接信息，导入附带数据库结构的SQL文件可直接生成所有表

**当你克隆项目到本地后可在User表中自行新建用户，实现登录

#### 项目介绍  
- 关于项目，对于学习Springboot是个挺不错的练手项目，最近在找工作，离不开谈项目，就自己   动手写一下，也是面试的资本
- 如何从零开始，使用Springboot开发项目
- 开发前的一些准备工作，以及思考项目整体结构与思路
- 记录开发过程中遇到的一些难题以及bug
- 思考整个项目有哪些可以优化的地方，以及有哪些可增加的功能

## 页面展示

##### 首页展示
![](http://wx3.sinaimg.cn/large/d6bdf0ebly1g167yzry1xj21hc0tzq5j.jpg)
<br>

##### 文章编辑
![](http://wx3.sinaimg.cn/large/d6bdf0ebly1g1682vymgaj21hc0tzgo9.jpg)
<br>
##### 后台管理
![](http://wx1.sinaimg.cn/large/d6bdf0ebly1g167yzz3tuj21hc0u0767.jpg)
<br>
##### 用户个人中心
![](http://wx2.sinaimg.cn/large/d6bdf0ebly1g167yzup6oj21h60u041s.jpg)

## 项目需求
#### 项目背景
对于初学Springboot的朋友来说，最好的一个学习方式就是那一个功能俱全的项目来练练手，通过自己重构项目来发现其中的潜在难题，并且也能很好的在编码过程中总结和发现问题、解决问题。使用Springboot开发的博客系统，简单并且实用，适合做练手项目。

#### 功能需求
###### 主页
- 博客汇总，以列表形式展示文章，并附上文章作者、发布日期、分类情况

- 能够以分类形式查看文章

- 可实现通过标题查找所有相关文章

- 博客网站更新记录


###### 后台管理

- 文章管理
  1.可对文章进行再编辑以及删除文章

- 发布文章
1.使用markdown编辑器，支持插入代码，插入图片等功能
2.文章可选择分类

- 分类管理，支持增加、删除、修改分类


#### 安装部署需求
- 可以使用docker方式部署（比较麻烦，我弄了一天也没弄好，没经验），也可支持-jar方式
- 使用springboot自带方式打包


## 项目设计

#### 总体设计
- **本项目用到的技术和框架**<br>
1.项目构建：Maven<br>
2.web框架：Springboot<br>
3.数据库ORM：Mybatis<br>
4.数据库连接池： Druid<br>
5.数据库：MySql<br>
6.前端模板：Thymeleaf<br>
7.文章展示：Editor.md<br>

- **环境**

|  工具 | 名称 
| ------------ | ------------
| 开发工具  | IDEA 
|  语言 | JDK1.8、HTML、css、js 
| 数据库  | Mysql8 
| 项目框架  | SSM 
| ORM  | JPA 
| 项目构建  | Maven 


## 数据设计

###### 用户表：user

CREATE TABLE `user` (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(32) NOT NULL,
  `username` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

###### 文章表：article

CREATE TABLE `article` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `content` text,
  `date` varchar(64) DEFAULT NULL,
  `summary` text,
  `title` varchar(255) DEFAULT NULL,
  `category_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKy5kkohbk00g0w88fi05k2hcw` (`category_id`),
  CONSTRAINT `FKy5kkohbk00g0w88fi05k2hcw` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

###### 文章分类：category
CREATE TABLE `category` (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `display_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


###### 评论：comments  (此功能未实现)


## 开发流程
###### 数据库CRUD
- controller层中编写前端接口，接收前端参数
- service层中编写所需业务接口，供controller层调用
- 实现service层中的接口，并注入mapper层中的sql接口
- 采用JPA ，接口实现JpaRepository，基本增删改查很方便，使用自动建表功能
- 关于事务的实现，在启动类中开启事务，并在service层需要实现事务的业务接口上使用`@Transactional`注解，还是十分方便的

###### 页面与展示
- emmm,使用了很多前辈的页面进行修改，鞠躬拜谢
- 前端页面与后端的交互主要是在controller包中，并使用Thymeleaf渲染页面。

#### 未来需增加的功能
- 注销登录功能，清理Session
- 自定义异常处理页面，实现自动跳转到404、403页面
- 文章评论功能
- 在写总结的时候发现，忘了分页功能了，emmm，因为测试数据不多

###### 网站建设  && 总结
- 服务器选用的是搬瓦工VPS
- 部署Docke 因为经验问题 折腾一天也没弄好
- 直接部署在Centos7 上也出现了本地前台功能报错
- 遂进行搁置，到后期版本完善，一并进行建设，预期有三个版本，这是第一个
- 第二个版本   使用Tale作为模板
- 第三个版本   加入安全框架SpringSecurity



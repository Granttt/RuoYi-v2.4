## 平台简介

一直想做一款后台管理系统，看了很多优秀的开源项目但是发现没有合适的。于是利用空闲休息时间开始自己写了一套后台系统。如此有了若依。她可以用于所有的Web应用程序，如网站管理后台，网站会员中心，CMS，CRM，OA。所有前端后台代码封装过后十分精简易上手，出错概率低。同时支持移动客户端访问。系统会陆续更新一些实用功能。

性别男，若依是女儿的名字。

若依基于hplus和inspinia两套后台系统模板开发。有需要可自行到群内下载。

http://www.zi-han.net/theme/hplus

http://webapplayers.com/inspinia_admin-v2.7.1

阿里云优惠活动（2CPU 4GRAM 1M带宽 40G高效云盘）：https://promotion.aliyun.com/ntms/act/vm/aliyun-group/buy.html?group=BphATfDhsQ

云产品通用1000元代金券，可叠加官网常规优惠使用 ：https://promotion.aliyun.com/ntms/yunparter/invite.html?userCode=brki8iof

## 内置功能

1.  用户管理：用户是系统操作者，该功能主要完成系统用户配置。
2.  部门管理：配置系统组织机构（公司、部门、小组），树结构展现支持数据权限。
3.  岗位管理：配置系统用户所属担任职务。
4.  菜单管理：配置系统菜单，操作权限，按钮权限标识等。
5.  角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
6.  字典管理：对系统中经常使用的一些较为固定的数据进行维护。
7.  参数管理：对系统动态配置常用参数。
8.  通知公告：系统通知公告信息发布维护。
9.  操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
10. 登录日志：系统登录日志记录查询包含登录异常。
11. 在线用户：当前系统中活跃用户状态监控。
12. 定时任务：在线（添加、修改、删除)任务调度包含执行结果日志。
13. 代码生成：前后端代码的生成（java、html、xml、sql)支持CRUD下载 。
14. 系统接口：根据业务代码自动生成相关的api接口文档。
15. 在线构建器：拖动表单元素生成相应的HTML代码。
16. 连接池监视：监视当期系统数据库连接池状态，可进行分析SQL找出系统性能瓶颈。
17. 新增CMS模块：文章管理，编写，公告的发布等。
18. OSS模块：集成阿里云OSS，七牛云，腾讯云等云存储。
## 在线体验
> admin/admin123

地址：http://www.ruoyi.club

## 演示图

<table>
    <tr>
        <td><img src="https://oscimg.oschina.net/oscnet/25b5e333768d013d45a990c152dbe4d9d6e.jpg"/></td>
        <td><img src="https://static.oschina.net/uploads/space/2018/0902/132411_4c5I_1438828.png"/></td>
    </tr>
    <tr>
        <td><img src="https://static.oschina.net/uploads/space/2018/0902/132436_rRBh_1438828.png"/></td>
        <td><img src="https://static.oschina.net/uploads/space/2018/0902/132442_umjM_1438828.png"/></td>
    </tr>
    <tr>
        <td><img src="https://static.oschina.net/uploads/space/2018/0902/132520_Zzkj_1438828.png"/></td>
        <td><img src="https://static.oschina.net/uploads/space/2018/0902/132539_5bJe_1438828.png"/></td>
    </tr>
	<tr>
        <td><img src="https://static.oschina.net/uploads/space/2018/0902/132548_ne4U_1438828.png"/></td>
        <td><img src="https://static.oschina.net/uploads/space/2018/0902/132557_Fab4_1438828.png"/></td>
    </tr>
    <tr>
        <td><img src="https://gaoxiyang.oss-cn-beijing.aliyuncs.com/ruoyi/1.png"/></td>
        <td><img src="https://gaoxiyang.oss-cn-beijing.aliyuncs.com/ruoyi/2.png"/></td>
    </tr> <tr>
        <td><img src="https://gaoxiyang.oss-cn-beijing.aliyuncs.com/ruoyi/3.png"/></td>
    </tr>
</table>


## 若依交流群

QQ群： [![加入QQ群](https://img.shields.io/badge/QQ群-1389287-blue.svg)](http://shang.qq.com/wpa/qunwpa?idkey=4a9a52f5d9d9c65a8ea67859170ba835d95fc50ec74a2a722293e60e036b5016) 或 [![加入QQ群](https://img.shields.io/badge/QQ群-1389287-blue.svg)](https://jq.qq.com/?_wv=1027&k=5HBAaYN)，推荐点击按钮入群，当然如果无法成功操作，请自行搜索群号`1389287`进行添加
## 若依文档
RuoYi 官网地址：http://ruoyi.vip

RuoYi 在线文档：http://doc.ruoyi.vip

RuoYi 源码下载：https://gitee.com/y_project/RuoYi

RuoYi 在线提问：https://gitee.com/y_project/RuoYi/issues

RuoYi 博客：https://www.oschina.net/p/ruoyi
## 自定义功能
增加cms文章功能

图片存储：七牛云，阿里云等OSS

2019-2-28
添加阿里云OSS下载文件功能（流式读取）及下载到本地功能

参考文档

https://help.aliyun.com/document_detail/32009.html?spm=a2c4g.11186623.6.658.64e273205nUqj4

http://aliyun_portal_storage.oss.aliyuncs.com/oss_api/oss_javahtml/object.html#id13

参考路径com.ruoyi.project.upload.FileUploadController

2019-03-06
目前只有管理员与普通用户两级，所以默认同级可强退（管理员除外）,如果后期加入更多级别用户，需要细致判断规则

加入判断后sys_user_online表新增了一个字段user_id用来记录登录用户id，然后通过id查询此用户的角色，再进一步判断是否可强退
需要注意，如果沿用老框架的，要把项目中user_id字段删掉。

wangbo_website_new.sql为增加字段后的新数据库文件，wangbo_website.sql为老文件

参考路径：com.ruoyi.project.monitor.online.controller.UserOnlineController

@ComponentScan注解，自定义扫描路径。如果你自定义的包不在boot启动类及其父类下，这需要使用该注解
指明你要扫描的包路径（用于springboot启动类上）

##  前端表格组件 

bootstrap，参考链接 https://www.cnblogs.com/laowangc/p/8875526.html

##  ruoyi登陆用户名密码验证流程：

com.ruoyi.project.system.user.controller.LoginController.AjaxResult(主要是subject.login(token)) -> 
com.ruoyi.framework.shiro.realm.UserRealm.doGetAuthenticationInfo(登录认证) -> com.ruoyi.framework.shiro.service.LoginService.login(里面的 
passwordService.validate(user, password)) ->com.ruoyi.framework.shiro.service.PasswordService.validate ->
com.ruoyi.framework.shiro.service.PasswordService.encryptPassword(验证密码方法，MD5加密)

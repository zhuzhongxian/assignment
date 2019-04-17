Spring大作业
完成学生登录并修改分数的功能模块的设计与实现。

实现步骤：

1）	创建工程stuManager
2）	添加.jar包
3）	创建web.xml文件
4）	创建springmvc-config.xml
5）	PO类1个:
创建com.itheima.po.Student.java:包括属性 
private Integer id;
private String stuname;
private String password;
private Double score;
6）	控制器2个
a)创建com.itheima.controller.loginController.java
private String toEditStuScore()，登录成功,跳转到edit_stuscore.jsp
b)创建com.itheima.controller.StuController.java
private String editStuScore(),处理修改学生分数信息的方法。
修改成功跳转到success.jsp，并显示分数信息；
不成功，跳转到error.jsp
7）	视图4个包括：login.jsp；edit_stuscore.jsp；success.jsp；error.jsp
8）	拦截器1个: 用于登录验证LoginInterceptor.java

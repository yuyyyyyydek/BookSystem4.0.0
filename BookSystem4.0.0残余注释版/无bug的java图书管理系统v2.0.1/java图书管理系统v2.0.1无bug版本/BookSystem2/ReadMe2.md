# 开发文档
## 包名
com.nan.dao包：数据库连接层，数据访问层\
com.nan.view包：视图层，图形化界面\
com.nan.middle包：中间层，暂时不懂放什么，应该是连接视图层与数据访问层的包\
com.nan.tool包：工具类文件\
com.nan.hint包:提示信息\
```
hint
暗示，提示；征兆，迹象；少许，少量；秘诀，窍门；暗示，示意；【名】 （Hint）（英）欣特，（法）安特（人名）；
```
## 第一步：首先写登录界面，类在view里
Login:登录：登录界面的编写
## 第二步：编写登录界面途中设计文本上限限制工具---JTextFieldLimit
## 第三步：编写登陆界面途中设计点击文本框消失文字工具--- Remove
## 第四步：编写登陆界面途中设计获取文本框中内容的工具---Gain
小提示：编程过程中出现无法调用登陆窗口的方法，正确的方法调用位：
new Login().login();  不管是不是类都要加括号
## 第五步：编写登陆界面的账号密码数据库比对的类---数据库访问层---LoginDao
RegisterDao:该类访问数据库中的账号表
## 第六步：在Login中实现遍历循环数据库账号密码，与用户输入的账号密码比较，相同则登陆成功
~~~
operation:
运作，实施；运转，操作；手术；（有组织的）活动，行动；军事行动；企业，公司；业务，经营 ；（数学）运算
decide
影响（或决定）……的结果；断定，判定；使下决心；决定，选定；裁决，判决；
~~~
## 难点1：
可以在调用getText()之前添加一个null检查，例如：

if (textField != null) {
String text = textField.getText();
// 其他操作
}

## 难点2：数据访问层的内容如何在其他类中使用
1：
public List<User> getAllUsers() throws ClassNotFoundException {//创建一个User的集合，并抛出ClassNotFoundException异常
List<User> users = new ArrayList<>();//集合初始化

        Class.forName(driver);//注册驱动

        try (Connection conn = DriverManager.getConnection(url,username,password);//获取数据库连接对象
             Statement stmt = conn.createStatement();//获取执行sql的对象，Statement，创建Statement对象
             ResultSet rs = stmt.executeQuery(sql)) { //执行sql

            while(rs.next()){//遍历rs集合中的内容
                User user = new User();//创建一个User对象
                user.setUsername(rs.getString("username"));//user对象设置该对象的用户id，括号中为从数据库中得到账号数据信息
                user.setPassword(rs.getString("password"));//user对象设置该对象的密码，括号中为数据库中得到的密码数据信息

                users.add(user);//将该user对象添加到users集合中
            }

        } catch (SQLException e) {//捕获异常
            e.printStackTrace();
        } catch (Exception e) {//捕获异常
            throw new RuntimeException(e);
        }

        return users;//返回users集合
    }

2：

public class User {
private String username;
private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

3：

LoginDao log = new LoginDao();//实例化LoginDao类
java.util.List<User> users = null;//创建list集合//----======》很重要的地方，很难搞，无数次失败才出现这个的成功
try {
users = log.getAllUsers();//users中存有所有的数据库表中的用户账号密码
} catch (ClassNotFoundException ex) {//捕获异常
throw new RuntimeException(ex);//异常处理
}

            for(User user : users){ //遍历循环User集合
                //System.out.println("user:" + user.getUsername() + ",pass:" + user.getPassword());//显示数据库中所有账号密码
                if(user.getUsername().equals(getAccount())){//如果用户输入的账号与数据库中的账号一样，进入此if
                    if(user.getPassword().equals(getPassword())){//如果用户输入的密码与数据库中的密码一样，进入此if
                        System.out.println("终于登录成功");
                    }
                }


## 第七步：编写登陆成功画面的窗口,提示用户登陆成功,类名为:Succeed
## 第八步：编写图书管理系统主界面-----MainApp类
第八步中包括菜单栏选项和四个主界面的按钮，增删改查，并为之添加事件监听，借阅系统的按钮后续添加
## 第九步：编写窗口数量限制类----staticdata类,该类还会传出要修改的图书ID等内容,该类在主界面设计MainApp类中
~~~
count
v.
（按顺序）数数；计数，点数目；把……算入，包括；重要；被允许，被接受；看作，认为

n.
计算，总数；数数；量的计数；（被指控的）罪状，事项；论点，观点；伯爵；（纱线的）支数

~~~
## 第十步:编写图书查询功能----See类,该类涉及俩个查询表，默认显示表和搜索表

## 第十一步：编写查询表数据时候遇见了创建2个表格数据的问题：问题的出现与解决分别为以下内容
//                if(booktext==null){//正确运行，一个表格
if(booktext.equals("")){//错误运行，2个表格
seeall();
该方法应该采用 booktext==null  的这种方法才可以只能创建一个数据表格
## 第十二步：编写完图书查询，之后编写图书修改 ---Upd类，Updata类,Updata2类，UpdataView类
制作更新图书信息的时候发现被母窗口创建的子窗口不能设置关闭方式，不然会连同母窗口一起关闭
## 第十三步：编写图书删除类------Del类
## 第十四步：编写图书增添类 ----Add类，AddDAO类
## 第十五步：编写注册类 ----AddUserDao等类
## 第十六步：编写用户增加类----AddUser类等类
## 第十七步：编写用户删除类----DelUser类  等类
## 新 第十八步 借阅系统建设，Lend类部分
~~~
lend
借给，借出；贷出，贷（款）；给……增加，增添（特色）；给予，提供（帮助、支持等）；使适合，使易遭受；【名】 （Lend）（德）伦德（人名）；
~~~


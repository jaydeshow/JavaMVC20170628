20170628
+Eclipse.gitignore
湯姆貓安裝8.044全選，安裝完動起來
測試http://10.131.35.7:8080/
http://localhost:8080/

DD file(https://en.wikipedia.org/wiki/Deployment_descriptor)
部屬檔案 web.xml

設定部屬server (deploy MyEclispse)
add->edit server connector->server->tomcat->8.x->enable
C:\Program Files\Apache Software Foundation\Tomcat 8.0
退開重加
測試網頁 http://localhost:8080/chtweb/

來使用struts 先下載
http://apache.stu.edu.tw/struts/2.5.10.1/struts-2.5.10.1-all.zip

..!老師用1.6我用1.7Lib不知道會不會有差別

怎麼用工具整合 lib 跟配置檔
滑鼠右鍵 myeclipse->project factes -> install apache struts 2.x(factes) 先預設 core
用到 web.xml 來進行部屬到底是要走 struts 還是 js servelet container
手動 reploy 才會看到 lib (執行階段才會看到，用工具只是單純link上去)
C:\Program Files\Apache Software Foundation\Tomcat 8.0\webapps\chtweb\WEB-INF\lib


Filter 攔截(Interceptor)
request到達web container->filter->WebApp 
https://dzone.com/articles/struts2-tutorial-part-57
http://img.viralpatel.net/2009/12/struts-2-request-cycle.png
Struts 2 Interceptors: Basics
Struts2 provides very powerful mechanism of controlling a request using Interceptors. Interceptors are responsible for most of the request processing. They are invoked by the controller before and after invoking action, thus they sits between the controller and action. Interceptors performs tasks such as Logging, Validation, File Upload, Double-submit guard etc.

struts2 front end controller
不是網頁，但是對應到 struts config(src/struts.xml) / java string(flag回應給配置檔) class method(...)
https://image.slidesharecdn.com/struts2-130214054355-phpapp01/95/struts2-5-638.jpg?cb=1360820919
https://image.slidesharecdn.com/struts2spring-090823045856-phpapp02/95/struts-2-spring-5-728.jpg?cb=1272041750
執行階段在C:\Program Files\Apache Software Foundation\Tomcat 8.0\webapps\chtweb\WEB-INF\classes\struts.xml

create 視覺化 hello 不給namespace就是根目錄 繼承structs-default
myelipse new action->name helloworld->new class com.cht.domain.HelloController
ctrl+shift+f自動排版，視覺化工具排版不是很好

http://10.131.35.7:8080/chtweb/helloworld.action
HTTP Status 404 - There is no Action mapped for namespace / and action name helloworld.
先把他補完，要把action result先加上去
new action result->name success->result type預設dispatcher->派送到哪一個畫面(view)

只有action派送的道的view，被保護的資料夾WEB-INF
create jsp ->file path /chtweb/WebRoot/WEB-INF ->file name hello.jsp
edit -> location /WEB-INF/hello.jsp
註解不能寫到 (inner text) result tag內
http://localhost:8080/chtweb/WEB-INF/hello.jsp
HTTP Status 404 -

https://tomcat.apache.org/tomcat-5.5-doc/servletapi/javax/servlet/RequestDispatcher.html
https://www.javatpoint.com/images/requestdispatcher.JPG

下午交被struts隔離後怎麼跟底層jsp互動

struts api
https://struts.apache.org/maven/struts2-core/apidocs/
org.apache.struts2 ServletActionContext 
static javax.servlet.http.HttpServletRequest	getRequest()
設定request的屬性 request.setAttribute("msg", mesage);
最後由 jsp呈現 String msg = (String)request.getAttribute("msg");
http://localhost:8080/chtweb/chthello.action

換成不同派送是否會持續?
edit 換其他派送方式-redirect 狀態是不會過去的!!
http://localhost:8080/chtweb/WEB-INF/hellostate.jsp
HTTP Status 404 -(安全性問題)

加namespace package customers namespace /customers struts-default package
+Action customersform com.cht.domain.CustomersController
+view html5 /WEB-INF/customers.html
+result指向 view
測試 http://localhost:8080/chtweb/customers/customersform.action

結合動態頁面(JSP)與靜態頁面(HTML5)

Ctrl + /                - 新增/取消註解符號 //
Ctrl + Shift + /   - 新增註解 /*  */
Ctrl + Shift + \   - 取消註解 /*  */
Alt + Shift + J   - 替Field, Class, Method 加上註解

name="customerid"
與重新整理redeploy 有 cache問題

改用物件傳遞及EL與法display
透過eclipse把confirm.jsp customers.html歸類到WEB-INF/customers資料夾
https://openhome.cc/Gossip/ServletJSP/ELProperty.html

安裝 mysql-installer-community-5.7.18.1.msi
組態設定都預設 name-pipe 勾一下 root/1111

構思database api層
https://docs.oracle.com/javase/7/docs/api/index.html?java/sql/Connection.html (frames)
connection pool jdbc
javax.sql
Interface DataSource
https://commons.apache.org/proper/commons-dbcp/api-1.4/org/apache/commons/dbcp/BasicDataSource.html

Model變化最大 (重複使用 修改成本很大是新建立系統的兩三倍 injection)
Data Access
Formula
Expression
Rule
使用 [Design Pattern] Class Factory Pattern &  工廠方法模式(Factory Method Pattern) 
spring 實現工廠模式 向前相容 改版 抽換零件概念

DataSource開啟連接進入Connection pooling操作底層JDBC
資料存取的Rule DAO(Data Access Object Pattern)
實現Dependency Injection(Spring IOC)
https://projects.spring.io/spring-framework/

20170629
spring下載官方網站 https://projects.spring.io/spring-framework/

install spring facet 3.1
applicationContext.xml 可以改，用xml做部屬不建議先做annotation(寫在類別裡彈性不大)慢慢來
AOP可以作稽核(LOG)
要勾spring persistence 其他預設
然後redeploy 把jar檔佈到執行階段...

練習一個簡單對資料庫的查詢(action)

include另一個組態配置 customers.xml
open with struts2 config editor

作package sakila /customers struts-default
+action countryquery com.cht.domain.CountryController 痘痘兩下
+jsp
+action result
把湯姆貓動起來 monitor tomcat ->start redeploy
http://localhost:8080/chtweb/customers/countryquery.action

用 BasicDataSource database;再用工具補完 (import org.apache.commons.dbcp.BasicDataSource)
https://www.tutorialspoint.com/jdbc/jdbc-db-connections.htm java database connection url

遇到少打一個 slash的錯誤
https://stackoverflow.com/questions/38774282/how-to-resolve-cannot-create-jdbc-driver-of-class-com-mysql-jdbc-driver-for-c

StringWriter errors = new StringWriter();
e.printStackTrace(new PrintWriter(errors));
msg = "連接失敗!!"+errors.toString();
故意測密碼錯誤
連接失敗!!org.apache.commons.dbcp.SQLNestedException: Cannot create PoolableConnectionFactory (Access denied for user 'root'@'localhost' (using password: YES)) at org.apache.commons.dbcp.BasicDataSource.createPoolableConnectionFactory(BasicDataSource.java:1549) at 

change workspace encoding to utf-8
preference->general->workspace->text file encoding 沒成功

1. 借助 datasource配置連接物件
2. 建構DAO物件 介面操作
3. 建構Country對應class arraylist處理及EL display 後面用jstl foreach (可以搭配EL)
https://www.tutorialspoint.com/jsp/jstl_core_foreach_tag.htm
外掛標籤庫
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

如果不相容自己做
last_update改用String存(舊方法)顯示會變成2006/2/15 上午 12:00:00
不用request.setAttribute而改用屬性的方式

改用spring方式屬性注入設定資料連接管理 指向同一個View
http://localhost:8080/chtweb/customers/countrylist.action
參考 https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/support/ClassPathXmlApplicationContext.html
定義工廠 XML規範

改嘗試dao物件連接成功

改嘗試OGNL EL
變數類似，算術運算則是不同
http://langgufu.iteye.com/blog/2111706
影藏JAVA語法全部用標籤呈現

不是所有html5標籤都支援的
https://html5test.com/

action configure在類別上描述而非在描述檔XML
init-method未定義

停用tomcat 用run的 tom 8x就會有console訊息...
Caused by: 元素類型 "action" 必須宣告屬性 "init-method"。 - file:/C:/Program%20Files/Apache%20Software%20Foundation/Tomcat%208.0/webapps/chtweb/WEB-INF/classes/customers.xml:17:52
	at com.opensymphony.xwork2.util.DomHelper.parse(DomHelper.java:115)

client side validation
動態標籤如何jquery??
用選擇器的觀念去參考動態標籤

我們不要去動標籤，click用前端去控制補一下

命名空間不會過來
http://localhost:8080/chtweb/querydata.action

message No result defined for action com.cht.domain.ChtCustomersController and result success
沒有指定method name methodname大小寫要一樣

使用Spring JDBCTemplate
https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html
JdbcTemplate(DataSource dataSource)
建構子注入
http://zzy7182.iteye.com/blog/1153473
用index ref
驗證是否依從關係正確 view org.apache.commons.dbcp.BasicDataSource@29bf1f29

沒有單元測試不知道錯在哪邊
寫一段測一段

jdbc丟回來就是一個for object
要自己封成物件  generic觀念就會在裡面
自訂查詢結果處理function-callback a delegate
匿名類別時做RowMapper 建構成物件

20170630
帶一點OGNL input form 怎麼結合model 與 controller

FK與下拉式功能表aliasid
驗證的確有5筆
[com.cht.domain.Alias@3b60fc65, com.cht.domain.Alias@5c5a6957, com.cht.domain.Alias@33b9fe1f, com.cht.domain.Alias@77dabfc0, com.cht.domain.Alias@3a6313b9]

s:select 預設call toString method 所以要override
但是還是沒完全解決 key value
label是前面的TD名稱文字提示
找到!! listValue = "alias" listKey="aliasid" 
https://stackoverflow.com/questions/22420421/setting-a-struts2-select-tag-to-a-variable-from-the-request-object

進行ajax invoke server-side REST Service
自己加一層table 加一些自訂表格內容才不會display時亂跑
down一下jquery的框架 
cross site issue?

覺得礙眼jquery
https://stackoverflow.com/questions/4282448/change-eclipse-settings-to-ignore-errors-on-a-specific-file

JAX-RS (rest)
安裝2.0
六月 30, 2017 11:35:25 上午 org.apache.catalina.core.StandardContext loadOnStartup
嚴重: Servlet [JAX-RS Servlet] in web application [/chtweb] threw load() exception
jax-rs api
https://docs.oracle.com/javaee/7/api/javax/ws/rs/package-summary.html
javax.ws.rs
Annotation Type Path
mime types 
javax.ws.rs
Annotation Type Produces
http://localhost:8080/chtweb/service/hello/chthello 亂碼!用html之類

https://github.com/google/gson
後來直接抓gson .jar
http://localhost:8080/chtweb/service/customers/cidvalid?cid=001

XMLHttpRequest cannot load http://10.131.35.7:8080/chtweb/service/customers/cidvalid?cid=C001. No 'Access-Control-Allow-Origin' header is present on the requested resource. Origin 'http://localhost:8080' is therefore not allowed access. The response had HTTP status code 403.
cross site
安全性考量 不是那麼簡單
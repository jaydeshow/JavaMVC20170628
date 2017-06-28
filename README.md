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
與重新整理redeploy


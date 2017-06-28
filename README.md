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

怎麼用工具整合 lib 跟配置黨
滑鼠右鍵 myeclipse->project factes -> install apache struts 2.x(factes) 先預設 core
用到 web.xml 來進行部屬到底是要走 struts 還是 js servelet container
手動 reploy 才會看到 lib (執行階段才會看到，用工具只是單純link上去)
C:\Program Files\Apache Software Foundation\Tomcat 8.0\webapps\chtweb\WEB-INF\lib




# api
this is sdk base lemodo, provide CRUD Data Service interface.


#使用说明
到指定工程中添加依赖
<dependency>
			<groupId>com.wldst</groupId>
			<artifactId>api</artifactId>
			<version>0.0.26-SNAPSHOT</version>
		</dependency>
调用代码：直接调用RuderApi类的相关方法，即可实现增删改查。
 import com.wldst.ruder.api.RuderApi;
 
	Map<String, Object> param = newMap();
	Long id2 = getUserId(user);

	Map<String, Object> chatSession = RuderApi.getAttMapBy("id", sessionId, "ChatSession");
	if (chatSession != null) {
	    String title = string(chatSession, "title");
	    if (title == null) {
		chatSession.put("title", title);
		sessionId = String.valueOf(RuderApi.save(chatSession, "ChatSession"));
	    }
	} else {
	    chatSession = newMap();
	    chatSession.put("title", prompt);
	    chatSession.put("userId", id2);
	    sessionId = String.valueOf(RuderApi.save(chatSession, "ChatSession"));
	} 
3、配置好lemodo项目地址在对应的业务配置文件： src/main/resources/application.properties，添加一下配置
ruder_url=http://localhost:9500/
ruder_name=root
    

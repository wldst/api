package com.wldst.ruder.util;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.ConnectException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

/**
 * 通用工具类
 * 
 * @author liyufeng
 * @date 20141015
 */
public class CommonUtil extends MapTool {
    private static Logger log = LoggerFactory.getLogger(CommonUtil.class);

    // 凭证获取（GET）
    public final static String token_url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=CORPID&corpsecret=CORPSECRET";
    public final static String iwg_token_url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=CORPID&corpsecret=CORPSECRET";

    /**
     * 发送https请求
     * 
     * @param requestUrl    请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param data          提交的数据
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static Map<String,Object> httpsPOST(String requestUrl, String data) {
	JSONObject jsonObject = null;
	try {
	    // 创建SSLContext对象，并使用我们指定的信任管理器初始化
	    TrustManager[] tm = { new MyX509TrustManager() };
	    SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
	    sslContext.init(null, tm, new java.security.SecureRandom());
	    // 从上述SSLContext对象中得到SSLSocketFactory对象
	    SSLSocketFactory ssf = sslContext.getSocketFactory();

	    URL url = new URL(requestUrl);
	    System.out.println(url);
	    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
	    conn.setSSLSocketFactory(ssf);

	    conn.setDoOutput(true);
	    conn.setDoInput(true);
	    conn.setUseCaches(false);
	    // 设置请求方式（GET/POST）
	    conn.setRequestMethod("POST");
	    conn.setRequestProperty("accept", "*/*");
	    conn.setRequestProperty("connection", "Keep-Alive");
	    conn.setRequestProperty("content-Type", "application/json");
	    conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

	    // 当outputStr不为null时向输出流写数据
	    if (null != data) {
		OutputStream outputStream = conn.getOutputStream();
		// 注意编码格式
		outputStream.write(data.getBytes("UTF-8"));
		outputStream.close();
	    }

	    // 从输入流读取返回内容
	    InputStream inputStream = conn.getInputStream();
	    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
	    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

	    String str = null;
	    StringBuffer buffer = new StringBuffer();
	    while ((str = bufferedReader.readLine()) != null) {
		buffer.append(str);
	    }

	    // 释放资源
	    bufferedReader.close();
	    inputStreamReader.close();
	    inputStream.close();
	    inputStream = null;
	    conn.disconnect();
	    jsonObject = JSONObject.parseObject(buffer.toString());
	} catch (ConnectException ce) {
	    log.error("连接超时：{}", ce);
	} catch (Exception e) {
	    log.error("https请求异常：{}", e);
	}
	return jsonObject;
    }

    /**
     * 发送https请求
     * 
     * @param requestUrl    请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr     提交的数据
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static Map<String,Object> httpsRequest(String requestUrl, String requestMethod, String outputStr) {
	JSONObject jsonObject = null;
	try {
	    // 创建SSLContext对象，并使用我们指定的信任管理器初始化
	    TrustManager[] tm = { new MyX509TrustManager() };
	    SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
	    sslContext.init(null, tm, new java.security.SecureRandom());
	    // 从上述SSLContext对象中得到SSLSocketFactory对象
	    SSLSocketFactory ssf = sslContext.getSocketFactory();

	    URL url = new URL(requestUrl);
	    System.out.println(url);
	    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
	    conn.setSSLSocketFactory(ssf);

	    conn.setDoOutput(true);
	    conn.setDoInput(true);
	    conn.setUseCaches(false);
	    // 设置请求方式（GET/POST）
	    conn.setRequestMethod(requestMethod);

	    // 当outputStr不为null时向输出流写数据
	    if (null != outputStr) {
		OutputStream outputStream = conn.getOutputStream();
		// 注意编码格式
		outputStream.write(outputStr.getBytes("UTF-8"));
		outputStream.close();
	    }

	    // 从输入流读取返回内容
	    InputStream inputStream = conn.getInputStream();
	    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
	    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

	    String str = null;
	    StringBuffer buffer = new StringBuffer();
	    while ((str = bufferedReader.readLine()) != null) {
		buffer.append(str);
	    }

	    // 释放资源
	    bufferedReader.close();
	    inputStreamReader.close();
	    inputStream.close();
	    inputStream = null;
	    conn.disconnect();
	    jsonObject = JSONObject.parseObject(buffer.toString());
	} catch (ConnectException ce) {
	    log.error("连接超时：{}", ce);
	} catch (Exception e) {
	    log.error("https请求异常：{}", e);
	}
	return jsonObject;
    }

    public static Token getIgwToken(String corpid, String corpsecret) {
	Token token = null;
	String requestUrl = iwg_token_url.replace("CORPID", corpid).replace("CORPSECRET", corpsecret);
	// 发起GET请求获取凭证
	Map<String,Object> jsonObject = httpsRequest(requestUrl, "GET", null);

	if (null != jsonObject) {
	    try {
		token = new Token();
		token.setAccessToken(string(jsonObject,"access_token"));
		token.setExpiresIn(integer(jsonObject, "expires_in"));
	    } catch (JSONException e) {
		token = null;
		// 获取token失败
		log.error("获取token失败 errcode:{} errmsg:{}", integer(jsonObject, "errcode"),
			string(jsonObject,"errmsg"));
	    }
	}
	return token;
    }

    /**
     * 获取接口访问凭证
     * 
     * @param corpid     凭证
     * @param corpsecret 密钥
     * @return
     */
    public static Token getToken(String corpid, String corpsecret) {
	Token token = null;
	String requestUrl = token_url.replace("CORPID", corpid).replace("CORPSECRET", corpsecret);
	// 发起GET请求获取凭证
	Map<String,Object> jsonObject = httpsRequest(requestUrl, "GET", null);

	if (null != jsonObject) {
	    try {
		token = new Token();
		token.setAccessToken(string(jsonObject,"access_token"));
		token.setExpiresIn(integer(jsonObject, "expires_in"));
	    } catch (JSONException e) {
		token = null;
		// 获取token失败
		log.error("获取token失败 errcode:{} errmsg:{}", integer(jsonObject, "errcode"),
			string(jsonObject,"errmsg"));
	    }
	}
	return token;
    }

    /**
     * URL编码（utf-8）
     * 
     * @param source
     * @return
     */
    public static String urlEncodeUTF8(String source) {
	String result = source;
	try {
	    result = java.net.URLEncoder.encode(source, "utf-8");
	} catch (UnsupportedEncodingException e) {
	    e.printStackTrace();
	}
	return result;
    }

    /**
     * 根据内容类型判断文件扩展名
     * 
     * @param contentType 内容类型
     * @return
     */
    public static String getFileExt(String contentType) {
	String fileExt = "";
	if ("image/jpeg".equals(contentType))
	    fileExt = ".jpg";
	else if ("audio/mpeg".equals(contentType))
	    fileExt = ".mp3";
	else if ("audio/amr".equals(contentType))
	    fileExt = ".amr";
	else if ("video/mp4".equals(contentType))
	    fileExt = ".mp4";
	else if ("video/mpeg4".equals(contentType))
	    fileExt = ".mp4";
	return fileExt;
    }

    /**
     * 通用取结果方案,返回list
     * 
     * @param rs
     * @return
     * @throws SQLException
     */
    public static List extractData(ResultSet rs) throws SQLException {
	ResultSetMetaData md = rs.getMetaData();
	int num = md.getColumnCount();
	List listOfRows = new ArrayList();
	while (rs.next()) {
	    Map mapOfColValues = new HashMap(num);
	    for (int i = 1; i <= num; i++) {
		if (rs.getObject(i) != null) {
		    mapOfColValues.put(md.getColumnName(i).toUpperCase(), String.valueOf(rs.getObject(i)));
		} else {
		    mapOfColValues.put(md.getColumnName(i).toUpperCase(), rs.getObject(i));
		}
	    }
	    listOfRows.add(mapOfColValues);
	}
	return listOfRows;
    }

    public static String formatTime(long longTime) {
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	return format.format(new Date(longTime));
    }

}

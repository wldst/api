package com.wldst.ruder;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class DbCodeTest {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	String comments = "������,contracttelphone,�����,���� ,faxphone,id,������(01:�  02:�),����,������:1�����(���),2�����,����,orderno,ordernum,orgabname,orgaddress,orgemail,orgenglishname,orgname,orgno,parentorgid,postcode,����,remark,status,virtualflag";
	String utf8Comments = new String(comments.getBytes(), StandardCharsets.UTF_8);
	
	System.out.println(utf8Comments);
	
	byte[] gbkBytes;
	try {
	    gbkBytes = comments.getBytes("GBK");
	    String utf8Str = new String(gbkBytes, "UTF-8"); // 将GBK编码的字节数组转换为UTF-8编码的字符串
		System.out.println(utf8Str); // 输出转换后的UTF-8编码字符串
	} catch (UnsupportedEncodingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} // 将字符串转换为GBK编码的字节数组
	 
	try {
	    gbkBytes = comments.getBytes("GB2312");
	    String utf8Str = new String(gbkBytes, "UTF-8"); // 将GBK编码的字节数组转换为UTF-8编码的字符串
		System.out.println(utf8Str); // 输出转换后的UTF-8编码字符串
	} catch (UnsupportedEncodingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} // 将字符串转换为GBK编码的字节数组
	
    }

}

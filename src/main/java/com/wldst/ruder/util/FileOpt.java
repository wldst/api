package com.wldst.ruder.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;

public class FileOpt {
    public static String getImportFileData(String path) {
	File file = new File(path);
	if (file.exists()) { // 判断文件父目录是否存在
	    return read(file);
	}
	return null;
    }

    public static String read(File file) {
	byte[] buffer = new byte[1024];
	StringBuilder sBuilder = new StringBuilder();
	try {
	    try (FileInputStream fis = new FileInputStream(file);
		    BufferedInputStream bis = new BufferedInputStream(fis);) {
		int len = 0;
		while ((len = bis.read(buffer)) > -1) {
		    String str = new String(buffer, 0, len);
		    sBuilder.append(str);
		}
	    }
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return sBuilder.toString();
    }

    public static String readFileContent(String fileName) {
	File file = new File(fileName);
	return readFileContent(file);
    }

    public static String readFileContent(File file) {
	StringBuffer sbf = new StringBuffer();
	try {

	    try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
		String tempStr;
		while ((tempStr = reader.readLine()) != null) {
		    sbf.append(tempStr);
		}
	    }
	    return sbf.toString();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return sbf.toString();
    }
//    public static String readfile(String filePath) {
//	List<String> lines=new ArrayList<>();
//
//	String line = null;
//	try(BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"UTF-8"));) {
//	    while ((line = br.readLine()) != null) {
//	       lines.add(line);
//	    }
//	    br.close();
//	} catch (IOException e) {
//	    // TODO Auto-generated catch block
//	    e.printStackTrace();
//	}
//
//	return String.join("",lines);	
//    }
    
    public static List<List<String>> readfile(InputStream fis,String sep) {
	List<List<String>> lines=new ArrayList<>();

	String line = null;
	try(BufferedReader br=new BufferedReader(new InputStreamReader(fis,"UTF-8"));) {
	    while ((line = br.readLine()) != null) {
		List<String> di=new ArrayList<>();
		String[] split = line.split(sep);
		for(String si: split) {
		    di.add(si);
		}
		lines.add(di);
	    }
	    br.close();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return lines;	
    }

//    public static String readFile(File file) {	
//	
//	List<String> lines=new ArrayList<>();
//
//	String line = null;
//	try(BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));) {
//	    while ((line = br.readLine()) != null) {
//	    lines.add(line);
//	    }
//	    br.close();
//	} catch (IOException e) {
//	    // TODO Auto-generated catch block
//	    e.printStackTrace();
//	   
//	}
//
//	return String.join("",lines);
//    }

    public static String readUtf8(String fileName) {

	StringBuffer lines = new StringBuffer();

	FileInputStream in;
	try {
	    in = new FileInputStream(fileName);
	    readFromFile(lines, in);
	} catch (FileNotFoundException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	} catch (UnsupportedEncodingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return lines.toString();
    }

    public static String readGBK(String fileName) {

	StringBuffer lines = new StringBuffer();

	FileInputStream in;
	try {
	    in = new FileInputStream(fileName);
	    readGBKFromFile(lines, in);
	} catch (FileNotFoundException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	} catch (UnsupportedEncodingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return lines.toString();
    }

    public static String readUtf8(File fileObj) {

	StringBuffer lines = new StringBuffer();

	FileInputStream in;
	try {
	    in = new FileInputStream(fileObj);
	    readFromFile(lines, in);
	} catch (FileNotFoundException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	} catch (UnsupportedEncodingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return lines.toString();
    }

    private static void readFromFile(StringBuffer lines, FileInputStream in)
	    throws IOException, UnsupportedEncodingException {
	try (BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"))) {
	    String line = null;

	    while ((line = br.readLine()) != null) {

		lines.append(line);
	    }
	}
    }

    private static void readGBKFromFile(StringBuffer lines, FileInputStream in)
	    throws IOException, UnsupportedEncodingException {
	try (BufferedReader br = new BufferedReader(new InputStreamReader(in, "GBK"))) {
	    String line = null;

	    while ((line = br.readLine()) != null) {

		lines.append(line);
	    }
	}
    }

    public static void writeFile(String file, String pathname) {
	try {
	    File desFile = new File(pathname);
	    File parentFile = desFile.getParentFile();
	    if(!parentFile.exists()) {
		parentFile.mkdirs();
	    }
	    try (FileOutputStream fosFileOutputStream = new FileOutputStream(desFile);) {
		fosFileOutputStream.write(file.getBytes("UTF-8"));
		fosFileOutputStream.flush();
	    }
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public static boolean move(File srcFile, String destPath) {
	// Destination directory
	File dir = new File(destPath);

	// Move file to new directory
	boolean success = srcFile.renameTo(new File(dir, srcFile.getName()));

	return success;
    }

    public static boolean move(String srcFile, String destPath) {
	// File (or directory) to be moved
	File file = new File(srcFile);

	// Destination directory
	File dir = new File(destPath);

	// Move file to new directory
	boolean success = file.renameTo(new File(dir, file.getName()));

	return success;
    }

    public static void copy(String oldPath, String newPath) {
	File oldfile = new File(oldPath);
	if (oldfile.exists()) {
	     
	    try (InputStream inStream = new FileInputStream(oldPath);
		    FileOutputStream fs = new FileOutputStream(newPath);) {
	    int bytesum = 0;
	    int byteread = 0;
		byte[] buffer = new byte[1444];
		while ((byteread = inStream.read(buffer)) != -1) {
		    bytesum += byteread;
		    fs.write(buffer, 0, byteread);
		}
		inStream.close();
	    } catch (Exception e) {
		System.out.println("error  ");
		e.printStackTrace();
	    }
	}
    }
    
    public static void write(String newPath, String content) {
	try (FileOutputStream fs = new FileOutputStream(newPath);) {

	    byte[] buffer = content.getBytes();
	    fs.write(buffer, 0, buffer.length);
	} catch (Exception e) {
	    System.out.println("error  ");
	    e.printStackTrace();
	}
    }
    public static void writeImg(String newPath, String content) {
	File f = new File(newPath);
	ImageBase64Converter.convertBase64ToFile(content, f.getParent(), f.getName());
    }
    
    /**
    * 把base64图片数据转为本地图片
    * @param base64ImgData
    * @param filePath
    * @throws IOException
    */
    public static void convertBase64DataToImage(String base64ImgData,String filePath) throws IOException {
       
      byte[] bs = Base64.decodeBase64(base64ImgData);
      FileOutputStream os = new FileOutputStream(filePath);
      os.write(bs);
      os.close();
    }
  //base64字符串转化成图片
    public static boolean GenerateMapImage(String imgStr , String filePath) {
        //处理base64字符串
        imgStr = imgStr.replaceAll(" ", "+").replace("data:image/png;base64,", "");
        //对字节数组字符串进行Base64解码并生成图片
        try {
            byte[] b = Base64.decodeBase64(imgStr);
            for (int i = 0; i < b.length; ++i) {
                // 调整异常数据
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream(filePath);
            //写入数据
            out.write(b);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 二进制转字符串
     * @param b
     * @return
     */
    public static String byte2hex(byte[] b){
	StringBuffer sb = new StringBuffer();
	String stmp = "";
	for (int n = 0; n < b.length; n++) {
	    stmp = Integer.toHexString(b[n] & 0XFF);
	    if (stmp.length() == 1) {
		sb.append("0" + stmp);
	    } else {
		sb.append(stmp);
	    }
	}
	return sb.toString();

    }
    /**
     * 字符串转二进制
     * @param str
     * @return
     */
    public static byte[] hex2byte(String str) {
	if (str == null) {
	    return null;
	}

	str = str.trim();
	int len = str.length();
	if (len == 0 || len % 2 == 1) {
	    return null;
	}
	byte[] b = new byte[len / 2];
	try {
	    for (int i = 0; i < str.length(); i += 2) {
		b[i / 2] = (byte) Integer.decode("0X" + str.substring(i, i + 2)).intValue();
	    }
	    return b;
	} catch (Exception e) {
	    return null;
	}
    }

    public static void copy(File oldfile, String newPath) {
	if (oldfile.exists()) {
	try (InputStream inStream = new FileInputStream(oldfile);
		FileOutputStream fs = new FileOutputStream(newPath);){
	    int bytesum = 0;
	    int byteread = 0;
	    // File oldfile = new File(oldPath);
		byte[] buffer = new byte[1024];
		while ((byteread = inStream.read(buffer)) != -1) {
		    bytesum += byteread;
		    fs.write(buffer, 0, byteread);
		}
	} catch (Exception e) {
	    System.out.println("error  ");
	    e.printStackTrace();
	}
	}
    }
}

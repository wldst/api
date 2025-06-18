package com.wldst.ruder.domain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.wldst.ruder.api.RuderApi;
import com.wldst.ruder.util.FileOpt;

/**
 * 文件相关的常量
 * 
 * @author wldst
 *
 */
public class FileDomain extends SystemDomain {
    public static final String FILE = "File";
    public static final String FILE_SHOW_URL = "/cd/file/show/";
    public static final String FILE_DOWN_URL = "/cd/file/download/";
    public static final String FILE_PATH = "path";
    public static final String FILE_STORE_NAME = "fileStoreName";
    public static final String FILE_SIZE = "FileSize";
    public static final String FILE_TYPE = "FileType";
    

    public static final String FILE_TYPE_JSON = "json";
    public static final String FILE_TYPE_ZIP = "zip";
    public static final String FILE_TYPE_RAR = "RAR";
    public static final String FILE_TYPE_XLS = ".xls";
    public static final String FILE_TYPE_XLSX = ".xlsx";

    public static final String FILE_PORT = "filePort";
 

    public static boolean isFileExist(String string) {
	File file2 = new File(string);
	return string != null && file2.exists() && !file2.isDirectory();
    }
    
    public static boolean delete(String string) {
	File file2 = new File(string);
	if(file2.exists()) {
	    deleteFile(file2);
	}
	
	return string != null && file2.exists() && !file2.isDirectory();
    }

    public static void deleteFile(File file2) {
	if(file2.isFile()) {
	    file2.delete();
	}else {
	    File[] listFiles = file2.listFiles();
	    if(listFiles!=null) {
		for(File fi:listFiles) {
			deleteFile(fi);
		    }
	    }
	    
	    file2.delete();
	}
    }
    
    public static String tempFile() {
	String property = "java.io.tmpdir";
	// 获取临时目录并打印。
	String tempDir = System.getProperty(property);
	return tempDir;
    }
    
    
    
    public static void unzip(final String ouputfile, final String source)
    {
	File zf = new File(ouputfile);
	if(!zf.exists()) {
	    zf.mkdirs();
	    zf.mkdir();
	}
	unzipFile(ouputfile,new File(source));
    }
    
    private static void unzipFile(final String ouputfile, final File zf)
    {
        File file = null;
        try
        {
            ZipFile zipFile = new ZipFile(zf.toString());
            Enumeration<?> entries = zipFile.entries();
            while (entries.hasMoreElements())
            {
                ZipEntry entry = (ZipEntry)entries.nextElement();

                String filename = entry.getName();

                //目录，产生后返回。
                if (entry.isDirectory())
                {
                    file = new File(ouputfile + File.separator +filename);
                    file.mkdirs();
                    continue;
                }
                else if (filename.indexOf('/') >= 0)
                {
                    String subdir = filename.substring(0, filename.lastIndexOf('/'));
                    file = new File(ouputfile + File.separator +subdir);
                    file.mkdirs();
                }
                file = new File(ouputfile + File.separator +filename);
                file.createNewFile();

                InputStream      is  = zipFile.getInputStream(entry);
                FileOutputStream fos = new FileOutputStream(file);
                int count = 0;
                byte buf[] = new byte[4096];
                while ((count = is.read(buf)) > 0)
                { 
                    fos.write(buf, 0, count);
                }
                fos.close();
                is.close();
            }
            zipFile.close();
        }
        catch (Exception e)
        {
            System.out.println(ouputfile+", "+zf+", "+file);
            e.printStackTrace();
        }
    }
    
    public static String getFileContent(Map<String, Object> dataMap,String fileId) {
	Long signId = longValue(dataMap,fileId);
	 Map<String, Object> one = RuderApi.getOne(signId);
//	     singOne= "http://localhost:9600/cd/file/download/"+signId;
	String singOne= FileOpt.readFileContent(string(one,"fileStoreName"));
	return singOne;
    }
    public static String getFile(Map<String, Object> dataMap,String fileId) {
	Long signId = longValue(dataMap,fileId);
	 Map<String, Object> one = RuderApi.getOne(signId);
	 dataMap.put(fileId+"Name", name(one));
//	     singOne= "http://localhost:9600/cd/file/download/"+signId;
	return string(one,"fileStoreName");
    }
    
}

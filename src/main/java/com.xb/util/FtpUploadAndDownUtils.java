package com.xb.util;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;
import sun.net.ftp.FtpClient;
import sun.net.ftp.FtpReplyCode;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Properties;

/**
 * ftp上传/下载工具类
 * @author zhuwc
 *
 */
public   class  FtpUploadAndDownUtils {
	static Logger  logger = Logger.getLogger(FtpUploadAndDownUtils.class);
//	 private static Logger logger=Logger.getLogger(FtpUploadAndDownUtils.class);
	/** 
	 * 服务器用户名
	 */
	private static String ftpUser;
	/**
	 * 服务器密码
	 */
	private static String ftpPwd;
	/**
	 * 服务器端口
	 */
	private static String ftpPort;
	/**
	 * 服务器地址
	 */
	private static String ftpServiceIp;
	/**
	 * 服务器路径
	 */
	private static String ftpPath;
	/**
	 * 本地存放文件目录
	 */
	private static String ftpHostPath;
	/**
	 * 签名证书路径
	 */
	private static String signCertPath;
	/**
	 * 初始化配置文件
	 */
     private static FtpClient ftp;
     boolean _isLogin = false;
     static {
 		Properties properties = new Properties();
 		InputStream in = null;
 		try {
 			in = FtpUploadAndDownUtils.class.getClassLoader().getResourceAsStream("ftp.properties");
 			properties.load(in);
 			ftpUser = properties.getProperty("ftpUser");
 			ftpPwd = properties.getProperty("ftpPwd");
 			ftpPort = properties.getProperty("ftpPort");
 			ftpServiceIp = properties.getProperty("ftpServiceIp");
 			ftpPath = properties.getProperty("ftpPath");
 			ftpHostPath = properties.getProperty("ftpHostPath");
 			signCertPath = properties.getProperty("signCertPath");
 		} catch (IOException e) {
 			e.printStackTrace();
 			logger.error("读取文件失败");
 		}
 	}
     /**
      * 获取ftp连接
      * @param f
      * @return
      * @throws Exception
      */
     
     
     public static boolean connectFtp() throws Exception{
    		FtpClient ftp =FtpClient.create();
         boolean flag=false;
         int reply;
        	 SocketAddress addr=new InetSocketAddress(ftpServiceIp,2121); 
        	 ftp.connect(addr);  
         ftp.login(ftpUser,ftpPwd.toCharArray());
         
         System.out.println(ftp.isLoggedIn());
         System.out.println(ftp.getLastReplyCode());
         ftp.setBinaryType();
        FtpReplyCode lastReplyCode = ftp.getLastReplyCode();    
        System.out.println(11);
         flag = true;      
         return flag;
     }
     
     /**
      * 关闭ftp连接
      */
     public static void closeFtp(){
         if (ftp!=null && ftp.isConnected()) {
             try {
                 ftp.close();
//                 ftp.
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
     }
     
     /**  
      * Description: 向FTP服务器上传文件  
      * @param basePath FTP服务器基础目录 
      * @param filePath FTP服务器文件存放路径。例如分日期存放：/2015/01/01。文件的路径为basePath+filePath 
      * @param filename 上传到FTP服务器上的文件名  
      * @param input 输入流  
      * @return 成功返回true，否则返回false  
      */    
     public static boolean uploadFile( String basePath,  
             String filePath, String filename, InputStream input) {  
         boolean result = false;  
         FTPClient ftp = new FTPClient();  
         try {  
             int reply;  
             ftp.connect(ftpServiceIp, 2121);// 连接FTP服务器  
             // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器  
             ftp.login(ftpUser, ftpPwd);// 登录  
             reply = ftp.getReplyCode();  
             if (!FTPReply.isPositiveCompletion(reply)) {  
                 ftp.disconnect();  
                 return result;  
             }  
             //切换到上传目录  
             if (!ftp.changeWorkingDirectory(basePath+filePath)) {  
                 //如果目录不存在创建目录  
                 String[] dirs = filePath.split("/");  
                 String tempPath = basePath;  
                 for (String dir : dirs) {  
                     if (null == dir || "".equals(dir)) continue;  
                     tempPath += "/" + dir;  
                     if (!ftp.changeWorkingDirectory(tempPath)) {  
                         if (!ftp.makeDirectory(tempPath)) {  
                             return result;  
                         } else {  
                             ftp.changeWorkingDirectory(tempPath);  
                         }  
                     }  
                 }  
             }  
             //设置上传文件的类型为二进制类型  
             ftp.setFileType(FTP.BINARY_FILE_TYPE);  
             //上传文件  
             if (!ftp.storeFile(filename, input)) {  
                 return result;  
             }  
             input.close();  
             ftp.logout();  
             result = true;  
         } catch (IOException e) {  
             e.printStackTrace();  
         } finally {  
             if (ftp.isConnected()) {  
                 try {  
                     ftp.disconnect();  
                 } catch (IOException ioe) {  
                 }  
             }  
         }  
         return result;  
     }  
   
     /**  
      * Description: 从FTP服务器下载文件  
      * @param host FTP服务器hostname  
      * @param port FTP服务器端口  
      * @param username FTP登录账号  
      * @param password FTP登录密码  
      * @param remotePath FTP服务器上的相对路径  
      * @param fileName 要下载的文件名  
      * @param localPath 下载后保存到本地的路径  
      * @return  
      */    
     public static boolean downloadFile( String remotePath,  
             String fileName, String localPath) {  
         boolean result = false;  
         FTPClient ftp = new FTPClient();  
         try {  
             int reply;  
             ftp.login(ftpUser, ftpPwd);// 登录  
             // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器  
             ftp.login(ftpUser, ftpPwd);// 登录  
             reply = ftp.getReplyCode();  
             if (!FTPReply.isPositiveCompletion(reply)) {  
                 ftp.disconnect();  
                 return result;  
             }  
             ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录  
             FTPFile[] fs = ftp.listFiles();  
             for (FTPFile ff : fs) {  
                 if (ff.getName().equals(fileName)) {  
                     File localFile = new File(localPath + "/" + ff.getName());  
   
                     OutputStream is = new FileOutputStream(localFile);  
                     ftp.retrieveFile(ff.getName(), is);  
                     is.close();  
                 }  
             }  
   
             ftp.logout();  
             result = true;  
         } catch (IOException e) {  
             e.printStackTrace();  
         } finally {  
             if (ftp.isConnected()) {  
                 try {  
                     ftp.disconnect();  
                 } catch (IOException ioe) {  
                 }  
             }  
         }  
         return result;  
     }  
	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		FtpUploadAndDownUtils.logger = logger;
	}

	public static String getFtpUser() {
		return ftpUser;
	}

	public static void setFtpUser(String ftpUser) {
		FtpUploadAndDownUtils.ftpUser = ftpUser;
	}

	public static String getFtpPwd() {
		return ftpPwd;
	}

	public static void setFtpPwd(String ftpPwd) {
		FtpUploadAndDownUtils.ftpPwd = ftpPwd;
	}

	public static String getFtpPort() {
		return ftpPort;
	}

	public static void setFtpPort(String ftpPort) {
		FtpUploadAndDownUtils.ftpPort = ftpPort;
	}

	public static String getFtpServiceIp() {
		return ftpServiceIp;
	}

	public static void setFtpServiceIp(String ftpServiceIp) {
		FtpUploadAndDownUtils.ftpServiceIp = ftpServiceIp;
	}

	public static String getFtpPath() {
		return ftpPath;
	}

	public static void setFtpPath(String ftpPath) {
		FtpUploadAndDownUtils.ftpPath = ftpPath;
	}

	public static String getFtpHostPath() {
		return ftpHostPath;
	}

	public static void setFtpHostPath(String ftpHostPath) {
		FtpUploadAndDownUtils.ftpHostPath = ftpHostPath;
	}

	public static String getSignCertPath() {
		return signCertPath;
	}

	public static void setSignCertPath(String signCertPath) {
		FtpUploadAndDownUtils.signCertPath = signCertPath;
	}

	public static FtpClient getFtp() {
		return ftp;
	}

	public static void setFtp(FtpClient ftp) {
		FtpUploadAndDownUtils.ftp = ftp;
	} 
     
     
 }

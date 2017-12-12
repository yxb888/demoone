package com.xb.service.dict.impl;

import com.xb.dao.dict.CestDao;
import com.xb.domain.Paramerta;
import com.xb.domain.Picture;
import com.xb.domain.User;
import com.xb.service.dict.DestService;
import com.xb.service.dict.PictureService;
import com.xb.util.FtpUploadAndDownUtils;
import com.xb.util.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DestServiceImpl implements DestService {

	@Autowired
	private CestDao cestDao;
	@Autowired
	private PictureService pictureService;
	/* (non-Javadoc)    
	 * @see com.xb.service.dict.DestService#selectByPrimaryKey()    
	 */
	@Override
	public List<Paramerta> selectByPrimaryKey() {
		// TODO Auto-generated method stub
		 List<Paramerta> aa = cestDao.selectByPrimaryKey();
		 System.err.println("22");
		return aa;
	}
	/* (non-Javadoc)    
	 * @see com.xb.service.dict.DestService#updateByPrimaryKeySelective(com.xb.domain.Paramert)    
	 */
	@Override
	public void updateByPrimaryKeySelective(Paramerta paramert) {
		// TODO Auto-generated method stub
		cestDao.updateByPrimaryKeySelective(paramert);
	}
	/* (non-Javadoc)    
	 * @see com.xb.service.dict.DestService#updateByPrimaryKeySelectivea(com.xb.domain.Paramerta)    
	 */
	@Override
	public void updateByPrimaryKeySelectivea(Paramerta paramert) {
		// TODO Auto-generated method stub
		cestDao.updateByPrimaryKeySelectivea();
	}
	/* (non-Javadoc)    
	 * @see com.xb.service.dict.DestService#uploadPicture(org.springframework.web.multipart.MultipartFile)    
	 */
	@Override
	public Map uploadPicture(MultipartFile fileName,HttpServletRequest request) {
		// TODO Auto-generated method stub
		Picture p=new Picture();
		String userName = ((User) request.getSession().getAttribute("userInfo")).getUsername();
		 Map resultmMap = new HashMap<>();  
		 try {  
	            // 生成一个文件名  
	            // 获取旧的名字  
	            String oldName = fileName.getOriginalFilename();  
	            String newName = IDUtils.genImageName();
	            //新名字  
	            newName = newName + oldName.substring(oldName.lastIndexOf("."));  
	           
	            //上传的路径  
	            Date date = new Date();
	            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            String format = simpleDateFormat.format(date);
	            String imagePath = format.toString();  
	           
	            
	            //端口号  
	            int port = Integer.parseInt("2121");  
//	            System.out.println(FTP_BASEPATH);  
	            //调用方法，上传文件  
	            boolean result = FtpUploadAndDownUtils.uploadFile( "/ssm-image", imagePath,  
	                    newName, fileName.getInputStream());
	            //判断是否上传成功  
	            if (!result) {  
	                resultmMap.put("error", 1);  
	                resultmMap.put("message", "上传失败");  
	                return resultmMap;  
	            }  
	            resultmMap.put("error", 0);  
	            resultmMap.put("url", "ftp://192.168.31.213:2121/ssm-image/" + imagePath+"/" + newName);  
	            String originalFilename = fileName.getOriginalFilename();
	            p.setpName(originalFilename);
				p.setpUrl( "ftp://192.168.31.213:2121/ssm-image/" + imagePath+"/" + newName);
				p.setpLastname(userName);
				p.setpOldname(newName);
				pictureService.insertSelective(p);
	            return resultmMap;  
	  
	        } catch (IOException e) {  
	            resultmMap.put("error", 1);  
	            resultmMap.put("message", "上传发生异常");  
	            return resultmMap;  
	        }  
	    }
	/* (non-Javadoc)    
	 * @see com.xb.service.dict.DestService#getHeicharts()    
	 */
	@Override
	public List<Map<String, Object>> getHeicharts() {
		// TODO Auto-generated method stub
		return cestDao.getHeicharts();
	}
	/* (non-Javadoc)    
	 * @see com.xb.service.dict.DestService#getHeichartsA()    
	 */
	@Override
	public List<Map<String, Object>> getHeichartsA() {
		// TODO Auto-generated method stub
		return cestDao.getHeichartsA();
	}  

	
}

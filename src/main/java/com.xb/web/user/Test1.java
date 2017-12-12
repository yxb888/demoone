/** 
 * <pre>项目名称:ssm-oa 
 * 文件名称:Test1.java 
 * 包名:com.xy 
 * 创建日期:2017年11月24日下午2:59:04 
 * Copyright (c) 2017, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.xb.web.user;

import org.springframework.stereotype.Component;

/** 
 * <pre>项目名称：ssm-oa    
 * 类名称：Test1    
 * 类描述：    
 * 创建人：杨兴北  
 * 创建时间：2017年11月24日 下午2:59:04    
 * 修改人：杨兴北  
 * 修改时间：2017年11月24日 下午2:59:04    
 * 修改备注：       
 * @version </pre>    
 */
@Component 
public class Test1 {

	/** <pre>main(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月24日 下午2:59:04    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月24日 下午2:59:04    
	 * 修改备注： 
	 * @param args</pre>    
	 */
//	 @Scheduled(cron="0/5 * * * * ? ") //间隔5秒执行 
	public static void main() {
		// TODO Auto-generated method stub
		 System.out.println("niubiniubi");
		 try {
//			GeetestConfig.sendMail("215860059@qq.com", "梁飞");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

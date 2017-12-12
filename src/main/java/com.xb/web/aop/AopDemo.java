package com.xb.web.aop;

import com.xb.domain.LogPojo;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AopDemo implements MethodBeforeAdvice,AfterReturningAdvice{
	@Autowired
	private MongoTemplate mongoTemplate;
	@Override
	public void afterReturning(Object returnval, Method method, Object[] params, Object implurl) throws Throwable {
		// TODO Auto-generated method stub
		LogPojo logobj = new LogPojo();
		if(returnval!=null&&!returnval.equals("")){
			logobj.setReturnval(returnval.toString());
		}
		logobj.setMethod(method.getName().toString());
		String paramStr = "";
		for (int i = 0; i < params.length; i++) {
			paramStr += params[i].toString()+",";
		}
		logobj.setParamVal(paramStr);
		logobj.setImplUrl(implurl.toString());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		logobj.setCztime(sdf.format(new Date()));
		mongoTemplate.insert(logobj);
		System.out.println("111111111111111111111111111111111111111111111111111111111111111");
	}

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		// TODO Auto-generated method stub
		
	}
//	
//	@AfterThrowing
//	public String AfterThrowing(){
//		
//		return "";
//	}

}

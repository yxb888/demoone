package com.xb.web.frenshi;

import com.xb.domain.Rygwjbxx;
import com.xb.service.frenshi.RygwjbxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Controller
@RequestMapping("RygwjbxxController")
public class RygwjbxxController {
	
	@Autowired
	private RygwjbxxService rygwjbxxService;
	
	//分页查询
	@RequestMapping("queryRygwjbxx")
	@ResponseBody
	public Object queryRygwjbxx(int page,int rows,Rygwjbxx rygwjbxx){
		System.out.println(rygwjbxx.getRyName()+"0000000000000000000000000000");
		Map<String, Object> map = rygwjbxxService.queryRygwjbxx(page,rows,rygwjbxx);
	
		System.out.println(map);
		return map;
	}
	
	//批量删除
	@RequestMapping("deleteRygwjbxx")
	@ResponseBody
	public void deleteRygwjbxx(String ryId,HttpServletRequest request,HttpServletResponse response){
		//前台传来的是字符串，咱们改成数组
		String[] id = ryId.split(",");
		System.out.println(id);
		
		rygwjbxxService.deleteRygwjbxx(id);
	}
	//获取被修改的对象
	@RequestMapping("toUpdateRsgw")
	public String queryUpdateRsgw(String ryId,HttpServletRequest request){
		Rygwjbxx rygwjbxx = rygwjbxxService.queryUpdateRsgw(ryId);
		request.setAttribute("rygwjbxx", rygwjbxx);
		return "/frenshi/updateRsgw";
	}
	
	@RequestMapping("updateRsgw")
	public void updateRsgw(Rygwjbxx rygwjbxx){
		rygwjbxxService.updateRsgw(rygwjbxx);
	}

}

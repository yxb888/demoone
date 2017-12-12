package com.xb.web.treea;

import com.xb.domain.treea.Treea;
import com.xb.service.treea.TreeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/treea")
public class TreeaController {

	@Autowired
	private TreeaService treeaservice;

	// 跳转同步
	@RequestMapping("totree")
	public String toDQ() {
		return "liangfei/totreea";
	}

	// 跳转异步
	@RequestMapping("totree2")
	public String toDQ2() {
		return "liangfei/totreea2";
	}
	// 跳转index
		@RequestMapping("totree3")
		public String toDQ3() {
			return "liangfei/index";
		}

	// 查询1
	@RequestMapping("queryTreea")
	@ResponseBody
	public List<Treea> queryTreea(Treea treea) {
		List<Treea> list = new ArrayList<Treea>();
		try {
			list = treeaservice.queryTreea(treea);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// 查询2
	@RequestMapping("queryTreea2")
	@ResponseBody
	public List<Treea> queryTreea2(Treea treea) {
		List<Treea> list = new ArrayList<Treea>();
		try {
			list = treeaservice.queryTreea2(treea);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	

}

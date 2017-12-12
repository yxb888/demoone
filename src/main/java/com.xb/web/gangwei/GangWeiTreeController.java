package com.xb.web.gangwei;

import com.xb.service.gangwei.GangWeiTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("gwtree")
public class GangWeiTreeController {
	@Autowired
	private GangWeiTreeService gangWeiTreeService;
	

}

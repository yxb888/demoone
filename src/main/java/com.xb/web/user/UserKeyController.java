package com.xb.web.user;

import com.xb.domain.UserKey;
import com.xb.service.user.UserKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("userkeycontroller")
public class UserKeyController {

	@Autowired
	private UserKeyService userKeyService;
	
	@RequestMapping("queryType")
	@ResponseBody
	public List<UserKey> queryUserKey(){
		List<UserKey> lists=userKeyService.queryUserKey();
		return lists;
	}
}

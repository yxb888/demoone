package com.xb.web.user;

import com.xb.domain.User;
import com.xb.service.user.UserService;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.net.ftp.FtpClient;
import sun.net.ftp.FtpProtocolException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;


/**
 * 用户控制器
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	protected HttpSession s ;
	@Autowired
    private UserService userService;
	@Autowired
	private RedisTemplate redisTemplate;
    @RequestMapping("/view")
    public String view() {
        return "main/login";
    }
    @RequestMapping("/toUserPage")
    public String toUserPage() {
        return "usermain";
    }
    @RequestMapping("/index")
    public void indexs(HttpServletRequest req,HttpServletResponse res) {
    	
    	s.setAttribute("username", null);
    	
    }
    /**
     * <pre>进入用户管理
     * 创建人：杨兴北   
     * 创建时间：2017年11月28日 下午7:20:56    
     * 修改人：杨兴北 
     * 修改时间：2017年11月28日 下午7:20:56    
     * 修改备注： 
     * @return</pre>
     */

    
    @RequestMapping("/indexview")
    public String index() {
        return "main/index";
    }
//	跳转到注册页面
	@RequestMapping("addLoginUser")
	public String addLoginUser(){
		return "user/addUser";
	}
	
//	新增用户
	@RequestMapping("addUser")
	@ResponseBody
	public Object addUser(User user){
		userService.addUser(user);
		return "1";
	}
    
	

//    登录
    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest req, HttpServletResponse res, User user, HttpSession session, Model model) {
    	String parameter = req.getParameter("username");
    	 User users = userService.findByUsername(parameter);
    	 req.getSession().setAttribute("userInfo", users);
    	String LoginFalg = userService.updateLoginUser(user, session);
		model.addAttribute("LoginFalg", LoginFalg);
	
//		String parameter2 = req.getParameter("userpwd");
//       
//        if (user == null || !user.getUserpwd().equals(parameter2)) {
//        	res.setCharacterEncoding("utf-8");
//        	res.setContentType("html/text;chartset=utf-8");
//			PrintWriter writer;
//			try {
//				writer = res.getWriter();
//				writer.write("失败，账号或密码错误！");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//        } else {
//        	res.setCharacterEncoding("utf-8");
//        	res.setContentType("html/text;chartset=utf-8");
//        	req.getSession().setAttribute("userInfo", user);
//			PrintWriter writer;
//			try {
//				writer = res.getWriter();
//				writer.write("ok");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//        	
//        }
		return LoginFalg;
    }
    
    
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ModelAndView login(User model, HttpSession session) {
//        User user = userDao.findByUsername(model.getUsername());
//
//        if (user == null || !user.getUserpwd().equals(model.getUserpwd())) {
//            return new ModelAndView("redirect:/login.jsp");
//        } else {
//            session.setAttribute("user", user);
//            ModelAndView mav = new ModelAndView();
//            mav.setViewName("index");
//            return mav;
//        }
//    }
    
    
    @RequestMapping("tiao")
    public String tiao(){
    	return "chaxun";
    }
    @RequestMapping("queryUser")
	@ResponseBody
	public Object queryUser(int page,int rows){
		Map<String, Object> map = userService.queryUser(page,rows);
		return map;
	}
    //修改
    
    @RequestMapping("updateUser")
	public String updateUser(int userid){
    	User u=userService.findByUserid(userid);
    	System.out.println(u);
//		Map<String, Object> map = userService.queryUser(page,rows);
		return "";
	}
    
    @RequestMapping("sendEmailMethod")
    @ResponseBody
    public Map sendEmailMethod(HttpServletRequest request) throws Exception{
    	String parameter = request.getParameter("namelast");
    	Map result=userService.sendEmailMethod(parameter);
    	
    	return result;
    }
    
    @RequestMapping("updatePasswordMethod")
    @ResponseBody
    public Map updatePasswordMethod(User user, HttpServletRequest request) throws Exception{
    	Map result=	userService.updatePasswordMethod(user);
    	return result;
//    	System.out.println(u);
//		Map<String, Object> map = userService.queryUser(page,rows);
    }
    @RequestMapping("test")
    public  void test() throws IOException{
    List<User> u=	userService.queryUsers();
    Document document = DocumentHelper.createDocument();
    Element root = document.addElement("中国");
   Element elm = root.addElement("朝代"); 
   elm.setText("唐朝");
   elm.setText("宋朝");
   Element user = root.addElement("user");
   user.setText(u.get(0).getUserid());
   
   OutputFormat format = OutputFormat.createPrettyPrint();// 创建文件输出的时候，自动缩进的格式                    
   format.setEncoding("UTF-8");//设置编码  
   XMLWriter writer = new XMLWriter(new FileWriter("D:\\output.xml"),format);  
   writer.write(document);  
   writer.close();
   
    	
    }
    public static  void main(String[] args) throws FtpProtocolException, IOException {
    	try {
//    		test();
//			FtpUploadAndDownUtils.connectFtp("192.168.31.213", "ftp", "1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
//		FtpClient ftp =FtpClient.create();
//		int reply;
//		SocketAddress addr=new InetSocketAddress("192.168.31.213",2121);  
//		//连接      
//		ftp=FtpClient.create();  
//		ftp.connect(addr);  
//		//或者FtpClient ftp = FtpClient.create(ip);  
//		//登陆      
//		ftp.login("ftp","123456".toCharArray());  
//		ftp.setBinaryType();  
//		 ftp.changeDirectory("image");
//		System.out.println(ftp.getWelcomeMsg());  
    }
    private static FtpClient ftp;
        public static void upload(File f) throws Exception{
    	         if (f.isDirectory()) {
    	             ftp.makeDirectory(f.getName());
    	             ftp.changeDirectory(f.getName());
    	             String[] files=f.list();
    	             for(String fstr : files){
    	                 File file1=new File(f.getPath()+"/"+fstr);
    	                 if (file1.isDirectory()) {
    	                     upload(file1);
    	                     ftp.changeToParentDirectory();
    	                 }else{
    	                     File file2=new File(f.getPath()+"/"+fstr);
    	                     FileInputStream input=new FileInputStream(file2);
    	                     ftp.putFile(file2.getName(), input);
    	                     input.close();
    	                 }
    	             }
    	         }else{
    	             File file2=new File(f.getPath());
    	             FileInputStream input=new FileInputStream(file2);
    	             ftp.putFile(file2.getName(), input);
    	             input.close();
    	         }
    	     }
    	@RequestMapping("updateUserLock")
    	@ResponseBody
    	public String  updateUserLock(User user, Model model){
    		 userService.updateUserLock(user);
    		 return "1";
    	}

}



package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import po.Article;
import po.User;
import po.categoty;
import po.date_art;
import po.tint;
import service.ArticleService;
import service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userserve;
	
	@Autowired
	ArticleService articleService;
	
	
	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	public String tomain(Model model,HttpServletRequest request,HttpSession session) throws IOException {
		User user=(User)session.getAttribute("user");
		List<categoty> list_c=articleService.find_categorys();
		model.addAttribute("list_cate", list_c);
		if(user==null)
		{
			model.addAttribute("LOG_IN","LOG IN");
			model.addAttribute("IMAGE","/page2/images/logo.jpg");//头像位置
			model.addAttribute("MASTER", "none");
			//${pageContext.request.contextPath}
			model.addAttribute("MOTTO","There is no royal road to learning");
		}
		else
		{
			if(user.getValue()==1)
				model.addAttribute("MASTER", "inline");
			else
				model.addAttribute("MASTER", "none");
			model.addAttribute("LOG_IN",user.getName());
			model.addAttribute("IMAGE",user.getPhoto());//头像位置
			model.addAttribute("MOTTO",user.getMotto());
		}
		String page=(String)session.getAttribute("page");
		if(page==null)
		{
			Integer l=0;
			page=l.toString();
			session.setAttribute("page", page);
		}
		if(page==null)
		{
			page="0";
		}
		if(Integer.valueOf(page)<0)
		{
			page="0";
		}
		List<Article> list=articleService.findart_1(new tint(Integer.valueOf(page)*3,Integer.valueOf(page)*3+12));
		while(list.size()==0&&!page.equals("0"))
		{
			page=((Integer)(Integer.valueOf(page)-1)).toString();
			list=articleService.findart_1(new tint(Integer.valueOf(page)*3,Integer.valueOf(page)*3+12));
		}
		session.setAttribute("page", page);
		int len=list.size();
		List<Article> list_1=new ArrayList<Article>();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0;i<len&&i<3;i++)
		{
			list.get(i).setTti(formatter.format(new Date(list.get(i).getTime().getTime())));
			/*
			String path=request.getServletContext().getRealPath(list.get(i).getContent()); 
			BufferedReader bw = new BufferedReader(new FileReader(path));
			String txt;
			while((txt=bw.readLine())!=null) {
				if(list.get(i).getTxt()!=null)
					list.get(i).setTxt(list.get(i).getTxt()+txt+'\n');
				else
					list.get(i).setTxt(txt+'\n');
				
			}
			*/
			list_1.add(list.get(i));
		}
		model.addAttribute("LIST_1", list_1);
		
		
		List<Article> list_2=new ArrayList<Article>();
		for(int i=3;i<len&&i<7;i++)
		{
			list.get(i).setTti(formatter.format(new Date(list.get(i).getTime().getTime())));
			/*
			String path=request.getServletContext().getRealPath(list.get(i).getContent()); 
			BufferedReader bw = new BufferedReader(new FileReader(path));
			String txt;
			while((txt=bw.readLine())!=null) {
				if(list.get(i).getTxt()!=null)
					list.get(i).setTxt(list.get(i).getTxt()+txt+'\n');
				else
					list.get(i).setTxt(txt+'\n');
				
			}
			*/
			list_2.add(list.get(i));
		}
		model.addAttribute("LIST_2", list_2);
		
		
		List<Article> list_3=new ArrayList<Article>();
		for(int i=7;i<len&&i<12;i++)
		{
			list.get(i).setTti(formatter.format(new Date(list.get(i).getTime().getTime())));
			/*
			String path=request.getServletContext().getRealPath(list.get(i).getContent()); 
			BufferedReader bw = new BufferedReader(new FileReader(path));
			String txt;
			while((txt=bw.readLine())!=null) {
				if(list.get(i).getTxt()!=null)
					list.get(i).setTxt(list.get(i).getTxt()+txt+'\n');
				else
					list.get(i).setTxt(txt+'\n');
				
			}
			*/
			list_3.add(list.get(i));
		}
		model.addAttribute("LIST_3", list_3);
		
		check_root(model, session, request);
    	return "main";
    }
	
	
	@RequestMapping(value = "/user/login.action", method = RequestMethod.POST)
	public String login(Model model,HttpSession session,HttpServletRequest request,User user) throws IOException {
		User us=userserve.getUser(user);
		if(us!=null){
			session.setAttribute("user", us);
			model.addAttribute("user", us);
			if(us.getValue()==1)
				model.addAttribute("MASTER", "inline");
			else
				model.addAttribute("MASTER", "none");
			model.addAttribute("LOG_IN",us.getName());
			model.addAttribute("IMAGE",us.getPhoto());//头像位置
			model.addAttribute("MOTTO",us.getMotto());
			return tomain(model,request,session);		
		}
		else
		{
			model.addAttribute("LOGIN_MESS", "The account or password is incorrect!");
			return "LogIn";
		}
	}
	
	public Boolean check(User user) {
		User u=userserve.findUser(user);
		if(u==null)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	

	@RequestMapping(value = "/user/signup.action", method = RequestMethod.POST)
    public String tosignin_user(User user,@RequestParam("photo2") MultipartFile photo2,Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
				// 获取上传文件的原始名称
				String originalFilename = photo2.getOriginalFilename();
				String flase_path="/page2/images/logo.jpg";
				if(!check(user))
				{
					model.addAttribute("SIGN", "The account already exists!");
					return "signup";
				}
				if(!originalFilename.equals("")){
					// 设置上传文件的保存地址目录
					flase_path="/images/";
					String dirPath = 
                       request.getServletContext().getRealPath(flase_path);
					File filePath = new File(dirPath);
					System.out.println("=========dirPath="+dirPath);
					// 如果保存文件的地址不存在，就先创建目录
					if (!filePath.exists()) {
						System.out.println("==========");
						filePath.mkdirs();
					}
					// 使用UUID（通用唯一标识）重新命名上传的文件名称(上传人_uuid_原始文件名称)
					String newFilename = user.getId()+ "_"+UUID.randomUUID() + 
                                                   "_"+originalFilename;
					flase_path+=newFilename;
					try {
						// 使用MultipartFile接口的方法完成文件上传到指定位置
						photo2.transferTo(new File(dirPath + newFilename));
					} catch (Exception e) {
						e.printStackTrace();
						return "error";
					}
				}
				if(user.getMotto().equals(""))
				{
					user.setMotto("There is no royal road to learning");
				}
				if(user.getName().equals(""))
				{
					user.setName("Happy Fish");
				}
				user.setPhoto(flase_path);
				// 跳转到成功页面
				user.setValue(30);
				userserve.addUser(user);
				model.addAttribute("LOG_IN","LOG IN");
				model.addAttribute("IMAGE","/page2/images/logo.jpg");//头像位置
				//${pageContext.request.contextPath}
				model.addAttribute("MOTTO","There is no royal road to learning");
				
				
				
				return tomain(model,request,session);
    }
	
	
	@RequestMapping(value = "/master/change.action", method = RequestMethod.POST)
	public String change(Model model,HttpSession session,User user) {
		userserve.setUser(user);
		List<User> list=userserve.getUsers();
		model.addAttribute("user_list", list);
		
		return "master/accounts";
	}
	
	@RequestMapping(value = "/master/change_cate.action", method = RequestMethod.POST)
	public String change_cate(Model model,HttpSession session,categoty categoty2) {
		
		articleService.set_category(categoty2);
		
		return categoty(model, session);
	}
	
	
	@RequestMapping(value = "/master/delete.action", method = RequestMethod.GET)
	public String delete(Model model,HttpSession session,HttpServletRequest request,String id) {
		User us=new User();
		us.setId(id);
		User user=userserve.findUser(us);
		if(user==null)
		{
			List<User> list=userserve.getUsers();
			model.addAttribute("user_list", list);
			return "master/accounts";
		}
		String path=request.getServletContext().getRealPath(user.getPhoto()); 
		System.out.println(path);
		File file = new File(path);
		file.delete();
		userserve.delUser(id);
		List<categoty> list_c=articleService.find_categorys();
		model.addAttribute("list_cate", list_c);
		List<User> list=userserve.getUsers();
		model.addAttribute("user_list", list);
		return "master/accounts";
	}
	
	@RequestMapping(value = "/master/savetext.action", method = RequestMethod.POST)
	public String savetext(Model model,Article article,@RequestParam("photo2") MultipartFile photo2,String text,HttpSession session,HttpServletRequest request) throws IOException {
		
		User user=(User)session.getAttribute("user");
		if(user==null)
		{
			model.addAttribute("LOG_IN","LOG IN");
			model.addAttribute("IMAGE","/page2/images/logo.jpg");//头像位置
			model.addAttribute("MASTER", "none");
			//${pageContext.request.contextPath}
			model.addAttribute("MOTTO","There is no royal road to learning");
			return tomain(model,request,session);
		}
		
		Integer orderId=UUID.randomUUID().toString().hashCode();
		orderId = orderId < 0 ? -orderId : orderId;
		article.setId(orderId.toString());
		
		
		String false_path="/texts/";
		String dirPath_t = 
	               request.getServletContext().getRealPath(false_path);
		System.out.println("=========dirPath_t="+dirPath_t);
		File filePath_t = new File(dirPath_t);
		if (!filePath_t.exists()) {
			System.out.println("==========");
			filePath_t.mkdirs();
		}
		String newFilename_t = article.getId() + ".txt";
		false_path+=newFilename_t;
		BufferedWriter bw = new BufferedWriter(new FileWriter(dirPath_t+newFilename_t));
		bw.write(text);
		bw.close();
		article.setContent(false_path);
		
		
		
		String originalFilename = photo2.getOriginalFilename();
		String flase_path="/page2/images/logo.jpg";
		if(!originalFilename.equals("")){
			// 设置上传文件的保存地址目录
			flase_path="/texts/images/";
			String dirPath = 
               request.getServletContext().getRealPath(flase_path);
			File filePath = new File(dirPath);
			System.out.println("=========dirPath="+dirPath);
			// 如果保存文件的地址不存在，就先创建目录
			if (!filePath.exists()) {
				System.out.println("==========");
				filePath.mkdirs();
			}
			// 使用UUID（通用唯一标识）重新命名上传的文件名称(上传人_uuid_原始文件名称)
			String newFilename = article.getId() + 
                                           "_"+originalFilename;
			flase_path+=newFilename;
			try {
				// 使用MultipartFile接口的方法完成文件上传到指定位置
				photo2.transferTo(new File(dirPath + newFilename));
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		}
		
		
		article.setPhoto(flase_path);
	
		
		System.out.println(article.getContent());
		System.out.println(article.getPhoto());
		if(user.getValue()==1)
			model.addAttribute("MASTER", "inline");
		else
			model.addAttribute("MASTER", "none");
		model.addAttribute("LOG_IN",user.getName());
		model.addAttribute("IMAGE",user.getPhoto());//头像位置
		model.addAttribute("MOTTO",user.getMotto());
		article.setUser_id(user.getId());	
		article.setRead_t(0);
		Date date = new Date();
		Timestamp t = new Timestamp(date.getTime());
		article.setTime(t);
		
		articleService.addUser(article);
		return tomain(model,request,session);
	}
	
	
	
	
	
	
	@RequestMapping(value = "/read.action", method = RequestMethod.GET)
	public String read(String id,Model model,HttpSession session,HttpServletRequest request) throws IOException{
		Article article=articleService.findart(id);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		article.setTti(formatter.format(new Date(article.getTime().getTime())));
		String path=request.getServletContext().getRealPath(article.getContent()); 
		BufferedReader bw = new BufferedReader(new FileReader(path));
		String txt;
		int i=0;
		List<categoty> list_c=articleService.find_categorys();
		model.addAttribute("list_cate", list_c);
		while((txt=bw.readLine())!=null) {
			/*
			int j=0;
			for(int k=0;k<txt.length();k++)
			{
				if((txt.charAt(k)>='a'&&txt.charAt(k)<='z')||(txt.charAt(k)>='A'&&txt.charAt(k)<='Z')||(txt.charAt(k)>='0'&&txt.charAt(k)<='9'))
				{
					j++;
				}
			}
			int t=(txt.length()-j)+(j+1/2);
			*/
			i+=(txt.length()+59)/60;
			//System.out.println(txt+" "+i+txt.length());
			if(txt.equals(""))
			{
				i++;
			}
			if(article.getTxt()!=null)
				article.setTxt(article.getTxt()+'\n'+txt);
			else
				article.setTxt(txt);
		}
		model.addAttribute("this_mess",article);
		//System.out.println(i);
		model.addAttribute("HIGHT",i*42);
		
		check_root(model, session, request);
		
		return "read";
	}
	
	
	@RequestMapping(value = "/reads.action", method = RequestMethod.GET)
	public String reads(String id,Model model,HttpSession session,HttpServletRequest request) throws IOException, ClassNotFoundException{
		Article article1=articleService.findart(id);
		
		List<categoty> list_c=articleService.find_categorys();
		model.addAttribute("list_cate", list_c);
		
		String path=request.getServletContext().getRealPath(article1.getContent());
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        Article article = (Article) ois.readObject();
        ois.close();
		article.setPhoto_u(article1.getPhoto_u());
		article.setName(article1.getName());
        /*
        BufferedReader bw = new BufferedReader(new FileReader(path));
		String txt;
		int i=0;
		List<categoty> list_c=articleService.find_categorys();
		model.addAttribute("list_cate", list_c);
		while((txt=bw.readLine())!=null) {
			i+=(txt.length()+59)/60;
			//System.out.println(txt+" "+i+txt.length());
			if(txt.equals(""))
			{
				i++;
			}
			if(article.getTxt()!=null)
				article.setTxt(article.getTxt()+'\n'+txt);
			else
				article.setTxt(txt);
		}
		*/
		model.addAttribute("this_mess",article);
		//System.out.println(i);
		//model.addAttribute("HIGHT",i*42);
		
		check_root(model, session, request);
		
		return "reads";
	}
	
	
	@RequestMapping(value = "/master/categoty.action", method = RequestMethod.GET)
	public String categoty(Model model,HttpSession session) {
		List<po.categoty> list=articleService.find_categorys();
		model.addAttribute("cate_list", list);
		model.addAttribute("list_cate", list);
		return "master/categoty";
	}
	
	@RequestMapping(value = "/master/delete_cate.action", method = RequestMethod.GET)
	public String delete_categoty(String id, Model model,HttpSession session) {
		
		articleService.delcate_con(id);
		articleService.delcate(id);
		return categoty(model, session);
	}
	
	@RequestMapping(value = "/master/user.action", method = RequestMethod.GET)
	public String master_user( Model model,HttpSession session,HttpServletRequest request) throws IOException{
		
		List<categoty> list_c=articleService.find_categorys();
		model.addAttribute("list_cate", list_c);
		
		User user=(User)session.getAttribute("user");
		if(user==null)
		{
			return tomain(model, request, session);
		}
		model.addAttribute("user", user);
		check_root(model, session, request);
		return "user";
	}
	
	
	@RequestMapping(value = "/master/add_cate.action", method = RequestMethod.POST)
	public String savecate(Model model,categoty categoty,HttpSession session,HttpServletRequest request) throws IOException {
		
		categoty categoty2=articleService.find_category(categoty.getContent());
		if(categoty2!=null)
		{
			return categoty(model, session);
		}
		
		Integer orderId=UUID.randomUUID().toString().hashCode();
		orderId = orderId < 0 ? -orderId : orderId;
		categoty.setId(orderId.toString());
		
		articleService.add_categorys(categoty);
				
		return categoty(model, session);
	}
	
	@RequestMapping(value = "/master/find_user_see.action", method = RequestMethod.POST)
	public String savecate(Model model,User user,HttpSession session,HttpServletRequest request) throws IOException {
		user.setId("%"+user.getId()+"%");
		
		List<categoty> list_c=articleService.find_categorys();
		model.addAttribute("list_cate", list_c);
		
		List<User> all=userserve.findUsers_id(user);
		all.addAll(userserve.findUsers_name(user));
		
		model.addAttribute("user_list", all);
		check_root(model, session, request);
		
		return "master/accounts";
	}
	
	public Model check_root(Model model,HttpSession session,HttpServletRequest request) throws IOException {
		
		User user=(User)session.getAttribute("user");
		
		if(user==null)
		{
			model.addAttribute("user_root","none" );
			model.addAttribute("account_root", "none");
			model.addAttribute("article_root","none" );
			model.addAttribute("cate_root", "none");
			model.addAttribute("write_root", "none");
			model.addAttribute("IN", "");
			model.addAttribute("OUT","none" );
			model.addAttribute("UP", "");
		}
		else if(user.getValue()==30)
		{
			model.addAttribute("user_root","" );
			model.addAttribute("account_root", "none");
			model.addAttribute("article_root","none" );
			model.addAttribute("cate_root", "none");
			model.addAttribute("write_root", "none");
			
			model.addAttribute("IN", "none");
			model.addAttribute("OUT", "");
			model.addAttribute("UP","none");
		}
		
		else if(user.getValue()==20)
		{
			model.addAttribute("user_root","" );
			model.addAttribute("account_root", "none");
			model.addAttribute("article_root","" );
			model.addAttribute("cate_root", "none");
			model.addAttribute("write_root", "");
			
			model.addAttribute("IN", "none");
			model.addAttribute("OUT", "");
			model.addAttribute("UP","none");
		}
		else if(user.getValue()==1)
		{
			model.addAttribute("user_root","" );
			model.addAttribute("account_root", "");
			model.addAttribute("article_root","" );
			model.addAttribute("cate_root", "");
			model.addAttribute("write_root", "");
			model.addAttribute("IN", "none");
			model.addAttribute("OUT", "");
			model.addAttribute("UP","none");
		}
		
		return model;
	}
	
	@RequestMapping(value = "master/saveuser.action", method = RequestMethod.POST)
    public String saveuser(User user,String password2,@RequestParam("photo2") MultipartFile photo2,Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
				// 获取上传文件的原始名称
				if(!user.getPassword().equals(password2)&&!password2.equals(""))
				{
					return master_user(model, session, request);
				}
				String originalFilename = photo2.getOriginalFilename();
				User user2=(User)session.getAttribute("user");
				String flase_path=user2.getPhoto();
				
				if(!originalFilename.equals("")){
					// 设置上传文件的保存地址目录
					String dirPath = 
                       request.getServletContext().getRealPath(flase_path);
					System.out.println("=========dirPath="+dirPath);
					try {
						// 使用MultipartFile接口的方法完成文件上传到指定位置
						photo2.transferTo(new File(dirPath));
					} catch (Exception e) {
						e.printStackTrace();
						return "error";
					}
				}
				articleService.setuser_1(user);
				session.setAttribute("user",userserve.findUser(user));
				return tomain(model,request,session);
    }
	
	@RequestMapping(value = "find_art_like.action", method = RequestMethod.GET)
    public String find_art_like(String query,Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
		User user=(User)session.getAttribute("user");
		List<categoty> list_c=articleService.find_categorys();
		model.addAttribute("list_cate", list_c);
		if(user==null)
		{
			model.addAttribute("LOG_IN","LOG IN");
			model.addAttribute("IMAGE","/page2/images/logo.jpg");//头像位置
			model.addAttribute("MASTER", "none");
			//${pageContext.request.contextPath}
			model.addAttribute("MOTTO","There is no royal road to learning");
		}
		else
		{
			if(user.getValue()==1)
				model.addAttribute("MASTER", "inline");
			else
				model.addAttribute("MASTER", "none");
			model.addAttribute("LOG_IN",user.getName());
			model.addAttribute("IMAGE",user.getPhoto());//头像位置
			model.addAttribute("MOTTO",user.getMotto());
		}
		String page=(String)session.getAttribute("page");
		if(page==null)
		{
			Integer l=0;
			page=l.toString();
			session.setAttribute("page", page);
		}
		if(page==null)
		{
			page="0";
		}
		if(Integer.valueOf(page)<0)
		{
			page="0";
		}
		tint tint1=new tint(Integer.valueOf(page)*3,Integer.valueOf(page)*3+12);
		tint1.c="%"+query+"%";
		System.out.println(tint1.c);
		List<Article> list=articleService.findart_3(tint1);
		System.out.println(list.size());
		
		while(list.size()==0&&!page.equals("0"))
		{
			page=((Integer)(Integer.valueOf(page)-1)).toString();
			list=articleService.findart_1(new tint(Integer.valueOf(page)*3,Integer.valueOf(page)*3+12));
		}
		session.setAttribute("page", page);
		int len=list.size();
		List<Article> list_1=new ArrayList<Article>();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0;i<len&&i<3;i++)
		{
			list.get(i).setTti(formatter.format(new Date(list.get(i).getTime().getTime())));
			String path=request.getServletContext().getRealPath(list.get(i).getContent()); 
			BufferedReader bw = new BufferedReader(new FileReader(path));
			String txt;
			while((txt=bw.readLine())!=null) {
				if(list.get(i).getTxt()!=null)
					list.get(i).setTxt(list.get(i).getTxt()+txt+'\n');
				else
					list.get(i).setTxt(txt+'\n');
				
			}
			list_1.add(list.get(i));
		}
		model.addAttribute("LIST_1", list_1);
		
		
		List<Article> list_2=new ArrayList<Article>();
		for(int i=3;i<len&&i<7;i++)
		{
			list.get(i).setTti(formatter.format(new Date(list.get(i).getTime().getTime())));
			String path=request.getServletContext().getRealPath(list.get(i).getContent()); 
			BufferedReader bw = new BufferedReader(new FileReader(path));
			String txt;
			while((txt=bw.readLine())!=null) {
				if(list.get(i).getTxt()!=null)
					list.get(i).setTxt(list.get(i).getTxt()+txt+'\n');
				else
					list.get(i).setTxt(txt+'\n');
				
			}
			list_2.add(list.get(i));
		}
		model.addAttribute("LIST_2", list_2);
		
		
		List<Article> list_3=new ArrayList<Article>();
		for(int i=7;i<len&&i<12;i++)
		{
			list.get(i).setTti(formatter.format(new Date(list.get(i).getTime().getTime())));
			String path=request.getServletContext().getRealPath(list.get(i).getContent()); 
			BufferedReader bw = new BufferedReader(new FileReader(path));
			String txt;
			while((txt=bw.readLine())!=null) {
				if(list.get(i).getTxt()!=null)
					list.get(i).setTxt(list.get(i).getTxt()+txt+'\n');
				else
					list.get(i).setTxt(txt+'\n');
				
			}
			list_3.add(list.get(i));
		}
		model.addAttribute("LIST_3", list_3);
		
		check_root(model, session, request);	
		return "main";
    }
	
	
	
	
	@RequestMapping(value = "/master/save_art_main.action", method = RequestMethod.POST)
	public String save_art_main(Model model,Article article,@RequestParam("photo2") MultipartFile photo2,String text,HttpSession session,HttpServletRequest request) throws IOException {
		
		User user=(User)session.getAttribute("user");
		Article article_sess=(Article)session.getAttribute("art_new");
		if(user==null)
		{
			model.addAttribute("LOG_IN","LOG IN");
			model.addAttribute("IMAGE","/page2/images/logo.jpg");//头像位置
			model.addAttribute("MASTER", "none");
			//${pageContext.request.contextPath}
			model.addAttribute("MOTTO","There is no royal road to learning");
			return tomain(model, request, session);
		}
		if(article_sess==null)
		{
			return tomain(model, request, session);
		}
		
		System.out.println("TT "+article_sess.getPhoto());
		
		/*
		String dirPath_t;
		
		String false_path="/texts/";
		dirPath_t = 
	               request.getServletContext().getRealPath(false_path);
		System.out.println("=========dirPath_t="+dirPath_t);
		File filePath_t = new File(dirPath_t);
		if (!filePath_t.exists()) {
			System.out.println("==========");
			filePath_t.mkdirs();
		}
		String newFilename_t = article.getId() + ".txt";
		false_path+=newFilename_t;
		BufferedWriter bw = new BufferedWriter(new FileWriter(dirPath_t+newFilename_t));
		bw.write(text);
		bw.close();
		article_sess.setContent(false_path);
		
		*/
		
		
		String originalFilename = photo2.getOriginalFilename();
		String flase_path="/texts/images/root.jpg";
		if(!originalFilename.equals("")){
			// 设置上传文件的保存地址目录
			flase_path="/texts/images/";
			String dirPath = 
               request.getServletContext().getRealPath(flase_path);
			File filePath = new File(dirPath);
			System.out.println("=========dirPath="+dirPath);
			// 如果保存文件的地址不存在，就先创建目录
			if (!filePath.exists()) {
				System.out.println("==========");
				filePath.mkdirs();
			}
			// 使用UUID（通用唯一标识）重新命名上传的文件名称(上传人_uuid_原始文件名称)
			String newFilename = article.getId() + 
                                           "_"+originalFilename;
			flase_path+=newFilename;
			try {
				// 使用MultipartFile接口的方法完成文件上传到指定位置
				photo2.transferTo(new File(dirPath + newFilename));
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		}
		
		
		if(!article_sess.getPhoto().equals("/texts/images/root.jpg")&&!article_sess.getPhoto().equals(flase_path)){
			File file=new File(request.getServletContext().getRealPath(article_sess.getPhoto()));
			
			if(file.delete())
			{
				System.out.println("YES!");
			}	
		}
		article_sess.setPhoto(flase_path);
		//System.out.println(article.getContent());
		//System.out.println(article.getPhoto());
		
		if(user.getValue()==1)
			model.addAttribute("MASTER", "inline");
		else
			model.addAttribute("MASTER", "none");
		
		model.addAttribute("LOG_IN",user.getName());
		model.addAttribute("IMAGE",user.getPhoto());//头像位置
		model.addAttribute("MOTTO",user.getMotto());	
		
		session.setAttribute("srt_new", article_sess);
		
		return toload(model, session, request);
	}
	
	
	@RequestMapping(value = "/master/save_art_mains.action", method = RequestMethod.POST)
	public String save_art_mains(Model model,Article article,int index,@RequestParam("photo2") MultipartFile photo2,String text,HttpSession session,HttpServletRequest request) throws IOException {
		
		User user=(User)session.getAttribute("user");
		Article article_sess=(Article)session.getAttribute("art_new");
		if(user==null)
		{
			model.addAttribute("LOG_IN","LOG IN");
			model.addAttribute("IMAGE","/page2/images/logo.jpg");//头像位置
			model.addAttribute("MASTER", "none");
			//${pageContext.request.contextPath}
			model.addAttribute("MOTTO","There is no royal road to learning");
			return tomain(model, request, session);
		}
		if(article_sess==null)
		{
			return tomain(model, request, session);
		}
		
		System.out.println("TT "+article_sess.getPhoto());
		
		
		String originalFilename = photo2.getOriginalFilename();
		String flase_path="/texts/images/root.jpg";
		if(!originalFilename.equals("")){
			// 设置上传文件的保存地址目录
			flase_path="/texts/images/";
			String dirPath = 
               request.getServletContext().getRealPath(flase_path);
			File filePath = new File(dirPath);
			System.out.println("=========dirPath="+dirPath);
			// 如果保存文件的地址不存在，就先创建目录
			if (!filePath.exists()) {
				System.out.println("==========");
				filePath.mkdirs();
			}
			// 使用UUID（通用唯一标识）重新命名上传的文件名称(上传人_uuid_原始文件名称)
			String newFilename = article.getId() + 
                                           "_"+originalFilename;
			flase_path+=newFilename;
			try {
				// 使用MultipartFile接口的方法完成文件上传到指定位置
				photo2.transferTo(new File(dirPath + newFilename));
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		}
		
		
		if(!article_sess.getContents().get(index).getImage().equals("/texts/images/root.jpg")&&!article_sess.getContents().get(index).getImage().equals(flase_path)){
			File file=new File(request.getServletContext().getRealPath(article_sess.getContents().get(index).getImage()));
			
			if(file.delete())
			{
				System.out.println("YES!");
			}	
		}
		article_sess.getContents().get(index).setImage(flase_path);
		//System.out.println(article.getContent());
		//System.out.println(article.getPhoto());
		
		if(user.getValue()==1)
			model.addAttribute("MASTER", "inline");
		else
			model.addAttribute("MASTER", "none");
		
		model.addAttribute("LOG_IN",user.getName());
		model.addAttribute("IMAGE",user.getPhoto());//头像位置
		model.addAttribute("MOTTO",user.getMotto());	
		
		session.setAttribute("srt_new", article_sess);
		
		return toload(model, session, request);
	}
	
	
	@RequestMapping(value = "/master/load_write.action", method = RequestMethod.GET)
	public String toload(Model model,HttpSession session,HttpServletRequest request) throws IOException {
		
		List<categoty> list_c=articleService.find_categorys();
		model.addAttribute("list_cate", list_c);
		
		User user=(User)session.getAttribute("user");
		Article article=(Article)session.getAttribute("art_new");
		
		if(user==null||article==null)
			tomain(model, request, session);
		
		if(article.getContent()!=null){
			String path=request.getServletContext().getRealPath(article.getContent()); 
			BufferedReader bw = new BufferedReader(new FileReader(path));
			String txt;
			while((txt=bw.readLine())!=null) {
				if(article.getTxt()!=null)
					article.setTxt(article.getTxt()+txt+'\n');
				else
					article.setTxt(txt+'\n');
				
			}
		}
		
		//权限检测
		check_root(model, session, request);
		
		
		//前端需要的数据
		model.addAttribute("user", user);
		model.addAttribute("art",article);
		//System.out.println("TTT "+article.getPhoto());
		
		session.setAttribute("art_new", article);  //最后需要储存的信息
		
		return "master/writes";
	}
	
	//ajax测试
	@RequestMapping(value = "/ajax.action", method = RequestMethod.POST)
	@ResponseBody
    public String ajax(String query,Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, InterruptedException {
		System.out.println(query);
		TimeUnit.SECONDS.sleep(5);
		System.out.println("true");
		return "true";
	}
	
	@RequestMapping(value = "/ajax/save_alls.action", method = RequestMethod.POST)
    public String save_alls(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, InterruptedException {
		Article article=(Article)session.getAttribute("art_new");
		article.setContent("/texts/"+article.getId()+".txt");
		System.out.println(article.getContent());
		article.setDelete_flag(false);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(request.getServletContext().getRealPath(article.getContent())));
		oos.writeObject(article);
		//System.out.println("true_file");
		oos.close();
		articleService.addUser(article);
		session.removeAttribute("art_new");
		
		return tomain(model, request, session);
	}
	
	@RequestMapping(value = "/ajax/updata_alls.action", method = RequestMethod.POST)
    public String updata_alls(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, InterruptedException {
		Article article=(Article)session.getAttribute("art_new");
		Article article_old=(Article)session.getAttribute("art_old");
		System.out.println(article.getContent());
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(request.getServletContext().getRealPath(article.getContent())));
		oos.writeObject(article);
		//System.out.println("true_file");
		oos.close();
		
		if(!article.getPhoto().equals(article_old.getPhoto())&&!article_old.getPhoto().equals("/texts/images/root.jpg"))
		{
			File file=new File(request.getServletContext().getRealPath(article_old.getPhoto()));
			file.delete();
		}
		for(int i=0;i<article.getContents().size();i++)
		{
			System.out.println(article.getContents().get(i).getImage());
			System.out.println(article_old.getContents().get(i).getImage());
			if(!article.getContents().get(i).getImage().equals(article_old.getContents().get(i).getImage())&&!article_old.getContents().get(i).getImage().equals("/texts/images/root.jpg"))
			{
				System.out.println("delete_");
				File file=new File(request.getServletContext().getRealPath(article_old.getContents().get(i).getImage()));
				file.delete();
			}
		}
		
		
		articleService.updataart(article);
		session.removeAttribute("art_new");
		session.removeAttribute("art_old");
		return tomain(model, request, session);
	}
	
	@RequestMapping(value = "/ajax/list_add.action", method = RequestMethod.POST)
	@ResponseBody
    public String list_add(int index,Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, InterruptedException {
		//System.out.println(index);
		Article article=(Article)session.getAttribute("art_new");
		Article article_old=(Article)session.getAttribute("art_old");
		date_art date_art=new date_art();
		date_art.setImage("/texts/images/root.jpg");
		article.getContents().add(index,date_art);
		if(article_old!=null)
		{
			article_old.getContents().add(index,date_art);
		}
		session.setAttribute("art_new", article);
		return "true";
	}
	
	@RequestMapping(value = "/ajax/list_delete.action", method = RequestMethod.POST)
	@ResponseBody
    public String list_delete(int index,Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, InterruptedException {
		System.out.println(index);
		Article article=(Article)session.getAttribute("art_new");
		Article article_old=(Article)session.getAttribute("art_old");
		if(!article.getContents().get(index).getImage().equals("/texts/images/root.jpg")){
			File file=new File(request.getServletContext().getRealPath(article.getContents().get(index).getImage()));
			if(file.delete())
			{
				System.out.println("YES!");
			}	
		}
		article.getContents().remove(index);
		if(article_old!=null)
		{
			if(index<article_old.getContents().size())
				article_old.getContents().remove(index);
		}
		session.setAttribute("art_new", article);
		return "true";
	}
	
	@RequestMapping(value = "/ajax/save_title.action", method = RequestMethod.POST)
	@ResponseBody
    public String save_title(String title,Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, InterruptedException {
		Article article=(Article)session.getAttribute("art_new");
		article.setTitle(title);
		session.setAttribute("art_new", article);
		//System.out.println(title);
		return "true";
	}
	
	@RequestMapping(value = "/ajax/save_intro.action", method = RequestMethod.POST)
	@ResponseBody
    public String save_intro(String intro,Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, InterruptedException {
		Article article=(Article)session.getAttribute("art_new");
		article.setIntro(intro);
		session.setAttribute("art_new", article);
		//System.out.println(intro);
		return "true";
	}
	
	@RequestMapping(value = "/ajax/save_text_main.action", method = RequestMethod.POST)
	@ResponseBody
    public String save_text_main(String text,Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, InterruptedException {
		Article article=(Article)session.getAttribute("art_new");
		article.setTxt(text);
		session.setAttribute("art_new", article);
		//System.out.println(text);
		return "true";
	}
	
	@RequestMapping(value = "/ajax/save_text_mains.action", method = RequestMethod.POST)
	@ResponseBody
    public String save_text_mains(String text,int index,Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, InterruptedException {
		Article article=(Article)session.getAttribute("art_new");
		//article.setTxt(text);
		
		article.getContents().get(index).setArt(text);
		
		session.setAttribute("art_new", article);
		//System.out.println(index);
		return "true";
	}
	
	
	@RequestMapping(value = "/ajax/save_image_main.action", method = RequestMethod.POST)
	@ResponseBody
	public String save_image_main(@RequestParam("file") MultipartFile photo2,Model model,HttpSession session,HttpServletRequest request) throws IOException {
		
		User user=(User)session.getAttribute("user");
		Article article_sess=(Article)session.getAttribute("art_new");
		if(user==null)
		{
			return "error";
		}
		if(article_sess==null)
		{
			return "error";
		}
		String originalFilename = photo2.getOriginalFilename();
		String flase_path="/texts/images/root.jpg";
		//System.out.println(originalFilename);
		//System.out.println("look");
		if(!originalFilename.equals("")){
			// 设置上传文件的保存地址目录
			flase_path="/texts/images/";
			String dirPath = 
               request.getServletContext().getRealPath(flase_path);
			File filePath = new File(dirPath);
			System.out.println("=========dirPath="+dirPath);
			// 如果保存文件的地址不存在，就先创建目录
			if (!filePath.exists()) {
				System.out.println("==========");
				filePath.mkdirs();
			}
			// 使用UUID（通用唯一标识）重新命名上传的文件名称(上传人_uuid_原始文件名称)
			String newFilename = article_sess.getId() +"main"+ 
                                           "_"+originalFilename;
			flase_path+=newFilename;
			try {
				// 使用MultipartFile接口的方法完成文件上传到指定位置
				photo2.transferTo(new File(dirPath + newFilename));
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		}
		
		
		if(!article_sess.getPhoto().equals("/texts/images/root.jpg")&&!article_sess.getPhoto().equals(flase_path)){
			File file=new File(request.getServletContext().getRealPath(article_sess.getPhoto()));
			
			if(file.delete())
			{
				System.out.println("YES!");
			}	
		}
		article_sess.setPhoto(flase_path);
		//System.out.println(article.getContent());
		//System.out.println(article.getPhoto());
		
		if(user.getValue()==1)
			model.addAttribute("MASTER", "inline");
		else
			model.addAttribute("MASTER", "none");
		
		model.addAttribute("LOG_IN",user.getName());
		model.addAttribute("IMAGE",user.getPhoto());//头像位置
		model.addAttribute("MOTTO",user.getMotto());	
		
		session.setAttribute("srt_new", article_sess);
		
		return "true";
	}
	
	@RequestMapping(value = "/ajax/save_image_main_change.action", method = RequestMethod.POST)
	@ResponseBody
	public String save_image_main_change(@RequestParam("file") MultipartFile photo2,Model model,HttpSession session,HttpServletRequest request) throws IOException {
		
		User user=(User)session.getAttribute("user");
		Article article_sess=(Article)session.getAttribute("art_new");
		if(user==null)
		{
			return "error";
		}
		if(article_sess==null)
		{
			return "error";
		}
		String originalFilename = photo2.getOriginalFilename();
		String flase_path="/texts/images/root.jpg";
		//System.out.println(originalFilename);
		//System.out.println("look");
		if(!originalFilename.equals("")){
			// 设置上传文件的保存地址目录
			flase_path="/texts/images/";
			String dirPath = 
               request.getServletContext().getRealPath(flase_path);
			File filePath = new File(dirPath);
			System.out.println("=========dirPath="+dirPath);
			// 如果保存文件的地址不存在，就先创建目录
			if (!filePath.exists()) {
				System.out.println("==========");
				filePath.mkdirs();
			}
			// 使用UUID（通用唯一标识）重新命名上传的文件名称(上传人_uuid_原始文件名称)
			String newFilename = article_sess.getId() + "main"+
                                           "_"+originalFilename;
			flase_path+=newFilename;
			try {
				// 使用MultipartFile接口的方法完成文件上传到指定位置
				photo2.transferTo(new File(dirPath + newFilename));
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		}
		
		Article article_old=(Article)session.getAttribute("art_old");
		System.out.println(article_old.getPhoto());
		System.out.println(article_sess.getPhoto());
		if(!article_sess.getPhoto().equals("/texts/images/root.jpg")&&!article_sess.getPhoto().equals(flase_path)&&!article_old.getPhoto().equals(article_sess.getPhoto())){
			
			File file=new File(request.getServletContext().getRealPath(article_sess.getPhoto()));
			if(file.delete())
			{
				System.out.println("YES!");
			}	
		}
		article_sess.setPhoto(flase_path);
		//System.out.println(article.getContent());
		//System.out.println(article.getPhoto());
		
		if(user.getValue()==1)
			model.addAttribute("MASTER", "inline");
		else
			model.addAttribute("MASTER", "none");
		
		model.addAttribute("LOG_IN",user.getName());
		model.addAttribute("IMAGE",user.getPhoto());//头像位置
		model.addAttribute("MOTTO",user.getMotto());	
		
		session.setAttribute("srt_new", article_sess);
		
		return "true";
	}
	
	
	@RequestMapping(value = "/ajax/save_image_mains.action", method = RequestMethod.POST)
	@ResponseBody
	public String save_image_mains(@RequestParam("file") MultipartFile photo2,int index,Model model,HttpSession session,HttpServletRequest request) throws IOException {
		
		User user=(User)session.getAttribute("user");
		Article article_sess=(Article)session.getAttribute("art_new");
		if(user==null)
		{
			return "error";
		}
		if(article_sess==null)
		{
			return "error";
		}
		String originalFilename = photo2.getOriginalFilename();
		String flase_path="/texts/images/root.jpg";
		//System.out.println(originalFilename);
		//System.out.println("look");
		if(!originalFilename.equals("")){
			// 设置上传文件的保存地址目录
			flase_path="/texts/images/";
			String dirPath = 
               request.getServletContext().getRealPath(flase_path);
			File filePath = new File(dirPath);
			System.out.println("=========dirPath="+dirPath);
			// 如果保存文件的地址不存在，就先创建目录
			if (!filePath.exists()) {
				System.out.println("==========");
				filePath.mkdirs();
			}
			// 使用UUID（通用唯一标识）重新命名上传的文件名称(上传人_uuid_原始文件名称)
			String newFilename = article_sess.getId() + String.valueOf(index)+
                                           "_"+originalFilename;
			flase_path+=newFilename;
			try {
				// 使用MultipartFile接口的方法完成文件上传到指定位置
				photo2.transferTo(new File(dirPath + newFilename));
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		}
		
		
		if(!article_sess.getContents().get(index).getImage().equals("/texts/images/root.jpg")&&!article_sess.getContents().get(index).getImage().equals(flase_path)){
			File file=new File(request.getServletContext().getRealPath(article_sess.getPhoto()));
			
			if(file.delete())
			{
				System.out.println("YES!");
			}	
		}
		article_sess.getContents().get(index).setImage(flase_path);
		//System.out.println(article.getContent());
		//System.out.println(article.getPhoto());
		
		if(user.getValue()==1)
			model.addAttribute("MASTER", "inline");
		else
			model.addAttribute("MASTER", "none");
		
		model.addAttribute("LOG_IN",user.getName());
		model.addAttribute("IMAGE",user.getPhoto());//头像位置
		model.addAttribute("MOTTO",user.getMotto());	
		
		session.setAttribute("srt_new", article_sess);
		
		return "true";
	}
	
	
	@RequestMapping(value = "/ajax/save_image_mains_change.action", method = RequestMethod.POST)
	@ResponseBody
	public String save_image_mains_change(@RequestParam("file") MultipartFile photo2,int index,Model model,HttpSession session,HttpServletRequest request) throws IOException {
		
		User user=(User)session.getAttribute("user");
		Article article_sess=(Article)session.getAttribute("art_new");
		if(user==null)
		{
			return "error";
		}
		if(article_sess==null)
		{
			return "error";
		}
		String originalFilename = photo2.getOriginalFilename();
		String flase_path="/texts/images/root.jpg";
		//System.out.println(originalFilename);
		//System.out.println("look");
		if(!originalFilename.equals("")){
			// 设置上传文件的保存地址目录
			flase_path="/texts/images/";
			String dirPath = 
               request.getServletContext().getRealPath(flase_path);
			File filePath = new File(dirPath);
			System.out.println("=========dirPath="+dirPath);
			// 如果保存文件的地址不存在，就先创建目录
			if (!filePath.exists()) {
				System.out.println("==========");
				filePath.mkdirs();
			}
			// 使用UUID（通用唯一标识）重新命名上传的文件名称(上传人_uuid_原始文件名称)
			String newFilename = article_sess.getId() + String.valueOf(index)+
                                           "_"+originalFilename;
			flase_path+=newFilename;
			try {
				// 使用MultipartFile接口的方法完成文件上传到指定位置
				photo2.transferTo(new File(dirPath + newFilename));
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		}
		
		Article article_old=(Article)session.getAttribute("art_old");
		if(!article_sess.getContents().get(index).getImage().equals("/texts/images/root.jpg")&&!article_sess.getContents().get(index).getImage().equals(flase_path)&&!article_old.getContents().get(index).getImage().equals(article_sess.getContents().get(index).getImage())){
			File file=new File(request.getServletContext().getRealPath(article_sess.getPhoto()));
			
			if(file.delete())
			{
				System.out.println("YES!");
			}	
		}
		article_sess.getContents().get(index).setImage(flase_path);
		//System.out.println(article.getContent());
		//System.out.println(article.getPhoto());
		
		if(user.getValue()==1)
			model.addAttribute("MASTER", "inline");
		else
			model.addAttribute("MASTER", "none");
		
		model.addAttribute("LOG_IN",user.getName());
		model.addAttribute("IMAGE",user.getPhoto());//头像位置
		model.addAttribute("MOTTO",user.getMotto());	
		
		session.setAttribute("srt_new", article_sess);
		
		return "true";
	}
	

}




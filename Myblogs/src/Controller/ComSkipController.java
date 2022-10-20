package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import po.Article;
import po.User;
import po.categoty;
import po.date_art;
import po.pairt;
import po.tint;
import service.ArticleService;
import service.UserService;


@Controller
public class ComSkipController {

	@Autowired
	UserService userserve;
	
	
	@Autowired
	ArticleService articleService;
	
	
	@RequestMapping(value = "/main.action", method = RequestMethod.GET)
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
	

	@RequestMapping(value = "/main_kinds.action", method = RequestMethod.GET)
    public String tomain_kinds(String id,Model model,HttpServletRequest request,HttpSession session) throws IOException {
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
		tint tin=new tint(Integer.valueOf(page)*3,Integer.valueOf(page)*3+12);
		tin.c=id;
		List<Article> list=articleService.findart_2(tin);
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
	
	@RequestMapping(value = "/login.action", method = RequestMethod.GET)
    public String tologin(Model model,HttpServletRequest request,HttpSession session) throws IOException {
		User user=(User)session.getAttribute("user");
		if(user!=null)
		{
			model.addAttribute("LOG_IN",user.getName());
			model.addAttribute("IMAGE",user.getPhoto());//头像位置
			model.addAttribute("MOTTO",user.getMotto());
			return tomain(model,request,session);
		}
		else
		{
			model.addAttribute("LOGIN_MESS", "Enter the Wonderful!");
			return "LogIn";
		}
    }
	
	@RequestMapping(value = "/master/change_art.action", method = RequestMethod.GET)
	public String change_art(Model model,HttpSession session,HttpServletRequest request,String id) throws IOException{
		
		Article article=articleService.findart(id);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		article.setTti(formatter.format(new Date(article.getTime().getTime())));
		String path=request.getServletContext().getRealPath(article.getContent()); 
		BufferedReader bw = new BufferedReader(new FileReader(path));
		String txt;
		while((txt=bw.readLine())!=null) {
			if(article.getTxt()!=null)
				article.setTxt(article.getTxt()+txt+'\n');
			else
				article.setTxt(txt+'\n');
			
		}
		model.addAttribute("art", article);
		return "master/change";
	}
	
	
	@RequestMapping(value = "/master/changes_art.action", method = RequestMethod.GET)
	public String changes_art(Model model,HttpSession session,HttpServletRequest request,String id) throws IOException, ClassNotFoundException{
		Article article=(Article)session.getAttribute("art_new");
		Article article_old=(Article)session.getAttribute("art_old");
		String flag =(String)session.getAttribute("changes_flag");
		if(flag==null || !flag.equals("true")){
			System.out.println("CZC");
			List<categoty> list_c=articleService.find_categorys();
			model.addAttribute("list_cate", list_c);
			
			Article article1=articleService.findart(id);
			
			String path=request.getServletContext().getRealPath(article1.getContent()); 
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
	        article = (Article) ois.readObject();
			article.setPhoto_u(article1.getPhoto_u());
			article.setName(article1.getName());
			
			
			model.addAttribute("art", article);
			session.setAttribute("art_new", article);  //最后需要储存的信息	
			
			ois = new ObjectInputStream(new FileInputStream(path));
			article_old = (Article) ois.readObject();
	        ois.close();
			session.setAttribute("art_old", article_old);  //副本信息,转储的时候用
			session.setAttribute("changes_flag", "true");
		}
		else
		{
			model.addAttribute("art", article);
		}
		check_root(model, session, request);
		return "master/changes";
	}
	
	@RequestMapping(value = "/signup.action", method = RequestMethod.GET)
    public String tosignin(Model model,HttpServletRequest request,HttpSession session) {
		model.addAttribute("SIGN", "ENTER THE WONDERFUL!");
		return "signup";
    }
	
	@RequestMapping(value = "/logout.action", method = RequestMethod.GET)
    public String tologout(Model model,HttpServletRequest request,HttpSession session) throws IOException{
		User user=(User)session.getAttribute("user");
		if(user!=null)
		{
			session.removeAttribute("user");	
		}
		model.addAttribute("LOG_IN","LOG IN");
		model.addAttribute("MASTER", "none");
		model.addAttribute("IMAGE","/page2/images/logo.jpg");//头像位置
		//${pageContext.request.contextPath}
		model.addAttribute("MOTTO","There is no royal road to learning");
		return tomain(model,request,session);
    }
	
	
	@RequestMapping(value = "/master/accounts.action", method = RequestMethod.GET)
    public String toaccounts(Model model,HttpServletRequest request,HttpSession session)throws IOException {
		List<categoty> list_c=articleService.find_categorys();
		model.addAttribute("list_cate", list_c);
		List<User> list=userserve.getUsers();
		model.addAttribute("user_list", list);
		check_root(model, session, request);
		return "master/accounts";
    }
	
	
	
	@RequestMapping(value = "/master/savetext_2.action", method = RequestMethod.POST)
	public String savetext_2(Model model,Article article,@RequestParam("photo2") MultipartFile photo2,String text,HttpSession session,HttpServletRequest request) throws IOException {
		
		Article article2=articleService.findart(article.getId());
		System.out.println(article.getId());
		String dirPath_t = 
	               request.getServletContext().getRealPath(article2.getContent());
		System.out.println("=========dirPath_t="+dirPath_t);
		System.out.println(dirPath_t);
		BufferedWriter bw = new BufferedWriter(new FileWriter(dirPath_t));
		bw.write(text);
		bw.close();
		
		
		String originalFilename = photo2.getOriginalFilename();
		String flase_path=article2.getPhoto();
		
		if(!originalFilename.equals("")){
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
		articleService.setart(article);
		return toarticle(model, request, session);
	}
	
	@RequestMapping(value = "/master/article.action", method = RequestMethod.GET)
    public String toarticle(Model model,HttpServletRequest request,HttpSession session) throws IOException {
		
		User user=(User)session.getAttribute("user");
		List<Article> list;
		if(user.getValue()==1)
		{
			list=articleService.findarts();
		}
		else
		{
			list=articleService.findarts_low(user.getId());
		}
			
		int len=list.size();
		
		
		List<categoty> list_c=articleService.find_categorys();
		model.addAttribute("list_cate", list_c);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0;i<len;i++)
		{
			list.get(i).setCategoty(articleService.category(list.get(i).getId()));
			list.get(i).setTti(formatter.format(new Date(list.get(i).getTime().getTime())));
		}
		model.addAttribute("article_list", list);
		check_root(model, session, request);
		return "master/article";
    }
	
	@RequestMapping(value = "/master/publish.action", method = RequestMethod.GET)
    public String publish(String id,Model model,HttpServletRequest request,HttpSession session) throws IOException {
		Article article=articleService.findart(id);
		if(article.getPublish()==true)
		{
			articleService.setart_pub_0(id);
		}
		else
		{

			articleService.setart_pub_1(id);
		}
		return toarticle(model, request, session);
    }
	
	
	@RequestMapping(value = "/master/write.action", method = RequestMethod.GET)
	public String towrite(Model model,HttpSession session,HttpServletRequest request) throws IOException {
		User user=(User)session.getAttribute("user");
		Date date = new Date();
		
		List<categoty> list_c=articleService.find_categorys();
		model.addAttribute("list_cate", list_c);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		
		
		check_root(model, session, request);
		model.addAttribute("time",dateString);
		model.addAttribute("user", user);
		return "master/write";
	}
	
	@RequestMapping(value = "/ajax/writes.action", method = RequestMethod.GET)
	public String towrites(Model model,HttpSession session,HttpServletRequest request) throws IOException {
		User user=(User)session.getAttribute("user");
		Date date = new Date();
		
		List<categoty> list_c=articleService.find_categorys();
		model.addAttribute("list_cate", list_c);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		
		
		
		check_root(model, session, request);
		
		model.addAttribute("time",dateString);
		model.addAttribute("user", user);
		
		//构造文章类
		Article article=(Article)session.getAttribute("art_new");
		if(article==null||!article.isDelete_flag()){
			article=new Article();
			
			Integer orderId=UUID.randomUUID().toString().hashCode();
			orderId = orderId < 0 ? -orderId : orderId;
			Timestamp t = new Timestamp(date.getTime());
			
			
			article.setDelete_flag(true);
			article.setId(orderId.toString());  //分配文章号
			article.setUser_id(user.getId());	//获取用户号
			article.setTime(t);                 //记录时间
			article.setRead_t(0);               //阅读数计0
			article.setVersion("1");	   		//版本号置1
			article.setPublish(false);
			article.setTti(formatter.format(new Date(article.getTime().getTime())));
			//时间转换
			//String dirPath = 
		    //           request.getServletContext().getRealPath(flase_path);
			//		File filePath = new File(dirPath);
			/*
			String path="/texts/images/"+article.getId()+"pic01.jpg";
			File source=new File(request.getServletContext().getRealPath("/page2/images/pic01.jpg"));
			File dest=new File(request.getServletContext().getRealPath(path));
	
	        Files.copy(source.toPath(), dest.toPath());
	        
	        System.out.println(request.getServletContext().getRealPath("/texts/images/"+article.getId()+"pic01.jpg"));
	      	*/
			article.setPhoto("/texts/images/root.jpg");
		}
		
		//System.out.println(article.getTitle());
		//System.out.println("load");
		
		
		
		model.addAttribute("art",article);
		
		//FileUtils.copyFile(source, dest);
		
		session.setAttribute("art_new", article);  //最后需要储存的信息
		
		return "master/writes";
	}
	
	
	@RequestMapping(value = "/next.action", method = RequestMethod.GET)
	public String tonext(Model model,HttpSession session,HttpServletRequest request) throws IOException{
		String page=(String)session.getAttribute("page");
		if(page==null)
		{
			Integer l=0;
			page=l.toString();
			session.setAttribute("page", page);
		}
		else
		{
			page=((Integer)(Integer.valueOf(page)+1)).toString();
			session.setAttribute("page", page);
		}
		List<categoty> list_c=articleService.find_categorys();
		model.addAttribute("list_cate", list_c);
		return tomain(model, request, session);
	}
	
	
	@RequestMapping(value = "/previous.action", method = RequestMethod.GET)
	public String toprevious(Model model,HttpSession session,HttpServletRequest request) throws IOException{
		String page=(String)session.getAttribute("page");
		if(page==null)
		{
			Integer l=0;
			page=l.toString();
			session.setAttribute("page", page);
		}
		else
		{
			page=((Integer)(Integer.valueOf(page)-1)).toString();
			session.setAttribute("page", page);
		}
		
		return tomain(model, request, session);
	}
	
	
	@RequestMapping(value = "/master/delete_art.action", method = RequestMethod.GET)
	public String delete_art(String id,Model model,HttpSession session,HttpServletRequest request) throws IOException, ClassNotFoundException{
		Article article=articleService.findart(id);
		if(article==null)
		{
			return toarticle(model, request, session);
		}
		String path=request.getServletContext().getRealPath(article.getContent());
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		article = (Article) ois.readObject();
		ois.close();
		
		
		articleService.delart_con(article.getId());
		
		
		
		path=request.getServletContext().getRealPath(article.getPhoto()); 
		//System.out.println(path);
		File file = new File(path);
		file.delete();
		
		for(int i=0;i<article.getContents().size();i++)
		{
			if(!article.getContents().get(i).getImage().equals("/texts/images/root.jpg"))
			{
				path=request.getServletContext().getRealPath(article.getContents().get(i).getImage());; 
				file = new File(path);
				file.delete();
			}
		}
		
		System.gc();
		path=request.getServletContext().getRealPath(article.getContent()); 
		file = new File(path);
		file.delete();
		//System.out.println(path);
		articleService.delart(id);
		return toarticle(model, request, session);
	}
	
	@RequestMapping(value = "/master/cate_allot.action", method = RequestMethod.POST)
	public String cate_allot(String id,String cate_id,Model model,HttpSession session,HttpServletRequest request) throws IOException {
		pairt pairt=new pairt(id,cate_id);
		pairt pairt2=articleService.find_conn(pairt);
		if(pairt2!=null)
		{
			return toarticle(model, request, session);
		}
		articleService.add_conn(pairt);
		return toarticle(model, request, session);
	}
	
	
	
	@RequestMapping(value = "/master/delete_conn.action", method = RequestMethod.GET)
    public String delete_conn(String u_id,String i_id,Model model,HttpServletRequest request,HttpSession session) throws IOException {
		
		pairt pairt=new pairt(u_id,i_id);
		pairt pairt2=articleService.find_conn(pairt);
		if(pairt2==null)
		{
			return toarticle(model, request, session);
		}
		
		articleService.del_conn(pairt2);
		
		
		return toarticle(model, request, session);
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

	@RequestMapping(value = "/welcome.action", method = RequestMethod.GET)
	public String towelcome(Model model,HttpServletRequest request,HttpSession session) throws IOException {
		return "welcome";
	}
}

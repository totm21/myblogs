package interceptor;
import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import po.Article;
import po.User;
/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler)
			throws Exception {
		// 获取请求的URL
		String url = request.getRequestURI();
		System.out.println(url.toString());
		HttpSession session = request.getSession();
		Article article=(Article)session.getAttribute("art_new");
		Article article_old=(Article)session.getAttribute("art_old");
		if(article!=null&&url.indexOf("/ajax/")<0)
		{
			String path;
			File file;
			
			if(article_old!=null)
			{
				if(!article_old.getPhoto().equals(article.getPhoto())){
					path=request.getServletContext().getRealPath(article.getPhoto()); 
					System.out.println(path);
					file = new File(path);
					file.delete();
				}
				for(int i=0;i<article.getContents().size();i++)
				{
					if(!article_old.getContents().get(i).getImage().equals(article.getContents().get(i).getImage()))
					{
						path=request.getServletContext().getRealPath(article.getContents().get(i).getImage());; 
						file = new File(path);
						file.delete();
					}
				}
			}
			if(article.isDelete_flag()){
				if(!article.getPhoto().equals("/texts/images/root.jpg")){
					path=request.getServletContext().getRealPath(article.getPhoto()); 
					System.out.println(path);
					file = new File(path);
					file.delete();
				}
				for(int i=0;i<article.getContents().size();i++)
				{
					if(!article.getContents().get(i).getImage().equals("/texts/images/root.jpg"))
					{
						path=request.getServletContext().getRealPath(article.getContents().get(i).getImage());; 
						file = new File(path);
						file.delete();
					}
				}
				session.removeAttribute("art_new");
			//删除当前数据
			}
		}
		User user = (User) session.getAttribute("user");
		if(user==null)
		{
			if (url.indexOf("/master/") >= 0) {
				request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp").forward(request, response);
				return false;
			}
			else
				return true;
		}
		if(user.getValue()==1)
		{
			return true;
		}
		if (url.indexOf("/master/accounts.action") >= 0) {
			request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp").forward(request, response);
			return false;
		}
		else if (url.indexOf("/master/article.action") >= 0) {
			if(user.getValue()==20)
			{
				return true;
			}
			request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp").forward(request, response);
			return false;
		}
		else if (url.indexOf("/master/categoty.action") >= 0) {
			request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp").forward(request, response);
			return false;
		}
		else if (url.indexOf("/master/write.action") >= 0) {
			if(user.getValue()==20)
			{
				return true;
			}
			request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp").forward(request, response);
			return false;
		}
		else if (url.indexOf("/master/user.action") >= 0) {
			return true;
		}
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
	@Override
	public void afterCompletion(HttpServletRequest request, 
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}

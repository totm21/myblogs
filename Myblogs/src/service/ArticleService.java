package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.ArticleDao;
import po.Article;
import po.User;
import po.categoty;
import po.pairt;
import po.tint;

@Service
public class ArticleService {

	@Autowired
	ArticleDao articleDao;
	
	public int addUser(Article article)
	{
		//System.out.println(article.getId());
		return articleDao.addart(article);
	}
	
	public int updataart(Article article)
	{
		return articleDao.updataart(article);
	}
	
	public List<Article> findart_1(tint n)
	{
		return articleDao.findarts_1(n);
	}
	
	public List<Article> findart_2(tint n)
	{
		return articleDao.findarts_2(n);
	}
	
	public List<Article> findart_3(tint n)
	{
		return articleDao.findarts_3(n);
	}
	
	public List<Article> findarts()
	{
		return articleDao.findarts();
	}
	
	public List<Article> findarts_low(String id)
	{
		return articleDao.findarts_low(id);
	}
	
	public Article findart(String id)
	{
		return articleDao.findart(id);
	}
	
	public void setart_pub_1(String id)
	{
		articleDao.setart_pub_1(id);
		return;
	}
	
	
	public void setart_pub_0(String id)
	{
		articleDao.setart_pub_0(id);
		return;
	}
	
	public int delart(String id)
	{
		return articleDao.delart(id);
	}
	
	public void setart(Article article)
	{
		articleDao.setaer(article);
	}
	
	public List<categoty> category(String id)
	{
		return articleDao.category(id);
	}
	
	public List<categoty> find_categorys()
	{
		return articleDao.find_categorys();
	}
	
	public int add_categorys(categoty categoty2)
	{
		return articleDao.add_categorys(categoty2);
	}

	public int delcate(String id)
	{
		return articleDao.delcate(id);
	}
	
	public categoty find_category(String content)
	{
		return articleDao.find_category(content);
	}
	
	public int set_category(categoty categoty2)
	{
		return articleDao.set_category(categoty2);
	}
	
	
	public int add_conn(pairt pairt)
	{
		return articleDao.add_conn(pairt);
	}

	public pairt find_conn(pairt pairt)
	{
		return articleDao.find_conn(pairt);
	}
	
	public int del_conn(pairt pairt)
	{
		return articleDao.del_conn(pairt);
	}

	public int delart_con(String id)
	{
		return articleDao.delart_con(id);
	}
	
	public int delcate_con(String id)
	{
		return articleDao.delcate_con(id);
	}
	
	public void setuser_1(User user)
	{
		articleDao.setuser_1(user);
	}
}

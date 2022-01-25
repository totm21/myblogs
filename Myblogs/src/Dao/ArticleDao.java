package Dao;

import java.util.List;

import po.Article;
import po.User;
import po.categoty;
import po.pairt;
import po.tint;

public interface ArticleDao {

	public int addart(Article article);
	
	public int updataart(Article article);
	
	public Article findart(String id);
	
	public List<Article> findarts();
	
	public List<Article> findarts_low(String id);
	
	public List<Article> findarts_1(tint n);
	public List<Article> findarts_2(tint n);
	
	public List<Article> findarts_3(tint n);
	
	public void setart_pub_1(String id);
	public void setart_pub_0(String id);
	
	public int delart(String id);
	public int delart_con(String id);
	public int delcate_con(String id);
	
	public void setaer(Article article);
	public void setuser_1(User user);
	
	public List<categoty> category(String id);
	public List<categoty> find_categorys();
	public int add_categorys(categoty categoty2);
	public categoty find_category(String content);
	public int delcate(String id);
	public int set_category(categoty categoty2);
	
	public int add_conn(pairt pairt);
	public pairt find_conn(pairt pairt);
	
	public int del_conn(pairt pairt);
	
}

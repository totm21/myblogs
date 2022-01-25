package po;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Article implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String version;  //版本号
	//以后更新在使用吧
	
	private String id;
	private String title;
	private String intro;
	
	
	private String photo;
	private String content;
	
	
	private Timestamp time;
	private String tti;
	private int read_t;
	
	private String user_id;
	
	private Boolean publish;
	private String name;
	private String photo_u;
	private String txt;
	private List<categoty> categoty;
	
	
	private List<date_art> contents;
	
	private boolean delete_flag;
	

	

	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}


	public boolean isDelete_flag() {
		return delete_flag;
	}


	public void setDelete_flag(boolean delete_flag) {
		this.delete_flag = delete_flag;
	}


	public List<date_art> getContents() {
		return contents;
	}


	public void setContents(List<date_art> contents) {
		this.contents = contents;
	}


	public List<categoty> getCategoty() {
		return categoty;
	}


	public void setCategoty(List<categoty> categoty) {
		this.categoty = categoty;
	}


	public Boolean getPublish() {
		return publish;
	}


	public void setPublish(Boolean publish) {
		this.publish = publish;
	}


	
	
	public String getTxt() {
		return txt;
	}


	public void setTxt(String txt) {
		this.txt = txt;
	}


	
	
	
	public String getTti() {
		return tti;
	}


	public void setTti(String tti) {
		this.tti = tti;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getIntro() {
		return intro;
	}


	public void setIntro(String intro) {
		this.intro = intro;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Timestamp getTime() {
		return time;
	}


	public void setTime(Timestamp time) {
		this.time = time;
	}


	

	public int getRead_t() {
		return read_t;
	}


	public void setRead_t(int read_t) {
		this.read_t = read_t;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhoto_u() {
		return photo_u;
	}


	public void setPhoto_u(String photo_u) {
		this.photo_u = photo_u;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Article() {
		// TODO Auto-generated constructor stub
		this.contents=new ArrayList<>();
	}

	
}

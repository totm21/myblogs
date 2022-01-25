package po;

public class pairt {
	private String art_id;
	private String cate_id;
	
	
	public pairt(String u_id,String i_id)
	{
		this.cate_id=i_id;
		this.art_id=u_id;
	}


	public String getArt_id() {
		return art_id;
	}


	public void setArt_id(String art_id) {
		this.art_id = art_id;
	}


	public String getCate_id() {
		return cate_id;
	}


	public void setCate_id(String cate_id) {
		this.cate_id = cate_id;
	}
	

	

}

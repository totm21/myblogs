package po;

import java.io.Serializable;

public class date_art implements Serializable{
	
	
	private String art;
	private String image;
	
	
	
	
	
	public String getArt() {
		return art;
	}

	public void setArt(String art) {
		this.art = art;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public date_art() {
		// TODO Auto-generated constructor stub
	}
	
	public date_art(String art,String image) {
		// TODO Auto-generated constructor stub
		this.art=art;
		this.image=image;
	}

}

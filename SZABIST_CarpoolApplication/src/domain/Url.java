package domain;

public class Url implements java.io.Serializable{
	private Long UrlId;
	private String UrlScheme;

	public Long getUrlId(){
		return this.UrlId;
	}

	public String getUrlScheme(){
		return this.UrlScheme;
	}


	public void setUrlId(Long UrlId){
		this.UrlId = UrlId;
	}

	public void setUrlScheme(String UrlScheme){
		this.UrlScheme = UrlScheme;
	}

}
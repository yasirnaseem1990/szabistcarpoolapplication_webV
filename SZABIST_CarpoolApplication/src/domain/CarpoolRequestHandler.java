package domain;

public class CarpoolRequestHandler implements java.io.Serializable {
	private String name;
	private String sourcelocation;
	private int fk_booked_userid;
	private int requestsid;
	private String mobileno;
	
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public int getRequestsid() {
		return requestsid;
	}
	public void setRequestsid(int requestsid) {
		this.requestsid = requestsid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSourcelocation() {
		return sourcelocation;
	}
	public void setSourcelocation(String sourcelocation) {
		this.sourcelocation = sourcelocation;
	}
	public int getFk_booked_userid() {
		return fk_booked_userid;
	}
	public void setFk_booked_userid(int fk_booked_userid) {
		this.fk_booked_userid = fk_booked_userid;
	}
	
	

}

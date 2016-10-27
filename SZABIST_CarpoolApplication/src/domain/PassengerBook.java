package domain;

public class PassengerBook implements java.io.Serializable{
	private Long PassengerId;
	private String SourceLocation;
	private String OtherComment;
	private Long fkBookedUserId;

	public Long getPassengerId(){
		return this.PassengerId;
	}

	public String getSourceLocation(){
		return this.SourceLocation;
	}

	public String getOtherComment(){
		return this.OtherComment;
	}

	public Long getFkBookedUserId(){
		return this.fkBookedUserId;
	}


	public void setPassengerId(Long PassengerId){
		this.PassengerId = PassengerId;
	}

	public void setSourceLocation(String SourceLocation){
		this.SourceLocation = SourceLocation;
	}

	public void setOtherComment(String OtherComment){
		this.OtherComment = OtherComment;
	}

	public void setFkBookedUserId(Long fkBookedUserId){
		this.fkBookedUserId = fkBookedUserId;
	}

}
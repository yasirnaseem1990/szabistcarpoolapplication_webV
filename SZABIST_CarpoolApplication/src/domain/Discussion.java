package domain;

public class Discussion implements java.io.Serializable{
	private Long DiscussionId;
	private Long MessageFromFk;
	private Long MessageToFk;
	private java.util.Date DateTime;
	private String Text;
	private Long PostRideIdFk;

	public Long getDiscussionId(){
		return this.DiscussionId;
	}

	public Long getMessageFromFk(){
		return this.MessageFromFk;
	}

	public Long getMessageToFk(){
		return this.MessageToFk;
	}

	public java.util.Date getDateTime(){
		return this.DateTime;
	}

	public String getText(){
		return this.Text;
	}

	public Long getPostRideIdFk(){
		return this.PostRideIdFk;
	}


	public void setDiscussionId(Long DiscussionId){
		this.DiscussionId = DiscussionId;
	}

	public void setMessageFromFk(Long MessageFromFk){
		this.MessageFromFk = MessageFromFk;
	}

	public void setMessageToFk(Long MessageToFk){
		this.MessageToFk = MessageToFk;
	}

	public void setDateTime(java.util.Date DateTime){
		this.DateTime = DateTime;
	}

	public void setText(String Text){
		this.Text = Text;
	}

	public void setPostRideIdFk(Long PostRideIdFk){
		this.PostRideIdFk = PostRideIdFk;
	}

}
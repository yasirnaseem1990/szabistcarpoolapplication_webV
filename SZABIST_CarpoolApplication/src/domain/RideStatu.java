package domain;

public class RideStatu implements java.io.Serializable{
	private Long RideStatusId;
	private Long RideStatu;
	private Long fkRidePostId;
	private Long fkPassengerId;

	public Long getRideStatusId(){
		return this.RideStatusId;
	}

	public Long getRideStatu(){
		return this.RideStatu;
	}

	public Long getFkRidePostId(){
		return this.fkRidePostId;
	}

	public Long getFkPassengerId(){
		return this.fkPassengerId;
	}


	public void setRideStatusId(Long RideStatusId){
		this.RideStatusId = RideStatusId;
	}

	public void setRideStatu(Long RideStatu){
		this.RideStatu = RideStatu;
	}

	public void setFkRidePostId(Long fkRidePostId){
		this.fkRidePostId = fkRidePostId;
	}

	public void setFkPassengerId(Long fkPassengerId){
		this.fkPassengerId = fkPassengerId;
	}

}
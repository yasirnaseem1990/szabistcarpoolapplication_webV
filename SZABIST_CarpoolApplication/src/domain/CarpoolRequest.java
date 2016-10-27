package domain;

public class CarpoolRequest implements java.io.Serializable{
	private Long requestsId;
	private Long fkpassengerId;
	private Long fkpostRideId;
	public Long getRequestsId() {
		return requestsId;
	}
	public void setRequestsId(Long requestsId) {
		this.requestsId = requestsId;
	}
	public Long getFkpassengerId() {
		return fkpassengerId;
	}
	public void setFkpassengerId(Long fkpassengerId) {
		this.fkpassengerId = fkpassengerId;
	}
	public Long getFkpostRideId() {
		return fkpostRideId;
	}
	public void setFkpostRideId(Long fkpostRideId) {
		this.fkpostRideId = fkpostRideId;
	}

	

}
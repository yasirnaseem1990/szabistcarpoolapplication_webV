package domain;

public class BridgeTable implements java.io.Serializable{
	private Long BridgeId;
	private Long fkRoleId;
	private Long fkUrlID;

	public Long getBridgeId(){
		return this.BridgeId;
	}

	public Long getFkRoleId(){
		return this.fkRoleId;
	}

	public Long getFkUrlID(){
		return this.fkUrlID;
	}


	public void setBridgeId(Long BridgeId){
		this.BridgeId = BridgeId;
	}

	public void setFkRoleId(Long fkRoleId){
		this.fkRoleId = fkRoleId;
	}

	public void setFkUrlID(Long fkUrlID){
		this.fkUrlID = fkUrlID;
	}

}
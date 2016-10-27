package domain;

public class Role implements java.io.Serializable{
	private Long RoleId;
	private String RoleName;

	public Long getRoleId(){
		return this.RoleId;
	}

	public String getRoleName(){
		return this.RoleName;
	}


	public void setRoleId(Long RoleId){
		this.RoleId = RoleId;
	}

	public void setRoleName(String RoleName){
		this.RoleName = RoleName;
	}

}
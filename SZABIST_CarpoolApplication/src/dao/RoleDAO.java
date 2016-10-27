package dao;

import java.util.List;

import domain.Role;

public interface RoleDAO{
	Role load(final Long id) throws Exception;

	public int delete(final Long id) throws Exception;

	public int update(final Role data) throws Exception;

	public long insert(final Role data) throws Exception;


	public List<Role> queryAll()throws Exception;



	public List<Role> queryByRoleId(Long RoleId)throws Exception;
	public List<Role> queryByRoleName(String RoleName)throws Exception;

	}
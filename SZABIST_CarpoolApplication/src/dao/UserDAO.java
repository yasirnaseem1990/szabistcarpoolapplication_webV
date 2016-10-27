package dao;

import java.util.List;

import domain.User;

public interface UserDAO{
	User load(final Long id) throws Exception;

	public int delete(final Long id) throws Exception;

	public int update(final User data) throws Exception;

	public long insert(final User data) throws Exception;


	public List<User> queryAll()throws Exception;



	public List<User> queryByUserId(Long UserId)throws Exception;
	public List<User> queryByName(String Name)throws Exception;
	public List<User> queryByEmail(String Email)throws Exception;
	public List<User> queryByCNICNo(String CNICNo)throws Exception;
	public List<User> queryByMobileNo(String MobileNo)throws Exception;
	public List<User> queryByPassword(String Password)throws Exception;
	public List<User> queryByUniversityRegNo(String UniversityRegNo)throws Exception;
	public List<User> queryBySemester(String Semester)throws Exception;
	public List<User> queryByDepartment(String Department)throws Exception;
	public List<User> queryByRating(String Rating)throws Exception;
//	public List<User> queryByFkRoleId(Long fkRoleId)throws Exception;
	public List<User> queryByVerificationKey(String VerificationKey)throws Exception;
	public List<User> queryByVerificationStatu(Long VerificationStatu)throws Exception;
	public boolean AuthenticateUser(User user)throws Exception;
	public List<User> queryByUserPicture(String UserPicture)throws Exception;

	}
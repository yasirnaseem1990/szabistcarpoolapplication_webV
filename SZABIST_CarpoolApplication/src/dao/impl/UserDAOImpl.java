package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import sql.BaseDAO;
import sql.PreparedStatementSetter;
import sql.ResultSetExtractor;
import dao.UserDAO;
import domain.User;


public  class UserDAOImpl extends BaseDAO implements UserDAO{
	public static final sql.DAOCache cache = new sql.DAOCache();
	public static int usr_fid_for_login;
	public static int userId;
	public static String userName;
	private Connection connection;
	public sql.DAOCache getCache() {
		return cache;
	}

	protected void clearCacheOnInsert(User data){}

	public User load(final Long id) throws Exception{
		String sql = "SELECT * FROM user WHERE id=?";
		return (User) getRow(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, id);
			}
		}, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
			User row  = new User();
				row.setUserid(rs.getLong("UserId"));
				row.setName(rs.getString("Name"));
				row.setEmail(rs.getString("Email"));
				row.setCnicno(rs.getString("CNIC_No"));
				row.setMobileno(rs.getString("Mobile_No"));
				row.setPassword(rs.getString("Password"));
				row.setUniversityregno(rs.getString("University_Reg_No"));
				row.setSemester(rs.getString("Semester"));
				row.setDepartment(rs.getString("Department"));
				row.setRating(rs.getString("Rating"));
//				row.setFkRoleId(rs.getInt("fk_RoleId"));
				row.setVerificationKey(rs.getString("Verification_key"));
				row.setVerificationStatu(rs.getLong("Verification_status"));
				row.setUserpicture(rs.getBlob("UserPicture"));
				return row;
			}
	});
	}

	public int delete(final Long id) throws Exception{
		cache.clear(id);
		String sql = "DELETE FROM user WHERE id=?";
		return executeUpdate(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, id);
			}
		});
	}

	public int update(final User data) throws Exception{
		cache.clear(data.getUserid());
		String sql = "UPDATE user SET Name = ?, Email = ?, CNIC_No = ?, Mobile_No = ?, Password = ?, University_Reg_No = ?, Semester = ?, Department = ?, Rating = ?, Verification_key = ?, Verification_status = ? WHERE id=?";
		return executeUpdate(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setString(1, data.getName());
				ps.setString(2, data.getEmail());
				ps.setString(3, data.getCnicno());
				ps.setString(4, data.getMobileno());
				ps.setString(5, data.getPassword());
				ps.setString(6, data.getUniversityregno());
				ps.setString(7, data.getSemester());
				ps.setString(8, data.getDepartment());
				ps.setString(9, data.getRating());
//				ps.setLong(10, data.getFkRoleId());
				ps.setString(10, data.getVerificationKey());
				ps.setLong(11, data.getVerificationStatu());
				ps.setLong(12, data.getUserid());
			}
	});
	}

	public ResultSetExtractor getDefaultExtractor() throws Exception{
		return new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
			User row  = new User();
				row.setUserid(rs.getLong("UserId"));
				row.setName(rs.getString("Name"));
				row.setEmail(rs.getString("Email"));
				row.setCnicno(rs.getString("CNIC_No"));
				row.setMobileno(rs.getString("Mobile_No"));
				row.setPassword(rs.getString("Password"));
				row.setUniversityregno(rs.getString("University_Reg_No"));
				row.setSemester(rs.getString("Semester"));
				row.setDepartment(rs.getString("Department"));
				row.setRating(rs.getString("Rating"));
//				row.setFkRoleId(rs.getInt("fk_RoleId"));
				row.setVerificationKey(rs.getString("Verification_key"));
				row.setVerificationStatu(rs.getLong("Verification_status"));
				return row;
			}
	};
	}

	public long insert(final User data) throws Exception{
		clearCacheOnInsert(data);
		String sql = "INSERT INTO user ( Name, Email, CNIC_No, Mobile_No, Password, University_Reg_No, Semester, Department, Rating,Verification_key, Verification_status,UserPicture) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
		long id = executeInsert(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setString(1, data.getName());
				ps.setString(2, data.getEmail());
				ps.setString(3, data.getCnicno());
				ps.setString(4, data.getMobileno());
				ps.setString(5, data.getPassword());
				ps.setString(6, data.getUniversityregno());
				ps.setString(7, data.getSemester());
				ps.setString(8, data.getDepartment());
				ps.setString(9, data.getRating());
//				ps.setLong(10, data.getFkRoleId());
				ps.setString(10, data.getVerificationKey());
				ps.setLong(11, data.getVerificationStatu());
				ps.setBlob(12, data.getUserpicture());
			}
		});
		data.setUserid(id);
		return id;
	}

	public List<User> queryAll()throws Exception{
		String sql = "SELECT * FROM user";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				User row = new User();
				row.setUserid(rs.getLong("UserId"));
				row.setName(rs.getString("Name"));
				row.setEmail(rs.getString("Email"));
				row.setCnicno(rs.getString("CNIC_No"));
				row.setMobileno(rs.getString("Mobile_No"));
				row.setPassword(rs.getString("Password"));
				row.setUniversityregno(rs.getString("University_Reg_No"));
				row.setSemester(rs.getString("Semester"));
				row.setDepartment(rs.getString("Department"));
				row.setRating(rs.getString("Rating"));
//				row.setFkRoleId(rs.getInt("fk_RoleId"));
				row.setVerificationKey(rs.getString("Verification_key"));
				row.setVerificationStatu(rs.getLong("Verification_status"));
				row.setUserpicture(rs.getBlob("UserPicture"));
				return row;
			}
	});
	}

	 public ResultSetExtractor getListResultSetExtractor(){
		return new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				User row = new User();
				row.setUserid(rs.getLong("UserId"));
				row.setName(rs.getString("Name"));
				row.setEmail(rs.getString("Email"));
				row.setCnicno(rs.getString("CNIC_No"));
				row.setMobileno(rs.getString("Mobile_No"));
				row.setPassword(rs.getString("Password"));
				row.setUniversityregno(rs.getString("University_Reg_No"));
				row.setSemester(rs.getString("Semester"));
				row.setDepartment(rs.getString("Department"));
				row.setRating(rs.getString("Rating"));
//				row.setFkRoleId(rs.getInt("fk_RoleId"));
				row.setVerificationKey(rs.getString("Verification_key"));
				row.setVerificationStatu(rs.getLong("Verification_status"));
				row.setUserpicture(rs.getBlob("UserPicture"));
				return row;
			}
	};
	}

	public List<User> queryByUserId(Long UserId)throws Exception{
		String sql = "SELECT * FROM user WHERE UserId='"+UserId+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				User row = new User();
				row.setUserid(rs.getLong("UserId"));
				row.setName(rs.getString("Name"));
				row.setEmail(rs.getString("Email"));
				row.setCnicno(rs.getString("CNIC_No"));
				row.setMobileno(rs.getString("Mobile_No"));
				row.setPassword(rs.getString("Password"));
				row.setUniversityregno(rs.getString("University_Reg_No"));
				row.setSemester(rs.getString("Semester"));
				row.setDepartment(rs.getString("Department"));
				row.setRating(rs.getString("Rating"));
//				row.setFkRoleId(rs.getInt("fk_RoleId"));
				row.setVerificationKey(rs.getString("Verification_key"));
				row.setVerificationStatu(rs.getLong("Verification_status"));
				row.setUserpicture(rs.getBlob("UserPicture"));
				return row;
			}
	});
	}
	public List<User> queryByName(String Name)throws Exception{
		String sql = "SELECT * FROM user WHERE Name='"+Name+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				User row = new User();
				row.setUserid(rs.getLong("UserId"));
				row.setName(rs.getString("Name"));
				row.setEmail(rs.getString("Email"));
				row.setCnicno(rs.getString("CNIC_No"));
				row.setMobileno(rs.getString("Mobile_No"));
				row.setPassword(rs.getString("Password"));
				row.setUniversityregno(rs.getString("University_Reg_No"));
				row.setSemester(rs.getString("Semester"));
				row.setDepartment(rs.getString("Department"));
				row.setRating(rs.getString("Rating"));
//				row.setFkRoleId(rs.getInt("fk_RoleId"));
				row.setVerificationKey(rs.getString("Verification_key"));
				row.setVerificationStatu(rs.getLong("Verification_status"));
				row.setUserpicture(rs.getBlob("UserPicture"));
				return row;
			}
	});
	}
	public List<User> queryByEmail(String Email)throws Exception{
		String sql = "SELECT * FROM user WHERE Email='"+Email+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				User row = new User();
				row.setUserid(rs.getLong("UserId"));
				row.setName(rs.getString("Name"));
				row.setEmail(rs.getString("Email"));
				row.setCnicno(rs.getString("CNIC_No"));
				row.setMobileno(rs.getString("Mobile_No"));
				row.setPassword(rs.getString("Password"));
				row.setUniversityregno(rs.getString("University_Reg_No"));
				row.setSemester(rs.getString("Semester"));
				row.setDepartment(rs.getString("Department"));
				row.setRating(rs.getString("Rating"));
//				row.setFkRoleId(rs.getInt("fk_RoleId"));
				row.setVerificationKey(rs.getString("Verification_key"));
				row.setVerificationStatu(rs.getLong("Verification_status"));
				row.setUserpicture(rs.getBlob("UserPicture"));
				return row;
			}
	});
	}
	public List<User> queryByCNICNo(String CNICNo)throws Exception{
		String sql = "SELECT * FROM user WHERE CNIC_No='"+CNICNo+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				User row = new User();
				row.setUserid(rs.getLong("UserId"));
				row.setName(rs.getString("Name"));
				row.setEmail(rs.getString("Email"));
				row.setCnicno(rs.getString("CNIC_No"));
				row.setMobileno(rs.getString("Mobile_No"));
				row.setPassword(rs.getString("Password"));
				row.setUniversityregno(rs.getString("University_Reg_No"));
				row.setSemester(rs.getString("Semester"));
				row.setDepartment(rs.getString("Department"));
				row.setRating(rs.getString("Rating"));
//				row.setFkRoleId(rs.getInt("fk_RoleId"));
				row.setVerificationKey(rs.getString("Verification_key"));
				row.setVerificationStatu(rs.getLong("Verification_status"));
				row.setUserpicture(rs.getBlob("UserPicture"));
				return row;
			}
	});
	}
	public List<User> queryByMobileNo(String MobileNo)throws Exception{
		String sql = "SELECT * FROM user WHERE Mobile_No='"+MobileNo+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				User row = new User();
				row.setUserid(rs.getLong("UserId"));
				row.setName(rs.getString("Name"));
				row.setEmail(rs.getString("Email"));
				row.setCnicno(rs.getString("CNIC_No"));
				row.setMobileno(rs.getString("Mobile_No"));
				row.setPassword(rs.getString("Password"));
				row.setUniversityregno(rs.getString("University_Reg_No"));
				row.setSemester(rs.getString("Semester"));
				row.setDepartment(rs.getString("Department"));
				row.setRating(rs.getString("Rating"));
//				row.setFkRoleId(rs.getInt("fk_RoleId"));
				row.setVerificationKey(rs.getString("Verification_key"));
				row.setVerificationStatu(rs.getLong("Verification_status"));
				row.setUserpicture(rs.getBlob("UserPicture"));
				return row;
			}
	});
	}
	public List<User> queryByPassword(String Password)throws Exception{
		String sql = "SELECT * FROM user WHERE Password='"+Password+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				User row = new User();
				row.setUserid(rs.getLong("UserId"));
				row.setName(rs.getString("Name"));
				row.setEmail(rs.getString("Email"));
				row.setCnicno(rs.getString("CNIC_No"));
				row.setMobileno(rs.getString("Mobile_No"));
				row.setPassword(rs.getString("Password"));
				row.setUniversityregno(rs.getString("University_Reg_No"));
				row.setSemester(rs.getString("Semester"));
				row.setDepartment(rs.getString("Department"));
				row.setRating(rs.getString("Rating"));
//				row.setFkRoleId(rs.getInt("fk_RoleId"));
				row.setVerificationKey(rs.getString("Verification_key"));
				row.setVerificationStatu(rs.getLong("Verification_status"));
				row.setUserpicture(rs.getBlob("UserPicture"));
				return row;
			}
	});
	}
	public List<User> queryByUniversityRegNo(String UniversityRegNo)throws Exception{
		String sql = "SELECT * FROM user WHERE University_Reg_No='"+UniversityRegNo+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				User row = new User();
				row.setUserid(rs.getLong("UserId"));
				row.setName(rs.getString("Name"));
				row.setEmail(rs.getString("Email"));
				row.setCnicno(rs.getString("CNIC_No"));
				row.setMobileno(rs.getString("Mobile_No"));
				row.setPassword(rs.getString("Password"));
				row.setUniversityregno(rs.getString("University_Reg_No"));
				row.setSemester(rs.getString("Semester"));
				row.setDepartment(rs.getString("Department"));
				row.setRating(rs.getString("Rating"));
//				row.setFkRoleId(rs.getInt("fk_RoleId"));
				row.setVerificationKey(rs.getString("Verification_key"));
				row.setVerificationStatu(rs.getLong("Verification_status"));
				row.setUserpicture(rs.getBlob("UserPicture"));
				return row;
			}
	});
	}
	public List<User> queryBySemester(String Semester)throws Exception{
		String sql = "SELECT * FROM user WHERE Semester='"+Semester+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				User row = new User();
				row.setUserid(rs.getLong("UserId"));
				row.setName(rs.getString("Name"));
				row.setEmail(rs.getString("Email"));
				row.setCnicno(rs.getString("CNIC_No"));
				row.setMobileno(rs.getString("Mobile_No"));
				row.setPassword(rs.getString("Password"));
				row.setUniversityregno(rs.getString("University_Reg_No"));
				row.setSemester(rs.getString("Semester"));
				row.setDepartment(rs.getString("Department"));
				row.setRating(rs.getString("Rating"));
//				row.setFkRoleId(rs.getInt("fk_RoleId"));
				row.setVerificationKey(rs.getString("Verification_key"));
				row.setVerificationStatu(rs.getLong("Verification_status"));
				row.setUserpicture(rs.getBlob("UserPicture"));
				return row;
			}
	});
	}
	public List<User> queryByDepartment(String Department)throws Exception{
		String sql = "SELECT * FROM user WHERE Department='"+Department+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				User row = new User();
				row.setUserid(rs.getLong("UserId"));
				row.setName(rs.getString("Name"));
				row.setEmail(rs.getString("Email"));
				row.setCnicno(rs.getString("CNIC_No"));
				row.setMobileno(rs.getString("Mobile_No"));
				row.setPassword(rs.getString("Password"));
				row.setUniversityregno(rs.getString("University_Reg_No"));
				row.setSemester(rs.getString("Semester"));
				row.setDepartment(rs.getString("Department"));
				row.setRating(rs.getString("Rating"));
//				row.setFkRoleId(rs.getInt("fk_RoleId"));
				row.setVerificationKey(rs.getString("Verification_key"));
				row.setVerificationStatu(rs.getLong("Verification_status"));
				row.setUserpicture(rs.getBlob("UserPicture"));
				return row;
			}
	});
	}
	public List<User> queryByRating(String Rating)throws Exception{
		String sql = "SELECT * FROM user WHERE Rating='"+Rating+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				User row = new User();
				row.setUserid(rs.getLong("UserId"));
				row.setName(rs.getString("Name"));
				row.setEmail(rs.getString("Email"));
				row.setCnicno(rs.getString("CNIC_No"));
				row.setMobileno(rs.getString("Mobile_No"));
				row.setPassword(rs.getString("Password"));
				row.setUniversityregno(rs.getString("University_Reg_No"));
				row.setSemester(rs.getString("Semester"));
				row.setDepartment(rs.getString("Department"));
				row.setRating(rs.getString("Rating"));
//				row.setFkRoleId(rs.getInt("fk_RoleId"));
				row.setVerificationKey(rs.getString("Verification_key"));
				row.setVerificationStatu(rs.getLong("Verification_status"));
				row.setUserpicture(rs.getBlob("UserPicture"));
				return row;
			}
	});
	}

	public List<User> queryByVerificationKey(String VerificationKey)throws Exception{
		String sql = "SELECT * FROM user WHERE Verification_key='"+VerificationKey+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				User row = new User();
				row.setUserid(rs.getLong("UserId"));
				row.setName(rs.getString("Name"));
				row.setEmail(rs.getString("Email"));
				row.setCnicno(rs.getString("CNIC_No"));
				row.setMobileno(rs.getString("Mobile_No"));
				row.setPassword(rs.getString("Password"));
				row.setUniversityregno(rs.getString("University_Reg_No"));
				row.setSemester(rs.getString("Semester"));
				row.setDepartment(rs.getString("Department"));
				row.setRating(rs.getString("Rating"));
//				row.setFkRoleId(rs.getInt("fk_RoleId"));
				row.setVerificationKey(rs.getString("Verification_key"));
				row.setVerificationStatu(rs.getLong("Verification_status"));
				row.setUserpicture(rs.getBlob("UserPicture"));
				return row;
			}
	});
	}
	public List<User> queryByVerificationStatu(Long VerificationStatu)throws Exception{
		String sql = "SELECT * FROM user WHERE Verification_status='"+VerificationStatu+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				User row = new User();
				row.setUserid(rs.getLong("UserId"));
				row.setName(rs.getString("Name"));
				row.setEmail(rs.getString("Email"));
				row.setCnicno(rs.getString("CNIC_No"));
				row.setMobileno(rs.getString("Mobile_No"));
				row.setPassword(rs.getString("Password"));
				row.setUniversityregno(rs.getString("University_Reg_No"));
				row.setSemester(rs.getString("Semester"));
				row.setDepartment(rs.getString("Department"));
				row.setRating(rs.getString("Rating"));
//				row.setFkRoleId(rs.getInt("fk_RoleId"));
				row.setVerificationKey(rs.getString("Verification_key"));
				row.setVerificationStatu(rs.getLong("Verification_status"));
				row.setUserpicture(rs.getBlob("UserPicture"));
				return row;
			}
	});
	}

	public boolean AuthenticateUser(User user) throws Exception {
		System.out.println("Authenticating User Using Email:"+user.getEmail()+" And Password :"+user.getPassword());
		boolean flag = false;
		User usr = null;
		usr = loadUser(user);
		if(usr!=null){
			flag = true;
			System.out.println("User Is Exits True");
		}else{
			flag = false;
			System.out.println("User Is not Exited False");
		}
		return flag;
	}
	
	public User loadUser(final User user) throws Exception{
		String sql = "SELECT * FROM user WHERE Email= ? and Password= ?";
		System.out.println("Inside LoadUser Method Printing SQL Query :"+sql);
		return (User) getRow(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setString(1, user.getEmail());
				ps.setString(2, user.getPassword());
			}
		}, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
			User row  = new User();
				row.setUserid(rs.getLong("UserId"));
				System.out.println("User Id :" +rs.getLong("UserId"));
				userId = (int) rs.getLong("UserId");
				System.out.println("THIS IS USERID FOR POSTMESSAGE :"+userId);
				row.setName(rs.getString("Name"));
				userName = rs.getString("Name");
				System.out.println("Inside Load User Method Getting UserName For Passenger_Book :"+userName);
				row.setEmail(rs.getString("Email"));
				System.out.println("User Email :"+rs.getString("Email"));
//				row.setCNICNo(rs.getString("CNIC_No"));
//				row.setMobileNo(rs.getString("Mobile_No"));
				row.setPassword(rs.getString("Password"));
				System.out.println("User Password :"+rs.getString("Password"));
//				row.setUniversityRegNo(rs.getString("University_Reg_No"));
//				row.setSemester(rs.getString("Semester"));
//				row.setDepartment(rs.getString("Department"));
//				row.setRating(rs.getString("Rating"));
//				row.setFkRoleId(rs.getInt("fk_RoleId"));
//				System.out.println("User Fk_RoleId :"+rs.getInt("fk_RoleId"));
//				usr_fid_for_login = rs.getInt("fk_RoleId");
//				System.out.println("User FK_ID For Login :"+usr_fid_for_login);
//				row.setVerificationKey(rs.getString("Verification_key"));
//				row.setVerificationStatu(rs.getLong("Verification_status"));
				return row;
			}
	});
	}
	public List<User> queryByUserPicture(String UserPicture)throws Exception{
		String sql = "SELECT * FROM user WHERE UserPicture='"+UserPicture+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				User row = new User();
				row.setUserid(rs.getLong("UserId"));
				row.setName(rs.getString("Name"));
				row.setEmail(rs.getString("Email"));
				row.setCnicno(rs.getString("CNIC_No"));
				row.setMobileno(rs.getString("Mobile_No"));
				row.setPassword(rs.getString("Password"));
				row.setUniversityregno(rs.getString("University_Reg_No"));
				row.setSemester(rs.getString("Semester"));
				row.setDepartment(rs.getString("Department"));
				row.setRating(rs.getString("Rating"));
				row.setVerificationKey(rs.getString("Verification_key"));
				row.setVerificationStatu(rs.getLong("Verification_status"));
				row.setUserpicture(rs.getBlob("UserPicture"));
				return row;
			}
	});
	}
	
	public User getpicturebyId(int userId){
		try {

	           //  String driver = context.getInitParameter("jdbc.driver");;
	             String url = "jdbc:mysql://localhost:3306/carpool_db";
	    		 String user = "root";
	    		 String password = "";
	    			Class.forName("com.mysql.jdbc.Driver");
	             connection = (Connection) DriverManager.getConnection(url, user, password);
	             System.out.println("got connection");
	         } catch (ClassNotFoundException e) {
	             e.printStackTrace();
	         } catch (SQLException e) {
	             e.printStackTrace();
	         }
		System.out.println(userId);
		User user = new User();
//		Blob b=null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user where UserId=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				user.setUserpicture(rs.getBlob("UserPicture"));
			} else {
				System.out.println("Here not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}


	}
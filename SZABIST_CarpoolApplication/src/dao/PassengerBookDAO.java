package dao;

import java.util.List;

import domain.PassengerBook;

public interface PassengerBookDAO{
	PassengerBook load(final Long id) throws Exception;

	public int delete(final Long id) throws Exception;

	public int update(final PassengerBook data) throws Exception;

	public long insert(final PassengerBook data) throws Exception;


	public List<PassengerBook> queryAll()throws Exception;



	public List<PassengerBook> queryByPassengerId(Long PassengerId)throws Exception;
	public List<PassengerBook> queryBySourceLocation(String SourceLocation)throws Exception;
	public List<PassengerBook> queryByOtherComment(String OtherComment)throws Exception;
	public List<PassengerBook> queryByFkBookedUserId(Long fkBookedUserId)throws Exception;
	

	}
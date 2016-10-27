package dao;

import java.util.Date;
import java.util.List;

import domain.Discussion;

public interface DiscussionDAO{
	Discussion load(final Long id) throws Exception;

	public int delete(final Long id) throws Exception;

	public int update(final Discussion data) throws Exception;

	public long insert(final Discussion data) throws Exception;


	public List<Discussion> queryAll()throws Exception;



	public List<Discussion> queryByDiscussionId(Long DiscussionId)throws Exception;
	public List<Discussion> queryByMessageFromFk(Long MessageFromFk)throws Exception;
	public List<Discussion> queryByMessageToFk(Long MessageToFk)throws Exception;
	public List<Discussion> queryByDateTime(Date DateTime)throws Exception;
	public List<Discussion> queryByText(String Text)throws Exception;
	public List<Discussion> queryByPostRideIdFk(Long PostRideIdFk)throws Exception;

	}
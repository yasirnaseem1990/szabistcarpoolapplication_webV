package dao;

import java.util.Date;
import java.util.List;

import domain.PostRide;

public interface PostRideDAO{
	PostRide load(final Long id) throws Exception;

	public int delete(final Long id) throws Exception;

	public int update(final PostRide data) throws Exception;

	public long insert(final PostRide data) throws Exception;


	public List<PostRide> queryAll()throws Exception;



	public List<PostRide> queryByPostRideId(Long PostRideId)throws Exception;
	public List<PostRide> queryByPostRideTitle(String PostRideTitle)throws Exception;
	public List<PostRide> queryByPostRideDescription(String PostRideDescription)throws Exception;
	public List<PostRide> queryBySourceLocation(String SourceLocation)throws Exception;
	public List<PostRide> queryByDestinationLocation(String DestinationLocation)throws Exception;
	public List<PostRide> queryByDate(Date Date)throws Exception;
	public List<PostRide> queryByFair(String Fair)throws Exception;
	public List<PostRide> queryByTotalSeat(String TotalSeat)throws Exception;
	public List<PostRide> queryByAvailableSeat(String AvailableSeat)throws Exception;
	public List<PostRide> queryByCarName(String CarName)throws Exception;
	public List<PostRide> queryByCarModel(String CarModel)throws Exception;
	public List<PostRide> queryByFkUserId(Long fkUserId)throws Exception;
	public List<PostRide> searchRide(PostRide post)throws Exception;
//	public List<PostRide> queryByFkCarpoolRequestsID(Long fkCarpoolRequestsID)throws Exception;

	}
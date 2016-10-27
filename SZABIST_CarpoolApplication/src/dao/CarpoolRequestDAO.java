package dao;

import java.util.List;

import domain.CarpoolRequest;

public interface CarpoolRequestDAO{
	CarpoolRequest load(final Long id) throws Exception;

	public int delete(final Long id) throws Exception;

	public int update(final CarpoolRequest data) throws Exception;

	public long insert(final CarpoolRequest data) throws Exception;


	public List<CarpoolRequest> queryAll()throws Exception;



	public List<CarpoolRequest> queryByRequestsId(Long RequestsId)throws Exception;
	public List<CarpoolRequest> queryByFkPassengerID(Long fkPassengerID)throws Exception;
	public List<CarpoolRequest> queryByFkPostRideID(Long fkPostRideID)throws Exception;
	public List<CarpoolRequest> queryAllbyID(final long Id)throws Exception;
	public List<CarpoolRequest> queryByUserId(Long UserId)throws Exception;

	}
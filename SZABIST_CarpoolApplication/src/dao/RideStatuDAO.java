package dao;

import java.util.List;
import domain.RideStatu;

public interface RideStatuDAO{
	RideStatu load(final Long id) throws Exception;

	public int delete(final Long id) throws Exception;

	public int update(final RideStatu data) throws Exception;

	public long insert(final RideStatu data) throws Exception;


	public List<RideStatu> queryAll()throws Exception;



	public List<RideStatu> queryByRideStatusId(Long RideStatusId)throws Exception;
	public List<RideStatu> queryByRideStatu(Long RideStatu)throws Exception;
	public List<RideStatu> queryByFkRidePostId(Long fkRidePostId)throws Exception;
	public List<RideStatu> queryByFkPassengerId(Long fkPassengerId)throws Exception;

	}
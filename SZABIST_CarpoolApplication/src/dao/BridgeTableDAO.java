package dao;

import java.util.List;

import domain.BridgeTable;

public interface BridgeTableDAO{
	BridgeTable load(final Long id) throws Exception;

	public int delete(final Long id) throws Exception;

	public int update(final BridgeTable data) throws Exception;

	public long insert(final BridgeTable data) throws Exception;


	public List<BridgeTable> queryAll()throws Exception;



	public List<BridgeTable> queryByBridgeId(Long BridgeId)throws Exception;
	public List<BridgeTable> queryByFkRoleId(Long fkRoleId)throws Exception;
	public List<BridgeTable> queryByFkUrlID(Long fkUrlID)throws Exception;
	boolean checkPermission(int uid, int urid);

	}
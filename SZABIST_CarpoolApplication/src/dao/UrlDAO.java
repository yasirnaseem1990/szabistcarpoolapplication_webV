package dao;

import java.util.List;

import domain.Url;

public interface UrlDAO{
	Url load(final Long id) throws Exception;

	public int delete(final Long id) throws Exception;

	public int update(final Url data) throws Exception;

	public long insert(final Url data) throws Exception;


	public List<Url> queryAll()throws Exception;



	public List<Url> queryByUrlId(Long UrlId)throws Exception;
	public List<Url> queryByUrlScheme(String UrlScheme)throws Exception;

	}
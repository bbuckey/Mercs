package org.merc.dao;

import org.merc.dao.BaseDao;

import java.util.Date;

public class PlayerDao extends BaseDao{
	
	private int id;
	private int level;
	private int exp;
	private int gold;
	private int cash;
	private Date lastcashtime;
	
	public PlayerDao() throws Exception{
		super();
	}
	

}

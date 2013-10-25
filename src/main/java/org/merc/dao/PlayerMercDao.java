package org.merc.dao;

import org.merc.dao.BaseDao;

public class PlayerMercDao extends BaseDao{

	private int id;
	private int player_id;
	private int mercs_id;
	private int weapons_id;
	private int playerweapons_id;
	private String mercname;
	private int hp;
	private int atk;
	private int def;
	private int mlevel;
	
	public PlayerMercDao() throws Exception{
		super();
	}
	
	
}

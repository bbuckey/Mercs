package org.merc.dao;

import org.merc.base.PersonPlayer;
import org.merc.dao.BaseDao;

import com.almworks.sqlite4java.SQLiteStatement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlayerDao extends BaseDao{
	
	private int id;
	private int level;
	private String playername;
	private int exp;
	private int gold;
	private int cash;
	private Date lastcashtime;
	
	public PlayerDao() throws Exception{
		super();
	}
	
	public void insertRecord(int plevel, String bfid, int hp, int atk,int def, Date d) throws Exception {
		String s = String.format("insert into Player(level,playername,hp,atk,def,lastcashtime) "
				+ "values(%d, \"%s\", %d, %d, %d, %tD);",plevel,bfid,hp,atk,def,d);

		super.runDDL(s);
	}
	
	
	public List getAllPlayers() throws Exception{
		List dbobjects = new ArrayList();
		String sql = "Select * from Player";
		SQLiteStatement statement = super.runSelectStatement(sql);
		while(true){
			if(statement.step()){
				PersonPlayer mercDao = new PersonPlayer();
				mercDao.setID(statement.columnInt(0));
				mercDao.setCash(statement.columnInt(5));
				mercDao.setPlayerName(statement.columnString(2));
				mercDao.setLevel(statement.columnInt(1));
				mercDao.setExp(statement.columnInt(3));
				mercDao.setGold(statement.columnInt(4));
				mercDao.setLastCashTime(new Date(Date.parse(statement.columnString(6))));
				dbobjects.add(mercDao);
			} else {
				break;
			}
		}
		
		return dbobjects;
	}
	

}

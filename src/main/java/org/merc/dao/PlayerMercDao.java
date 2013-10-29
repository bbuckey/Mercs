package org.merc.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.merc.base.PersonPlayerMercs;
import org.merc.dao.BaseDao;

import com.almworks.sqlite4java.SQLiteStatement;

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
	
	public void insertRecord( String mercname, int pid, int mid, int wid, int pwid, int hp, int atk,int def, int mlevel) throws Exception {
		String s = String.format("insert into PlayerMercs(player_id,mercs_id,weapons_id,PlayerWeapons_id,mercname,hp,atk,def,mlevel) "
				+ "values(%d, %d, %d, %d, \"%s\", %d, %d, %d, %tD);",pid,mid, wid, pwid, mercname,hp,atk,def,mlevel);

		super.runDDL(s);
	}
	
	
	public List getAllPlayerMercs() throws Exception{
		List dbobjects = new ArrayList();
		String sql = "Select * from PlayerMercs";
		SQLiteStatement statement = super.runSelectStatement(sql);
		while(true){
			if(statement.step()){
				PersonPlayerMercs mercDao = new PersonPlayerMercs();
				mercDao.setID(statement.columnInt(0));
				mercDao.setMercID(statement.columnInt(2));
				mercDao.setPlayerID(statement.columnInt(1));
				mercDao.setWeaponsID(statement.columnInt(3));
				mercDao.setPlayerWeaponsID(statement.columnInt(4));
				mercDao.setMercName(statement.columnString(5));
				mercDao.setATK(statement.columnInt(6));
				mercDao.setDEF(statement.columnInt(7));
				mercDao.setHP(statement.columnInt(8));
				mercDao.setMLevel(statement.columnInt(9));
				dbobjects.add(mercDao);
			} else {
				break;
			}
		}
		
		return dbobjects;
	}
	
}

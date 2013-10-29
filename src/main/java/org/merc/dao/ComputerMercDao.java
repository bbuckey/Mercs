package org.merc.dao;

import java.util.ArrayList;
import java.util.List;

import org.merc.base.ComputerPlayer;
import org.merc.dao.BaseDao;

import com.almworks.sqlite4java.SQLiteStatement;

public class ComputerMercDao extends BaseDao{

	private int id;
	private int battlefield_id;
	private int hp;
	private int atk;
	private int def;
	private int exp;
	private int gold;
	private String Drop_ids;
	private int holdAtk;

	public ComputerMercDao() throws Exception{
		super();
	}
	
	public void insertRecord(int bfid, int hp, int atk,int def, int exp, int gold, String dropids, int holdAtks) throws Exception {
		String s = String.format("insert into ComputerMercs(battlefield_id,hp,atk,def,exp,gold,drop_ids,holdatk)"
				+ "values(%d, %d, %d, %d, %d, %d, \"%s\", %d)",bfid,hp,atk,def,exp,gold,dropids,holdAtks);
		super.runDDL(s);
	}
	
	
	public List getAllComputerMercs() throws Exception{
		List dbobjects = new ArrayList();
		String sql = "Select * from ComputerMercs";
		SQLiteStatement statement = super.runSelectStatement(sql);
		while(true){
			if(statement.step()){
				ComputerPlayer mercDao = new ComputerPlayer();
				mercDao.setID(statement.columnInt(0));
				mercDao.setBattleFieldID(statement.columnInt(1));
				mercDao.setHP(statement.columnInt(2));
				mercDao.setATK(statement.columnInt(3));
				mercDao.setDEF(statement.columnInt(4));
				mercDao.setExp(statement.columnInt(5));
				mercDao.setGold(statement.columnInt(6));
				mercDao.setDropIDs(statement.columnString(7));
				mercDao.setHoldATK(statement.columnInt(8));
				dbobjects.add(mercDao);
			} else {
				break;
			}
		}
		
		return dbobjects;
	}
	
	
}

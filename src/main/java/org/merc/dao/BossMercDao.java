package org.merc.dao;

import java.util.ArrayList;
import java.util.List;

import org.merc.base.BossMerc;
import org.merc.dao.BaseDao;

import com.almworks.sqlite4java.SQLiteStatement;

public class BossMercDao extends BaseDao{

	private int holdAtk;
	private int id;
	private int battlefield_id;
	private int hp;
	private int atk;
	private int def;
	private int exp;
	private int gold;
	private String Drop_ids;
	
	public BossMercDao() throws Exception{
		super();
	}
	
	
	public void insertRecord(int mercid, int weapid, int bfid) throws Exception {
		String s = String.format("insert into BattleFieldDrops(mercs_id, weapons_id,battlefield_id)values(%f, %f, %f)",mercid,weapid,bfid);
		super.runDDL(s);
	}
	
	
	public List getAllBattleFields() throws Exception{
		List dbobjects = new ArrayList();
		String sql = "Select * from BattleFieldDrops";
		SQLiteStatement statement = super.runSelectStatement(sql);
		while(true){
			if(statement.step()){
				BossMerc mercDao = new BossMerc();
				mercDao.setID(statement.columnInt(1));
				mercDao.setBattleFieldID(statement.columnInt(2));
				mercDao.setHP(statement.columnInt(3));
				mercDao.setATK(statement.columnInt(4));
				mercDao.setDEF(statement.columnInt(5));
				mercDao.setExp(statement.columnInt(6));
				mercDao.setGold(statement.columnInt(7));
				mercDao.setDropIDs(statement.columnString(8));
				mercDao.setHoldATK(statement.columnInt(0));
				dbobjects.add(mercDao);
			} else {
				break;
			}
		}
		
		return dbobjects;
	}
	
}

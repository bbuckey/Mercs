package org.merc.dao;

import java.util.ArrayList;
import java.util.List;

import org.merc.base.BattleFieldDrops;
import org.merc.dao.BaseDao;

import com.almworks.sqlite4java.SQLiteStatement;

public class BattleFieldDropsDao extends BaseDao{

	private int id;
	private int mercs_id;
	private int weapons_id;
	private int battlefield_id;
	
	public BattleFieldDropsDao() throws Exception{
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
				BattleFieldDrops mercDao = new BattleFieldDrops();
				mercDao.setID(statement.columnInt(0));
				mercDao.setMercID(statement.columnInt(1));
				mercDao.setWeaponsID(statement.columnInt(2));
				mercDao.setBattleFieldID(statement.columnInt(3));
				dbobjects.add(mercDao);
			} else {
				break;
			}
		}
		
		return dbobjects;
	}
}

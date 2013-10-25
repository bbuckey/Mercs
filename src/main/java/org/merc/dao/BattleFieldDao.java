package org.merc.dao;

import java.util.ArrayList;
import java.util.List;

import org.merc.base.BattleField;
import org.merc.dao.BaseDao;

import com.almworks.sqlite4java.SQLiteStatement;

public class BattleFieldDao extends BaseDao {
	private int id;
	private int level_number;
	
	public BattleFieldDao() throws Exception{
		super();
	}

	public void insertRecord(int level) throws Exception {
		String s = String.format("insert into BattleField(level_number)values(%f)",level);
		super.runDDL(s);
	}
	
	
	public List getAllBattleFields() throws Exception{
		List dbobjects = new ArrayList();
		String sql = "Select * from BattleField";
		SQLiteStatement statement = super.runSelectStatement(sql);
		while(true){
			if(statement.step()){
				BattleField mercDao = new BattleField();
				mercDao.setID(statement.columnInt(0));
				mercDao.setlevel_number(statement.columnInt(1));
				dbobjects.add(mercDao);
			} else {
				break;
			}
		}
		
		return dbobjects;
	}
	 
	
}

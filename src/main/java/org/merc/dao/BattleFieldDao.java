package org.merc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.merc.base.BattleField;
import org.merc.dao.BaseDao;

import com.almworks.sqlite4java.SQLiteStatement;

public class BattleFieldDao extends BaseDao {
	private int id;
	private int level_number;
	
	public BattleFieldDao() throws Exception{
		super();
	}

	/**
	 * 
	 * @param level
	 * @throws Exception
	 */
	public void insertRecord(int level) throws Exception {
		String s = String.format("insert into BattleField(level_number)values(%d)",level);
		super.runDDL(s);
	}
	
	@Override
	public void updateRecord(int id, Map<String,Object> m) throws Exception{
		String s = "update BattleField set ";
		String loop = " ";
		Set set = m.keySet();
		for(String o : m.keySet()){
			if(m.get(o) instanceof String){
			 loop += o + " = " + String.valueOf(m.get(o)) + " ";
			} else {
				loop += o + " = \"" + String.valueOf(m.get(o)) + "\" ";
			}
			m.remove(o);
			if(!m.isEmpty()){
				loop += " , ";
			}
		}
		s = String.format(s + loop + " where id = %d",id);
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

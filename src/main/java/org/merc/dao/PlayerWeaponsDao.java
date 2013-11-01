package org.merc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.merc.base.PlayerWeapons;
import org.merc.dao.BaseDao;

import com.almworks.sqlite4java.SQLiteStatement;

public class PlayerWeaponsDao extends BaseDao{

	private int id;
	
	private int player_id;
	
	private int weapons_id;
	
	public PlayerWeaponsDao() throws Exception{
		super();
	}
	/**
	 * 
	 * @param weapid
	 * @param pid
	 * @throws Exception
	 */
	public void insertRecord(int weapid, int pid) throws Exception {
		String s = String.format("insert into PlayerWeapons(player_id,weapons_id) values( %d, %d)",weapid,pid);
		super.runDDL(s);
	}
	
	@Override
	public void updateRecord(int id, Map<String,Object> m) throws Exception{
		String s = "update PlayerWeapons set ";
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
	
	public List getAllPlayerWeapons() throws Exception{
		List dbobjects = new ArrayList();
		String sql = "Select * from PlayerWeapons";
		SQLiteStatement statement = super.runSelectStatement(sql);
		while(true){
			if(statement.step()){
				PlayerWeapons mercDao = new PlayerWeapons();
				mercDao.setID(statement.columnInt(0));
				mercDao.setplayerID(statement.columnInt(1));
				mercDao.setWeaponsID(statement.columnInt(2));
				dbobjects.add(mercDao);
			} else {
				break;
			}
		}
		
		return dbobjects;
	}
	
	
}

package org.merc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.merc.base.Weapons;
import org.merc.dao.BaseDao;

import com.almworks.sqlite4java.SQLiteStatement;

public class WeaponsDao extends BaseDao{

	private int id;
	private String weaponsname;
	
	private int hp;
	
	private int atk;
	
	private int def;
	
	public WeaponsDao() throws Exception{
		super();
	}
	
	/**
	 * 
	 * @param hp
	 * @param atk
	 * @param def
	 * @param weap weapons name
	 * @throws Exception
	 */
	public void insertRecord(int hp, int atk, int def, String weap) throws Exception {
		String s = String.format("insert into Weapons(weaponsname,hp,atk,def) values(\"%s\", %d, %d,%d)",weap,hp,atk,def);
		super.runDDL(s);
	}
	
	@Override
	public void updateRecord(int id, Map<String,Object> m) throws Exception{
		String s = "update Weapons set ";
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
		String sql = "Select * from Weapons";
		SQLiteStatement statement = super.runSelectStatement(sql);
		while(true){
			if(statement.step()){
				Weapons mercDao = new Weapons();
				mercDao.setid(statement.columnInt(0));
				mercDao.setWeaponsName(statement.columnString(1));
				mercDao.setHP(statement.columnInt(2));
				mercDao.setATK(statement.columnInt(3));
				mercDao.setDEF(statement.columnInt(4));
				dbobjects.add(mercDao);
			} else {
				break;
			}
		}
		
		return dbobjects;
	}
}

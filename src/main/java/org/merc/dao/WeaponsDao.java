package org.merc.dao;

import java.util.ArrayList;
import java.util.List;

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
	
	public void insertRecord(int hp, int atk, int def, String weap) throws Exception {
		String s = String.format("insert into Weapons(weaponsname,hp,atk,def) values(\"%s\", %d, %d,%d)",weap,hp,atk,def);
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

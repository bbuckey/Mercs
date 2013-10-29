package org.merc.dao;

import org.merc.dao.BaseDao;
import org.merc.base.Merc;

import java.util.List;
import java.util.ArrayList;

import com.almworks.sqlite4java.SQLiteStatement;

public class MercDao extends BaseDao{

	private int id;
	private String mercname;
	private int hp;
	private int atk;
	private int def;
	
	public MercDao() throws Exception{
		super();
	}
	
	
	public void insertRecord(String bfid, int hp, int atk,int def) throws Exception {
		String s = String.format("insert into Mercs(mercname,hp,atk,def) "
				+ "values(\"%s\", %d, %d, %d);",bfid,hp,atk,def);

		super.runDDL(s);
	}
	
	
	public List getAllMercs() throws Exception{
		List dbobjects = new ArrayList();
		String sql = "Select * from Mercs";
		SQLiteStatement statement = super.runSelectStatement(sql);
		while(true){
			if(statement.step()){
				Merc mercDao = new Merc();
				mercDao.setid(statement.columnInt(0));
				mercDao.setATK(statement.columnInt(3));
				mercDao.setDEF(statement.columnInt(4));
				mercDao.setHP(statement.columnInt(2));
				mercDao.setMercName(statement.columnString(1));
				dbobjects.add(mercDao);
			} else {
				break;
			}
		}
		
		return dbobjects;
	}
	
	
}

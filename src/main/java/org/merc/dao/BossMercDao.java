package org.merc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	
	/**
	 * 
	 * @param bfid
	 * @param hp
	 * @param atk
	 * @param def
	 * @param exp
	 * @param gold
	 * @param dropids
	 * @param holdAtks
	 * @throws Exception
	 */
	public void insertRecord(int bfid, int hp, int atk,int def, int exp, int gold, String dropids, int holdAtks) throws Exception {
		String s = String.format("insert into BossMercs(holdatk,battlefield_id,hp,atk,def,exp,gold,drop_ids)"
				+ "values(%d, %d, %d,%d, %d, %d, %d, \"%s\")",holdAtks,bfid,hp,atk,def,exp,gold,dropids);
		super.runDDL(s);
	}
	
	@Override
	public void updateRecord(int id, Map<String,Object> m) throws Exception{
		String s = "update BossMercs set ";
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
	public List getAllBossMercs() throws Exception{
		List dbobjects = new ArrayList();
		String sql = "Select * from BossMercs";
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

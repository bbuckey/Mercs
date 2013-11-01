package org.merc.dao;

import java.util.Map;

import com.almworks.sqlite4java.SQLiteStatement;

import sqlite.SQLRunner;


abstract class BaseDao {
	
	protected SQLRunner sqldb;
	
	
	public BaseDao() throws Exception{
		sqldb = new SQLRunner("./src/main/application/mercs.db");
		//createthemercdb();
	}
	
	public BaseDao(String s) throws Exception{
		sqldb = new SQLRunner(s);
	}
	
	public void createthemercdb(){
		try {
		 sqldb.runDMLStatmenet(
				 "create table if not exists Mercs (id INTEGER PRIMARY KEY ASC AUTOINCREMENT, mercname NUMERIC, hp INTEGER, atk INTEGER, def INTEGER);",
					"create table if not exists Player(id INTEGER PRIMARY KEY ASC AUTOINCREMENT, plevel INTEGER, playername NUMERIC, exp INTEGER, gold INTEGER, cash INTEGER, lastcashtime NUMERIC);",
					"create table if not exists Weapons(id INTEGER PRIMARY KEY ASC AUTOINCREMENT,weaponsname NUMERIC, hp INTEGER, atk INTEGER, def INTEGER);",
					"create table if not exists BattleField(id INTEGER PRIMARY KEY ASC AUTOINCREMENT, level_number INTEGER);",
					"create table if not exists ComputerMercs(id INTEGER PRIMARY KEY ASC AUTOINCREMENT,battlefield_id REFERENCES BattleField(id) ,hp INTEGER, atk INTEGER, def INTEGER, exp INTEGER, gold INTEGER, Drop_ids NUMERIC );",
					"create table if not exists BossMercs(id INTEGER PRIMARY KEY ASC AUTOINCREMENT,battlefield_id REFERENCES BattleField(id) ,hp INTEGER, atk INTEGER, def INTEGER,exp INTEGER, gold INTEGER, Drop_ids NUMERIC);",
					"create table if not exists PlayerWeapons(id INTEGER PRIMARY KEY ASC AUTOINCREMENT, player_id REFERENCES Player(id) ,weapons_id REFERENCES Weapons(id));",
					"create table if not exists BattleFieldDrops(id INTEGER PRIMARY KEY ASC AUTOINCREMENT, mercs_id REFERENCES Mercs(id), weapons_id REFERENCES Weapons(id),  battlefield_id REFERENCES BattleField(id));",
					"create table if not exists PlayerMercs (id INTEGER PRIMARY KEY ASC AUTOINCREMENT,player_id REFERENCES Player(id) ,mercs_id REFERENCES Mercs(id) ,weapons_id REFERENCES Weapons(id), PlayerWeapons_id REFERENCES PlayerWeapons(id) , mercname TEXT, hp INTEGER, atk INTEGER, def INTEGER, mlevel INTEGER);",
					"create table if not exists MercType (id INTEGER PRIMARY KEY ASC AUTOINCREMENT ,mercs_id REFERENCES Mercs(id), mercType NUMERIC, hp INTEGER, atk INTEGER, def INTEGER, mlevels NUMERIC);"
				 				);
		}catch(Throwable t)
		{
			t.printStackTrace();
		}
	}
	
	protected SQLiteStatement runSelectStatement(String s) throws Exception{
		SQLiteStatement sql = sqldb.runSQLStatement(s);
		return sql;
	}
	
	protected void runDDL(String s) throws Exception{
		sqldb.runDMLStatmenet(s);

	}
	
	protected void runDDL(String ... s) throws Exception{
		sqldb.runDMLStatmenet(s);

	}
	
	public abstract void updateRecord(int id, Map<String,Object> m) throws Exception;
	
}

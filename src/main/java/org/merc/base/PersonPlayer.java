package org.merc.base;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.merc.base.Merc;
import org.merc.base.Player;


public class PersonPlayer extends Player {
	private int id;
	private int level;
	private int exp;
	private int gold;
	private int cash;
	private String playerName;
	private Date lastcashtime;
	private Merc merc;
	
	public PersonPlayer(){;}
	
	public PersonPlayer(Merc _merc){
		merc = _merc;
	}
	
	public void setMerc(Merc _merc){
		this.merc = _merc;
	}
	
	public void setPlayerName(String s){
		this.playerName = s;
	}
	
	public String getPlayerName(){
		return this.playerName;
	}
	public Merc getMerc(){
		return merc;
	}
	
	public void setID(int _id){
		this.id = _id;
	}
	public void setLevel(int _id){
		this.level = _id;
	}
	public void setExp(int _id){
		this.exp = _id;
	}
	public void setGold(int _id){
		this.gold = _id;
	}
	public void setCash(int _id){
		this.cash = _id;
	}
	public void setLastCashTime(Date _date){
		this.lastcashtime = _date;
	}
	
	public int getID(){
		return this.id;
		
	}
	
	public int getLevel(){
		return this.level;
	}
	
	public int getExp(){
		return this.exp;
	}
	
	public int getGold(){
		return this.gold;
	}
	
	public int getCash(){
		return this.cash;
	}

	public Date getLastCasheTime(){
		return this.lastcashtime;
	}
	
}

package org.merc.base;

import java.util.ArrayList;
import java.util.List;

public class PersonPlayerMercs {

	private Merc merc;
	private int id;
	private int player_id;
	private int mercs_id;
	private int weapons_id;
	private int playerweapons_id;
	private String mercname;
	private int hp;
	private int atk;
	private int def;
	private int mlevel;
	
	
	public PersonPlayerMercs(){;}
	
	public void setID(int _id){
		this.id = _id;
	}
	public void setPlayerID(int _id){
		this.player_id = _id;
	}
	public void setMercID(int _id){
		this.mercs_id = _id;
	}
	public void setWeaponsID(int _id){
		this.weapons_id = _id;
	}
	public void setPlayerWeaponsID(int _id){
		this.playerweapons_id = _id;
	}

	public void setATK(int _atk){
		this.atk = _atk;
	}
	
	public void setMLevel(int _hp){
		this.mlevel = _hp;
	}
	
	public void setHP(int _hp){
		this.hp = _hp;
	}
	
	public void setDEF(int _hp){
		this.def = _hp;
	}
	
	public void setMercName(String _hp){
		this.mercname = _hp;
	}
	
	public int getATK(){
		return this.atk;
	}
	
	public int getHP(){
		return this.hp;
	}
	
	public int getid(){
		return this.id ;
	}
	
	public int getDEF(){
		return this.def;
	}
	
	public String getMercName(){
		return this.mercname;
	}
	
	public int getMLevel(){
		return this.mlevel;
	}
	
	public int getPlayerID(){
		return this.player_id;
	}
	public int getMercID(){
		return this.mercs_id;
	}
	public int getWeaponsID(){
		return this.weapons_id;
	}
	public int getPlayerWeaponsID(){
		return this.playerweapons_id;
	}
}

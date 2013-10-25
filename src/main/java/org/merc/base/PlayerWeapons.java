package org.merc.base;

public class PlayerWeapons {

	private int id;
	
	private int player_id;
	
	private int weapons_id;
	
	public PlayerWeapons(){;}
	
	void setID(int _id){
		this.id = _id;
	}
	
	void setplayerID(int playerID){
		this.player_id = playerID;
	}
	
	void setWeaponsID(int weaponsID){
		this.weapons_id = weaponsID;
	}
	
	public int getID(){
		return this.id;
	}
	
	public int  getplayerID(){
		return this.player_id;
	}
	
	public int  getWeaponsID(){
		return this.weapons_id;
	}
	
}

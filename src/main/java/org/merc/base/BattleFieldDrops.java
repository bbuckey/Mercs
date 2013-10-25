package org.merc.base;

public class BattleFieldDrops {

	private int id;
	private int mercs_id;
	private int weapons_id;
	private int battlefield_id;
	
	public BattleFieldDrops(){;}
	
	public void setMercID(int _merc){
		this.mercs_id = _merc;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public int getMercID(){
		return this.mercs_id;
	}
	
	public int getID(){
		return this.id;
	}
	
	public void setWeaponsID(int id){
		this.weapons_id = id;
	}
	
	public int getWeaponsID(){
		return this.weapons_id;
	}
	
	
	public void setBattleFieldID(int id){
		this.battlefield_id = id;
	}
	
	public int getBattleFieldID(){
		return this.battlefield_id;
	}
}

package org.merc.base;

public class Weapons {

	private int id;
	private String weaponsname;
	
	private int hp;
	
	private int atk;
	
	private int def;
	
	
	public Weapons(){;}
	
	public void setATK(int _atk){
		this.atk = _atk;
	}
	
	public void setHP(int _hp){
		this.hp = _hp;
	}
	
	public void setDEF(int _hp){
		this.def = _hp;
	}
	
	public void setid(int _hp){
		this.id = _hp;
	}
	
	public void setWeaponsName(String _hp){
		this.weaponsname = _hp;
	}
	
	public int getATK(){
		return this.atk;
	}
	
	public int getHP(){
		return this.hp;
	}
	
	
	public int getDEF(){
		return this.def;
	}

	public int getid(){
		return this.id ;
	}
	
	
	public String getWeaponsName(){
		return this.weaponsname;
	}
	
}

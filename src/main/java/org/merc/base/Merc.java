package org.merc.base;

public class Merc {

	private int id;
	private String mercname;
	private int hp;
	private int atk;
	private int def;
	private boolean isComputer;
	
	public Merc(){;}
	
	public Merc(int _hp, int _atk, boolean _isComp){
		hp = _hp;
		atk = _atk;
		isComputer = _isComp;
	}
	
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
	
	public void setMercName(String _hp){
		this.mercname = _hp;
	}
	
	public void setIsComputer(boolean _isComp){
		this.isComputer = _isComp;
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
	public boolean getIsComputer(){
		return this.isComputer;
	}
	
	public int getid(){
		return this.id ;
	}
	
	
	public String getMercName(){
		return this.mercname;
	}
	
}

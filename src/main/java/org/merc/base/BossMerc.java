package org.merc.base;

public class BossMerc extends Player implements Computer {

	private Merc merc;
	private int holdAtk;
	private int id;
	private int battlefield_id;
	private int hp;
	private int atk;
	private int def;
	private int exp;
	private int gold;
	private String[] Drop_ids;
		
	public BossMerc(){;}
		
		public BossMerc(Merc _merc){
			merc = _merc;
			holdAtk = 1;
		}
		
		public BossMerc(Merc _merc, int _holdAtk){
			merc = _merc;
			holdAtk = _holdAtk;
		}
		
		public void setMerc(Merc _merc){
			this.merc = _merc;
		}
		
		public void setHoldATK(int _holdatk){
			this.holdAtk = _holdatk;
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
		
		public Merc getMerc(){
			return merc;
		}
		
		public int getHoldATK(){
			return holdAtk;
		}
		
		public void setID(int _id){
			this.id = _id;
		}
		public void setBattleFieldID(int _id){
			this.battlefield_id = _id;
		}
		public void setExp(int _id){
			this.exp = _id;
		}
		public void setGold(int _id){
			this.gold = _id;
		}
		public void setDropIDs(String _id){
			this.Drop_ids = _id.split(",");
		}

		public int getID(){
			return this.id;
			
		}
		
		public int setBattleFieldID(){
			return this.battlefield_id;
		}
		
		public int getExp(){
			return this.exp;
		}
		
		public int getGold(){
			return this.gold;
		}
		
		public String[] getDropIDs(){
			return this.Drop_ids;
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
	
}

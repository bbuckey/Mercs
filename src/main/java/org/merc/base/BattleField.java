package org.merc.base;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.merc.base.Merc;
import org.merc.base.ComputerPlayer;
import org.merc.base.PersonPlayer;
import org.merc.base.BossMerc;
import org.merc.base.Computer;

public class BattleField {
	
	private List<ComputerPlayer> computerList;
	private BossMerc boss;
	private PersonPlayer personPlayer;
	private int id;
	private int level_number;
	

	
	public void setlevel_number(int _merc){
		this.level_number = _merc;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public int getlevel_number(){
		return this.level_number;
	}
	
	public int getID(){
		return this.id;
	}
	
	public BattleField(){
		computerList = new ArrayList<ComputerPlayer>();
	}
	
	public BattleField(List<ComputerPlayer> _computerPlayer, PersonPlayer _personPlayer,Computer _boss){
		computerList = _computerPlayer;
		personPlayer = _personPlayer;
		boss = (BossMerc)_boss;
	}
	
	public boolean battle(){
		Merc playerMerc = personPlayer.getMerc();
		int hp = playerMerc.getHP();
		int move = 0;
		for(ComputerPlayer cp : computerList){
			
			hp = fight(cp,hp,playerMerc.getATK(),move);
			if(hp >= 0){
				continue;
			} else {
				System.out.println("You have Lost");
				return false;
			}
		}
		
		hp = fight(boss,hp,playerMerc.getATK(),move);
		if(hp >= 0){
			System.out.println("You have Won");
			return true;
		} else {
			System.out.println("You have Lost");
			return false;
		}
	}
	
	private int fight(Computer cp, int hp, int atk, int move){
		int chp = cp.getMerc().getHP();
		int catk = cp.getMerc().getATK();
		int choldAtk = cp.getHoldATK();
		while(hp > 0 && chp > 0)
		{
			System.out.println("Current HP: " + hp + " Current Atk: " + atk);
			System.out.println("Current CHP: " + chp + " Current CAtk: " + catk + " Current C turn wait: " + choldAtk);
			while(move < 1 || move > 2){
				System.out.println("Please enter 1 to attack or 2 to heal");
				InputStreamReader bis = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(bis);
				try{
					String userinput = br.readLine();
					move = Integer.parseInt(userinput);
				}catch(Throwable t){
					move = 0;
					System.out.println("Invalid Entry, Please make sure you have entered either a 1 or 2");
				}
			}
			if(move == 1){
				chp = chp - atk;
			} else if(move == 2){
				hp += ((Math.random()*1000)% 100);
			}
			if(chp > 0 && choldAtk <= 1){
				hp = hp - catk;
				choldAtk = cp.getHoldATK();
			} else {
				--choldAtk;
			}
			move = 0;
		}
		return hp;
	}
	
	

}

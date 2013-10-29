package org.merc.main;

import java.util.List;
import java.util.ArrayList;

import org.merc.base.Merc;
import org.merc.base.ComputerPlayer;
import org.merc.base.Computer;
import org.merc.base.BossMerc;
import org.merc.base.PersonPlayer;
import org.merc.base.BattleField;
import org.merc.dao.MercDao;
import org.merc.util.ApplicationBeanContext;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.*;

public final class MercsForHire {

	MercDao bd;
	
	MercsForHire(){;}
	
	public static void main(String[] args) {
		MercsForHire mfh = new MercsForHire();
		 MercDao mercDao;
		 mercDao = ApplicationBeanContext.createMercs();
			//bd.insertRecord("Tight Spot", 140, 20, 0);
			mfh.printmerclist(mercDao);
		PersonPlayer pp = new PersonPlayer(new Merc(((int)(Math.random()*100000) % 1000),
				((int)(Math.random()*100000) % 100), false));
		List<Computer> clist = new ArrayList<Computer>();
		for( int i = 0 ; i <= 10; i++){
			clist.add(new ComputerPlayer(new Merc(((int)(Math.random()*100000) % 200),
					((int)(Math.random()*100000) % 50), true),((int)(Math.random()*100000) % 5)));
		}
		BattleField bf = new BattleField(clist,pp,new BossMerc(new Merc(((int)(Math.random()*100000) % 500),
				((int)(Math.random()*100000) % 100), true),((int)(Math.random()*100000) % 7)));
		
		bf.battle();
		
	}
	
	@Autowired
	public void printmerclist(MercDao mercDao){
		try{
			this.bd = mercDao;
			//bd = ApplicationBeanContext.createMercs();
			//bd.insertRecord("Tight Spot", 140, 20, 0);
			List<Merc> mercs = bd.getAllMercs();
			for(Merc m : mercs){
				System.out.println("Mercs Name: " + m.getMercName());
				System.out.println("Mercs HP: " + m.getHP());
				System.out.println("Mercs ATK: " + m.getATK());
				System.out.println("Mercs DEF: " + m.getDEF());
			}
			
		} catch(Throwable t){
			t.printStackTrace();
		}
	}
}

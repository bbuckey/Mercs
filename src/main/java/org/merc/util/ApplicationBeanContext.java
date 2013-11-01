package org.merc.util;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.merc.dao.*;
import org.merc.main.*;


public class ApplicationBeanContext {

	private static 	ApplicationContext context = new ClassPathXmlApplicationContext(
	        new String[] {"ApplicationBeanUtil.xml"});
	
	static private BeanFactory loadXmlBeanResources(){
		BeanFactory factory = context;
		return factory;
	}
	
	
	protected static Object getABean(String s){
		return loadXmlBeanResources().getBean(s);
	}
	
	public static BattleFieldDao createBattleField(){
		return (BattleFieldDao)getABean("battleFieldDao");
	}
	
	public static BattleFieldDropsDao createBattleFieldDrops(){
		return (BattleFieldDropsDao)getABean("battleFieldDropsDao");
	}

	public static BossMercDao createBossMerc(){
		return (BossMercDao)getABean("bossMercDao");
	}
	
	public static ComputerMercDao createComputerMerc(){
		return (ComputerMercDao)getABean("computerMercDao");
	}
	
	public static MercDao createMercs(){
		return (MercDao)getABean("mercDao");
	}
	
	public static PlayerDao createPlayer(){
		return (PlayerDao)getABean("playerDao");
	}
	
	public static PlayerMercDao createPlayerMerc(){
		return (PlayerMercDao)getABean("playerMercDao");
	}
	
	public static PlayerWeaponsDao createPlayerWeapons(){
		return (PlayerWeaponsDao)getABean("playerWeaponsDao");
	}
	
	public static WeaponsDao createWeapons(){
		return (WeaponsDao)getABean("weaponsDao");
	}
	
	public static MercsForHire createMercForHire(){
		return (MercsForHire)getABean("mercForHire");
	}
	
}

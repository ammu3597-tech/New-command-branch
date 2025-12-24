package com.CRM.WebDiverGenericUtility;

import java.util.Random;



public class JavaUtility {
	public int getRandomNum() {
		Random rm=new Random();
		int random=rm.nextInt(1000);
		return random;
	}

}

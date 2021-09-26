package com.skillrary.rmgyantra.genericlib;

import java.util.Random;

public class JavaUtility {
	
	public static int getRandomNum() {
		Random r=new Random();
		int numb = r.nextInt(100);
		return numb;
		
	}

}

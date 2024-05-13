package com.project.chat.app.LetsChat.Util;

import org.springframework.stereotype.Component;

@Component
public class TestUtil {

	public void printfib(int i) {
		int f=0,n=1,p=0;
		System.out.println(" Fibin seres:" +f+" "+n);
   for(int j=0;j<i;j++) {
	   f=n+p;
	   System.out.println(" "+f);
	   p=n;
	   n=f;
   }
	}

}

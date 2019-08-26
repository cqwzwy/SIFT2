package com.brief;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JDK8 {
	
	private int num;
	
	
	public static void main(String[]as) {
		Matcher m =Pattern.compile("([^0-9]{1,})(\\d{1,})(.*)")
		        .matcher("田猎卜辞中的动物_杨杨34.125.dhjk");
		    while(m.find()) {
		      for(int j = 0; j <= m.groupCount(); j++)
		        System.out.println(m.end(1)+"group("+j+")[" + m.group(j) + "]");
		    }
  
		JDK8 test=new JDK8();
		JDK8 t2=new JDK8();
		test.num=2;
		t2.num=4;
		test.sum(t2);
		System.out.println(t2.num);
		oparation add=(int a,int b)->a+b;
		oparation sub=(a,b)->a-b;
		
		oparation cel=(a,b)->{return a*b;};
		System.out.println("表达式  " +test.opera(10, 5, add) );
		
		
	}
	
	public void sum(JDK8 t) {
		t.num*=10;
	}
	
	interface oparation{
		int oparation(int a,int b);
	}
	
	interface guasda{
		
		void message(String msg);
		
	}
	
	private int opera(int a,int b,oparation math) {
		return math.oparation(a, b);
	}
	
	
}

interface test{
	default void get() {};
	void put();
}

class car implements test{

	public void put() {
		
		
	}
	
}



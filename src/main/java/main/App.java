package main;

import java.util.ArrayList;

public class App {
	
	public static void main (String[] args) {
		String arg1="555 72 86 45 10";
		ArrayList<Integer> pos=new ArrayList<Integer>();
		arg1=arg1+" ";
		pos.add(0);
		for (int i=0; i<arg1.length(); i++) {
			if (arg1.substring(i,i+1).equals(" ")) {
				pos.add(i);
			}
		}
		int max=0;
		for (int j=0; j<pos.size()-1; j++) {
			int num=Integer.parseInt(arg1.substring(pos.get(j),pos.get(j+1)).trim());
			System.out.println("num="+num);
			int sum=num%10+num/10%10+num/100%10;
			System.out.println("sum="+sum);
			if (max<sum) {
				max=sum;
				System.out.println(max);
			}
		}

		
	
	}
}
	



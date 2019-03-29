package main;

import java.util.ArrayList;

public class OfflineExercises {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") → "TTThhheee"
	// multChar("AAbb") → "AAAAAAbbbbbb"
	// multChar("Hi-There") → "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String output="";
		for (int i=0; i<input.length(); i++) {
			output=output+input.substring(i, i+1)+input.substring(i, i+1)+input.substring(i, i+1);
		}
		return output;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") → "evilc"
	// getBert("xxbertfridgebertyy") → "egdirf"
	// getBert("xxBertfridgebERtyy") → "egdirf"
	// getBert("xxbertyy") → ""
	// getBert("xxbeRTyy") → ""

	public String getBert(String input) {
		int first=input.toLowerCase().indexOf("bert");
		int last=input.toLowerCase().lastIndexOf("bert");
		if  ((first==last)||(first==-1)||(last==-1)){
			return "";
		}
		String trim=input.substring(first+4, last);
		String output="";
		for (int i=trim.length(); i>0; i--) {
			output=output+trim.substring(i-1, i);
		}
		return output;
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) → true
	// evenlySpaced(4, 6, 2) → true
	// evenlySpaced(4, 6, 3) → false
	// evenlySpaced(4, 60, 9) → false

	public boolean evenlySpaced(int a, int b, int c) {
		int large=Math.max(Math.max(a,b),Math.max(b, c));
		int mid=0;
		int small=Math.min(Math.min(a, b), Math.min(b, c));
		int[] nums= {a,b,c};
		for (int i=0; i<3; i++) {
			if ((large>nums[i])&&(small<nums[i])) {
				mid=nums[i];
			}
		}
		if (large-mid==mid-small) {
			return true;
		}
		else {
			return false;
		}	
	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) → "Ho"
	// nMid("Chocolate", 3) → "Choate"
	// nMid("Chocolate", 1) → "Choclate"

	public String nMid(String input, int a) {
		int midpoint=(input.length()/2);
		String output=input.substring(0, midpoint-a/2)+input.substring(midpoint+a/2+1);
		return output;
	}

	// Given a string, return true if it ends in "dev". Ignore Case

	// endsDev("ihatedev") → true
	// endsDev("wehateDev") → true
	// endsDev("everoyonehatesdevforreal") → false
	// endsDev("devisnotcool") → false

	public boolean endsDev(String input) {
		if(input.length()<3) {
			return false;
		}
		else if (input.toLowerCase().substring(input.length()-3).equals("dev")) {
			return true;
		}
		else {
			return false;
		}
	}



	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") → 2
	// superBlock("abbCCCddDDDeeEEE") → 3
	// superBlock("") → 0

	public int superBlock(String input) {
		int max=0;
		int count=0;
		for (int i=0; i<input.length(); i++) {
			if (i!=0) {
				if (!(input.substring(i-1, i).equals(input.substring(i, i+1)))){
					if (max<count) {
						max=count;
					}
					count=0;
				}
			}
			if (input.substring(i, i+1).equals(input.substring(i, i+1))&&(i!=(input.length()-1))) {
				count++;
			}
		}
		return max;

	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") → 1
	//amISearch("I am in Amsterdam am I?") → 2
	//amISearch("I have been in Amsterdam") → 0

	public int amISearch(String arg1) {
		arg1=" "+arg1.toLowerCase().trim()+" ";
		int count=0;
		for (int i=0; i<arg1.length()-4; i++) {
			if ((arg1.substring(i, i+4).equals(" am "))) {
				count++;
			}
		}
		return count;
		
	}
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) → "fizz"
	//fizzBuzz(10) → "buzz"
	//fizzBuzz(15) → "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		if ((arg1%3==0)&&(arg1%5==0)){
			return "fizzbuzz";
		}
		else if (arg1%3==0) {
			return "fizz";
		}
		else if(arg1%5==0) {
			return "buzz";
		}
		else {
			return null;
		}
		
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") → 14
	//largest("15 72 80 164") → 11
	//largest("555 72 86 45 10") → 15
	
	public int largest(String arg1) {
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
			int sum=num%10+num/10%10+num/100%10;
			if (max<sum) {
				max=sum;
			}
		}
		return max;
		
	}
	
	
}

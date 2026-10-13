package org.ADS;

public class Quotient_Q4 {
	
	public static int findReminder(int a,int b) {
		if(a==0 || b==0) {
			throw new IllegalArgumentException("noting can be zero");
		}
		else if(a == 0) {
			return 0;
		}
		if(a == b) {
			return 0;
		}
		return reminder(a,b);
	}
	public static int reminder(int a , int b) {
		if(b < a) {
			return b;
		}
		return reminder(a,b-a);
	}
	
	public static int findQuotient(int a,int b,int n) {
		if(b == 0 || b < a) {
			return n;
		}
		return findQuotient(a,b-a,n+1);
	}
	
	
	public static void main(String[]args) {
		System.out.println(findReminder(5,9));
	}

}

package ch18;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
	    
	    int num = Integer.parseInt(sc.nextLine());
	    
	    for(int i=1; i<=9; i++){
	     	System.out.println(num + " x " + i + " = " + num*i); 
	    }
	  }
}

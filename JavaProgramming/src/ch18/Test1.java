package ch18;


public class Test1 {
    public static void main(String[] args) {

    	int max=10;
    	for(int i=1; i<max; i++){
    		for(int x=max/2-1; x>i; x--){
    			System.out.print(" ");
    		}
    		for(int j=0; j<i; j++){
    			System.out.print("*");
    		}
    		for(int x=max/2-1; x>i; x--){
    			System.out.print(" ");
    		}
    		System.out.println();
    	}


    }
}
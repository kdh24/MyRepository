package ch05.exam02;

public class ArrayCreateByValueList1 {

	public static void main(String[] args) {
		//how1
		int[] scores1 = { 83, 90, 87 };
		
		//how2
		int[] scores2;
		scores2 = new int[] { 83, 90, 87 };
		
		sum(new int[] {83, 90, 87});
	}
	
	public static void sum(int[] arr){
		
	}

}

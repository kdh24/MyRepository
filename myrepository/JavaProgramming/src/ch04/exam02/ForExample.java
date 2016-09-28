package ch04.exam02;

public class ForExample {
	public static void main(String[] args) {
		int sum=0;
		int count;
		
		for(count=0; count<3; count++){
			int num = (int)(Math.random()*6)+1;
			System.out.println(num);
			sum += num;
		}
		System.out.println("눈의 합: " + sum);
//		double avg = (double)sum / count;
		double avg = sum / 3.0;
		System.out.println("주사위 평균: " + avg);
	}

}

package ch04.exam03;

public class BreakExample {
	// 주사위의 눈이 6이 나오면 게임을 종료하세요.
	public static void main(String[] args) {
		
		while(true){
			/*
			double num = Math.random(); //0.0 <= ... <= 1.0
			num = num * 6; //0.0 <= ... < 6.0
			int value = (int)num; //0, 1, 2, 3, 4, 5
			value += 1; //1, 2, 3, 4, 5, 6
			*/
			
			int value = (int)(Math.random() * 6) + 1;
			System.out.println(value);
			
			if(value == 6){
				break;
			}
		}
	}

}

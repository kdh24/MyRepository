package ch04.homework;

public class HomeWork1 {
	public static void main(String[] args) {
		int num1 = 0; // int형 변수 num1 선언 후 초기값 0 대입
		int num2 = 0; // int형 변수 num2 선언 후 초기값 0 대입
		
		// int형 변수 i 선언 후 1로 초기화하고 조건이 맞으면 반복문 실행 후 i변수 1씩 증가
		for(int i=1; i<=100; i++){
			//0.0 이상 1.0 이하로 생성되는 랜덤한 값에 6을 곱해 0.? ~ 5.?로 변환 후
			// 1을 더해 1.? ~ 6.? 으로 변환하고 int형으로 강제타입변환해서 소수자리 버리고
			// 1 ~ 6의 값을 num1 변수에 대입함
			num1 = (int)(Math.random()*6 +1);
			// num2 변수에 랜덤한 주사위 값(0.?~5.? + 1)을 (int)형 정수로 변환 후 대입
			num2 = (int)(Math.random()*6 +1);
			
			if(num1 + num2 == 10){ // 2개의 주사위의 합을 더해 10이 되면 if 블록 실행
				// for문이 100번 실행 될 동안 두 주사위 합이 10이 될 경우 num1, num2 값 출력
				System.out.println("(" + num1 + ", " + num2 + ")");
			}
		}
	}

}

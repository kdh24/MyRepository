package ch06.exam03;

public class CarExample {

	public static void main(String[] args) {

		//Car 변수 선언
		Car myCar = null;
		//Car 객체를 생성하고 위치 정보 얻기
		try {
			myCar = new Car();
		} catch(Exception e){}
		//Car 객체가 있는지 조사
		if(myCar != null){
			System.out.println("Car 객체 있음");
		}else {
			System.out.println("Car 객체 없음");
		}
		
		//객체 내부의 필드값을 읽어보자.
		System.out.println(myCar.company);
		//객체 내부의 필드값을 변경해보자.
		myCar.company = "KOSA";
		System.out.println(myCar.company);
		
		//객체 내부의 메소드를 호출해 보자.
		myCar.run();
		
		//객체 생성
//		Car myCar = new Car();
		
		//필드값 읽기
		System.out.println("제작회사: " + myCar.company);
		System.out.println("모델명: " + myCar.model);
		System.out.println("색깔: " + myCar.color);
		System.out.println("최고속도: " + myCar.maxSpeed);
		System.out.println("현재속도: " + myCar.speed);
		
		//필드값 변경
		myCar.speed = 60;
		System.out.println("수정된 속도: " + myCar.speed);
	}

}

package ch07.exam05;

public class Machine {
	void work() {
		System.out.println("Machine-work() 실행");
	}
	
	public final void powerOn(){
		System.out.println("전원을 연결합니다.");
	}
	
	public final void powerOff(){
		System.out.println("Machine-work() 실행");
	}
}

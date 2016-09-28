package ch12.exam10;

public class PrintThread2 extends Thread {

	@Override
	public void run() {
		try{
			while(true){
				System.out.println("실행 중...");
				if(isInterrupted()){
					Thread.sleep(1);
				}
			}
		}catch(InterruptedException e){}
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}
}

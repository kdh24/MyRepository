package ch12.exam07;

public class ThreadA extends Thread{
	public boolean stop = false;
	public Work work = Work.CONTINUE;
	
	@Override
	public void run() {
		while(!stop){
			if(work == Work.CONTINUE){
				System.out.println("ThreadB 작업 내용");
			}else if(work == Work.PAUAE){
				Thread.yield();
			}
		}
		System.out.println("ThreadB 종료");
	}
}

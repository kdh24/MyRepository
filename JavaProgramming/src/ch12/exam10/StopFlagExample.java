package ch12.exam10;

public class StopFlagExample {
	public static void main(String[] args) {
		PrintThread3 pt= new PrintThread3();
		pt.start();
		
		try { Thread.sleep(3000); } catch (InterruptedException e) { }

		pt.interrupt();
	}
}

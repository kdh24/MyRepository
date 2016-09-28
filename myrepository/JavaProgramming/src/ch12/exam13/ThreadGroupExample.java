package ch12.exam13;

public class ThreadGroupExample {
	public static void main(String[] args){
		
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName());
		
		for (int i = 0; i < 10; i++) {
			int count = i;
			Thread thread2 = new Thread() {
				@Override
				public void run() {
					while (true) {
						System.out.println("Thread" + count + ":실행중...");
						if (isInterrupted()) break;
					}
					System.out.println("Thread" + count + ":종료");
				}
			};
			thread2.start();
		}

		ThreadGroup mainGroup = thread.getThreadGroup();
		System.out.println(mainGroup.getName());
		System.out.println(mainGroup.activeCount());
		
		try { Thread.sleep(1000); } catch (InterruptedException e) { }
		
		mainGroup.interrupt();
	}
}

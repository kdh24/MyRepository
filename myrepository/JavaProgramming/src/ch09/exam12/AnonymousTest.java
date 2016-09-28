package ch09.exam12;

public class AnonymousTest {
	//Field
	private RemoteControl rc = new RemoteControl() {};
	
	//Constructor
	public AnonymousTest() {
		RemoteControl rc = new RemoteControl() {};
	}
	
	
	//Method
	public void method1(RemoteControl rc){
		
	}
	
	public void method2(RemoteControl rc){
		method1(new RemoteControl() {});
	}
}

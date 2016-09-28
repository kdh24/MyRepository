package ch08.exam03;

public interface RemoteControl {
	//Constant
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	//Abstract Method
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	//Default Method
	default public void setMute(boolean mute) {
		if(mute){
			System.out.println("무음 처리합니다.");
		}else {
			System.out.println("무음 해제합니다.");
		}
	}
	
	//Static Method
	public static void changeBattery() {
		System.out.println("건전지를 교환합니다.");
	}
	
}

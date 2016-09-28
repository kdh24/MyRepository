package ch08.exam01;

public class Example {
	public static void powerOn(RemoteControl rc){
		rc.turnOn();
	}

	public static void main(String[] args) {
		int max = RemoteControl.MAX_VOLUME;
		int min = RemoteControl.MIN_VOLUME;
		
		//RemoteControl.turnON();
		//RemoteControl.turnOFF();
		//RemoteControl.setVolume();
		
		//RemoteControl.setMute(true);
		
		RemoteControl.changeBattery();
		
		//---------------------------------------------------
		
		Television tv = new Television();
		tv.turnOn();
		
		RemoteControl rc = tv;
		rc.turnOn();
		
		Audio audio = new Audio();
		audio.turnOn();
		
		rc = audio;
		rc.turnOn();
		

		//---------------------------------------------------
		
		powerOn(new Television());
		powerOn(new Audio());
	}

}

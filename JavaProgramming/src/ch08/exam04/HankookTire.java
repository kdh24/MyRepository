package ch08.exam04;

import ch08.exam05.Tire;

public class HankookTire implements Tire{
	@Override
	public void roll() {
		System.out.println("한국 타이어가 굴러갑니다.");
	}

}

package ch09.exam13;

public class ButtonExample {
	public static void main(String[] args) {
		Button btnOk = new Button();

		int value = 10;
		
		btnOk.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick() {
				System.out.println("음악을 " + value + "번 재생합니다");
			}
		});

		btnOk.click();
	}

}

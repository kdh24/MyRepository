package ch06.exam07;

public class Board {
	//Field
	int no;
	String title;
	String content;
	String writer;
	int hitcount;
	
	//Constructor Overloading
	//1.매개변수의 수가 달라야 한다.
	//2.매개변수의 타입이 달라야 한다.
	Board() {}
	Board(int no) {
		//int a = 10; (x)
		this(no, null, null, null, 0);
		int b = 10;
	}
	Board(int no, String title) {
		this(no, title, null, null, 0);
	}
	Board(String title, int no) {
		this(no, title, null, null, 0);
	}
	Board(int no, String title, String content) {
		this(no, title, content, null, 0);
	}
	Board(int no, String title, String content, String writer) {
		this(no, title, content, writer, 0);
	}
	Board(int no, String title, String content, String Writer, int hitcount) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.hitcount = hitcount;
	}
	
	//Method
}

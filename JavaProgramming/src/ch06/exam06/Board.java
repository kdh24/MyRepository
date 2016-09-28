package ch06.exam06;

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
	Board(int no) {}
	Board(int no, String title) {}
	Board(String title, int hitcount) {}
	Board(int no, String title, String content) {}
	Board(int no, String title, String content, String Writer) {}
	Board(int no, String title, String content, String Writer, int hitcount) {}
	
	//Method
}

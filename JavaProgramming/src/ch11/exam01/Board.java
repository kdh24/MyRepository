package ch11.exam01;

public class Board {
	private int bno;
	private String title;
	private String content;
	
	public Board(int bno, String title, String content) {
		this.bno = bno;
		this.title = title;
		this.content = content;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Board){
			Board target = (Board) obj;
			if(bno == target.bno){
				return true;
			}
		}
			return false;
	}
}
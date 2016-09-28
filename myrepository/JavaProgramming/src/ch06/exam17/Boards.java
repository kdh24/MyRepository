package ch06.exam17;

import java.util.Scanner;

public class Boards {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Board[] boards = null;

		while (true) {
			System.out.println("-------------------------------------------------------------------------");
			if (boards == null) {
				System.out.println("2. 글쓰기 | 6. 종료 ");
				boards = new Board[100];
			} else {
				System.out.println("1. 목록 | 2. 글쓰기 | 3. 상세보기 | 4. 수정하기 | 5. 삭제하기 | 6. 종료 ");
			}
			System.out.println("-------------------------------------------------------------------------");
			System.out.print("선택: ");
			String choice = scanner.nextLine();

			if (choice.equals("1")) {	// 목록보기
				System.out.println("***************************************************");
				System.out.println("번호\t\t제목\t\t글쓴이\t\t조회수");
				System.out.println("***************************************************");
				for (Board board : boards) {
					if (board != null) {
						System.out.println(board.getBno() + "\t\t" + board.getBtitle()+ "\t" + board.getBwriter() + "\t\t" + board.getBcount());
					}
				}
			} else if (choice.equals("2")) {	// 게시물 작성
				System.out.print("제목 : ");
				String title = scanner.nextLine();
				System.out.print("내용 : ");
				String text = scanner.nextLine();
				System.out.print("글쓴이 : ");
				String writer = scanner.nextLine();

				for (int i = 0; i < boards.length; i++) {
					if (boards[i] == null) {
						Board board = new Board(i+1, title, text, writer, 0);
						boards[i] = board;
						break;
					}
				}
			} else if (choice.equals("3")) {	// 게시물 상세보기
				System.out.println("상세보기할 게시물 번호를 선택하세요");
				int detailNum = Integer.parseInt(scanner.nextLine());
				for (Board board: boards) {
					if (board != null) {
//						int noticeNum = Integer.parseInt(notice[0]);
						if(detailNum == board.getBno()){
							board.setBcount(board.getBcount()+1);
							
							System.out.println("********************************************************");
							System.out.println("번호\t\t제목\t\t내용\t\t글쓴이\t\t조회수");
							System.out.println("********************************************************");
							System.out.println(board.getBno() + "\t\t" + board.getBtitle() + "\t" + board.getBcontent() + "\t\t" + board.getBwriter() + "\t\t" + board.getBcount());
						}
					}
				}

			} else if (choice.equals("4")) {	// 게시물 수정
				System.out.println("변경할 게시물 번호를 선택하세요");
				int modifyNum = Integer.parseInt(scanner.nextLine())-1;

				if (boards[modifyNum] != null) {
					System.out.print("제목 : ");
					String title = scanner.nextLine();
					System.out.print("내용 : ");
					String text = scanner.nextLine();

					boards[modifyNum].setBtitle(title);
					boards[modifyNum].setBcontent(text);
				}
			} else if (choice.equals("5")) {	// 게시물 삭제
				System.out.println("삭제할 게시물 번호를 선택하세요");
				int deleteNum = Integer.parseInt(scanner.nextLine())-1;
				
				if(boards[deleteNum] != null){
					boards[deleteNum] = null;
				}
			} else if (choice.equals("6")) {	// 종료
				break;
			}
		}
	}

}

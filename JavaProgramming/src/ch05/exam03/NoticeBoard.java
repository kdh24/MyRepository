package ch05.exam03;

import java.util.Scanner;

public class NoticeBoard {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[][] notices = new String[100][];

		while (true) {
			System.out.println("-------------------------------------------------------------------------");
//			if (notices == null) {
//				System.out.println("2. 글쓰기 | 6. 종료 ");
//			} else {
				System.out.println("1. 목록 | 2. 글쓰기 | 3. 상세보기 | 4. 수정하기 | 5. 삭제하기 | 6. 종료 ");
//			}
			System.out.println("-------------------------------------------------------------------------");
			System.out.print("선택: ");
			String choice = scanner.nextLine();

			if (choice.equals("1")) {	// 목록보기
				System.out.println("***************************************************");
				System.out.println("번호\t\t제목\t\t글쓴이\t\t조회수");
				System.out.println("***************************************************");
				for (String[] notice : notices) {
					if (notice != null) {
						System.out.println(notice[0] + "\t\t" + notice[1] + "\t" + notice[3] + "\t\t" + notice[4]);
						System.out.println(notice[0] + "\t\t" + notice[1] + "\t\t" + notice[3] + "\t\t" + notice[4]);
					}
				}
			} else if (choice.equals("2")) {	// 게시물 작성
				System.out.print("제목 : ");
				String title = scanner.nextLine();
				System.out.print("내용 : ");
				String text = scanner.nextLine();
				System.out.print("글쓴이 : ");
				String writer = scanner.nextLine();

				for (int i = 0; i < notices.length; i++) {
					if (notices[i] == null) {
						String[] notice = { String.valueOf(i + 1), title, text, writer, "0" };
						notices[i] = notice;
						break;
					}
				}
			} else if (choice.equals("3")) {	// 게시물 상세보기
				System.out.println("상세보기할 게시물 번호를 선택하세요");
				int detailNum = Integer.parseInt(scanner.nextLine());
				for (String[] notice : notices) {
					if (notice != null) {
						int noticeNum = Integer.parseInt(notice[0]);
						if(detailNum == noticeNum){
							notice[4] = String.valueOf(Integer.parseInt(notice[4]) + 1);
							
							System.out.println("***************************************************");
							System.out.println("번호\t\t제목\t\t내용\t\t글쓴이\t\t조회수");
							System.out.println("***************************************************");
							System.out.println(notice[0] + "\t\t" + notice[1] + "\t\t" + notice[2] + "\t\t" + notice[3] + "\t\t" + notice[4]);
						}
					}
				}

			} else if (choice.equals("4")) {	// 게시물 수정
				System.out.println("변경할 게시물 번호를 선택하세요");
				int modifyNum = Integer.parseInt(scanner.nextLine())-1;

				if (notices[modifyNum] != null) {
					System.out.print("제목 : ");
					String title = scanner.nextLine();
					System.out.print("내용 : ");
					String text = scanner.nextLine();

					notices[modifyNum][1] = title;
					notices[modifyNum][2] = text;
				}
			} else if (choice.equals("5")) {	// 게시물 삭제
				System.out.println("삭제할 게시물 번호를 선택하세요");
				int deleteNum = Integer.parseInt(scanner.nextLine())-1;
				
				if(notices[deleteNum] != null){
					notices[deleteNum] = null;
				}
			} else if (choice.equals("6")) {	// 종료
				break;
			}
		}
	}

}

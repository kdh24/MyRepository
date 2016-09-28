package ch05.exam03;

import java.util.Scanner;

public class ScoreManagement {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String[][] students = null;
		while(true) {
			System.out.println("-------------------------------------------------");
			if(students == null){
				System.out.println("1. 총학생수 | 7. 종료");
			}else{
				System.out.println("1. 총학생수 | 2.목록 | 3.입력 | 4.삭제 | 5. 최고점수 | 6. 평균 | 7. 종료");
			}
			System.out.println("-------------------------------------------------");
			System.out.print("선택: ");
			String choice = scanner.nextLine();
			
			if(choice.equals("1")){
				System.out.print("총학생수: ");
				int totalNum = Integer.parseInt(scanner.nextLine());
				students = new String[totalNum][];
			}else if(choice.equals("2")){
				System.out.println("******************************************");
				System.out.println("학번\t\t이름\t\t점수");
				System.out.println("******************************************");
//				if(students != null){
					for (String[] student : students) {
						if(student != null){
							System.out.println(student[0] + "\t\t" + student[1] + "\t\t" + student[2]);
						}
					}
//				}

			}else if(choice.equals("3")){
				System.out.print("이름: ");
				String name = scanner.nextLine();
				System.out.print("점수: ");
				String score = scanner.nextLine();
				for(int i=0; i<students.length; i++){
					if(students[i] == null){
						String[] student = { String.valueOf(i), name, score };
						students[i] = student;
						break;
					}
				}
			}else if(choice.equals("4")){
				System.out.print("삭제할 학번: ");
				int sno = Integer.parseInt(scanner.nextLine())-1;
				if(students[sno] != null){
					students[sno] = null;
					System.out.println("삭제했습니다\n");
				}else{
					System.out.println("없는 학번입니다\n");
				}
				
			}else if(choice.equals("5")){
				int max = 0;
				for(String[] student : students){
					if(student != null){
						int score = Integer.parseInt(student[2]);
						if (max < score) {
							max = score;
						}
					}
				}

				System.out.println("******************************************");
				System.out.println("학번\t\t이름\t\t점수");
				System.out.println("******************************************");				
				
				for(String[] student : students){
					if(student != null){
						int score = Integer.parseInt(student[2]);
						if (max == score) {							
							System.out.println(student[0] + "\t\t" + student[1] + "\t\t" + student[2]);
						}
					}
				}
				System.out.println("최대값: " + max);
			}else if(choice.equals("6")){
				int count = 0;
				int sum = 0;
				for(String[] student : students){
					if(student != null){
						count++;
						sum += Integer.parseInt(student[2]);
					}
				}
				System.out.println("평점: " + (double)sum/count);
			}else if(choice.equals("7")){
				break;
			}
			
		}
	}

}

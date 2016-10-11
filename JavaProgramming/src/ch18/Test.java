package ch18;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> numberList = new ArrayList<Integer>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            String[] numStrList = input.split(" ");
            for (String numStr : numStrList) {
                numberList.add(Integer.parseInt(numStr));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 다음과 같은 방식으로 numberList와 number 변수를 사용할 수 있음
        /*
        for (Integer number : numberList) {            }
        */

        // write your code here
        int cnt=0;
        int avg=0;
//        DecimalFormat df = new DecimalFormat("##.#");
        for(Integer number : numberList){
        	avg+=number;
        	cnt++;
        }
        double num = avg/(double)cnt;
//        System.out.printf("%.1f", num);
        System.out.println(String.format("%.1f", num));

    }
}
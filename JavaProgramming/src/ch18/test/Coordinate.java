package ch18.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Coordinate {
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
        for (Integer number : numberList) {
            System.out.println(number);
        }

    }
}
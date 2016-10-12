package ch18.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CharacterSequence {
    public static void main(String[] args) {
        String[] words = null;
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            words = line.split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 다음과 같은 방식으로 words와 word 변수를 사용할 수 있음
        /*
        for (String word : words) {
            System.out.println(word);
        }
        */
    }
}
package ch18.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RevPlus {
    public static void main(String[] args) {
        int number = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            number = Integer.parseInt(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuffer sb = new StringBuffer(number);
        sb = sb.reverse();
        System.out.println( sb.toString()); 
        // write your code here
    }
}

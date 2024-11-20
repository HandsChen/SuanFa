package 背包九讲;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {
    public static void main(String[] args) {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try {
            String a=br.readLine();
            System.out.println(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

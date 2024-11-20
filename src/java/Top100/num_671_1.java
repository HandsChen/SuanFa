package Top100;

import java.util.HashMap;
import java.util.Stack;

public class num_671_1 {
    public static void main(String[] args) {
        String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println(countSubstrings(s));
    }
    public static int countSubstrings(String s) {
        int len=s.length();

        int count=0;
        HashMap<String,Integer> hs=new HashMap<String,Integer>();
        for(int i=0;i<len;i++){
            for(int j=i+1;j<=len;j++){
                String subString=s.substring(i,j);

                //
                if(isHuiWen(subString)){
                    count++;
                }
            }
        }
        return count;

    }
    public static Boolean isHuiWen(String s){

        int len=s.length();
        if(len==0)
            return false;

        if(len==1)
            return true;

        Stack stack=new Stack();

        for(int i=0;i<len;i++){
            stack.push(s.charAt(i));
        }

        for(int i=0;i<len;i++){
            char ch= (char) stack.pop();

            if(ch!=s.charAt(i)){
                return false;
            }
        }

        return true;


    }

}

package Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num_438 {
    public static void main(String[] args) {
        String s="cbaebabacd";
        String p="abc";
        System.out.println(findAnagrams(s,p));

    }
    public static List<Integer> findAnagrams(String s, String p) {

        //首先得到p的长度
        int len_p=p.length();
        //然后得到s的长度
        int len_s=s.length();

        char[] ch=p.toCharArray();
        List<Integer> list=new ArrayList<Integer>();
        //对p进行一个排序
        Arrays.sort(ch);
        //再转会来
        String newP=new String(ch);
       // System.out.println(newP);
        //对s进行遍历
        for(int i=0;i<len_s;i++){

            if((i+len_p)<=len_s){
                //进行截取
                String str=s.substring(i,i+len_p);
                //对截取的进行排序
                char[] ch1=str.toCharArray();
                //对p进行一个排序
                Arrays.sort(ch1);
                //再转会来
                String newCur=new String(ch1);
                if(newCur.equals(newP)){
                    list.add(i);

                }


            }

        }
        //将list返回

        return list;
    }
}

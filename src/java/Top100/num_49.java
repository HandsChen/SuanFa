package Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class num_49 {
    public static void main(String[] args) {

    }
    public List<List<String>> groupAnagrams(String[] strs) {

        int len=strs.length;
        if(len==0)
            return new ArrayList();

        //新建一个hash
        HashMap<String,List> hs=new HashMap<String,List>();
        for(String s:strs){

            //将其转换为char
            char[] ch=s.toCharArray();
            //排序
            Arrays.sort(ch);

            //将排序后的转化为String key
            String key=String.valueOf(ch);

            //判断
            if(!hs.containsKey(key)){
                hs.put(key,new ArrayList());
            }
            hs.get(key).add(s);
        }

        return new ArrayList(hs.values());

    }
}

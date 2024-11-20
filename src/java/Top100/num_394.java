package Top100;

import java.util.*;

public class num_394 {
    public static void main(String[] args) {

        String s="3[a]2[b4[F]c]";
        System.out.println(decodeString(s));


    }
    public static String decodeString(String s) {
        if(s.length()==0)
            return "";

        if(s.length()==1)
            return s;

        //进入正题
        Stack<String> opNum=new Stack<String>();
        Stack<Character> opChar=new Stack<Character>();
        List<Character> list=new ArrayList<Character>();
        List<Character> list1=new ArrayList<Character>();
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if(ch>='0'&&ch<='9'){
                list1.add(ch);
            }

            if(ch=='[') {
                opChar.push(ch);
                //将list1种的数字压入数字栈
                String res="";
                for(Character item:list1){
                    res=res+item;
                }

                opNum.push(new String(res));

                list1.clear();


            }

            if(ch>='a'&&ch<='z'||ch>='A'&&ch<='Z'){
                opChar.push(ch);

            }

            if(ch==']'){

                char ch1=opChar.pop();
                String ch2=opNum.pop();
                int curNum=Integer.parseInt(ch2);

                while (ch1!='['){

                    list.add(ch1);
                    ch1=opChar.pop();


                }

                //如果opChar不为空
                for(int j=0;j<curNum;j++){

                    for(int m=list.size()-1;m>=0;m--){
                        opChar.push(list.get(m));

                    }

                }


                //清空list
                list.clear();

            }





        }
        while(!opChar.empty()){
            char ch=opChar.pop();
            ans.append(ch);
        }
        return ans.reverse().toString();


    }
}

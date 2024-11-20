package Top100;

import java.util.Stack;

public class num_20 {
    public static void main(String[] args) {
        System.out.println(isValid("(("));

    }
    public static boolean isValid(String s) {

        int len=s.length();
        if(len==0){
            return true;
        }
        if(len==1){
            return false;
        }

        //建立一个堆栈
        Stack stack=new Stack();
        //从左往右遍历

        //第一个符号入栈
        stack.add(s.charAt(0));
        for(int i=1;i<len;i++){
            //如果栈里面一个元素都没有，那么直接将当前元素入栈
            if(stack.size()==0){
                stack.add(s.charAt(i));
                continue;
            }
            char c1= s.charAt(i);
            char c2=(char)stack.peek();
            //判断第一个字母是不是左半括号
            if(jungeLeft(c2)){
                //判断第二个字母是不是和第一个字母相匹配
                if(match(c2,c1)){
                    //如果匹配成功
                    stack.pop();
                    continue;

                }else {
                    //如果匹配失败，判断c1是不是右括号
                    if(jungeRight(c1)){
                        //如果是那么就直接返回非法·
                        return false;

                    }else {
                        //如果也是左括号，那么就入栈
                        stack.add(c1);
                        continue;
                    }

                }


            }else {
                //如果不是，那么直接返回非法
                return false;

            }

        }
        //如果到了最后栈为空，那么就说明合法
        if(stack.empty())
            return true;
        else
            return false;


    }
    public static boolean jungeLeft(char c1){

        boolean result=false;
        switch (c1){
            case '(': result=true;break;
            case '[': result=true;break;
            case '{': result=true;break;

        }
        return result;

    }
    public static boolean match(char c1,char c2){

        if(c1=='('&&c2==')')
            return true;
        if(c1=='['&&c2==']')
            return true;
        if(c1=='{'&&c2=='}')
            return true;


        return false;


    }
    public static boolean jungeRight(char c1){

        boolean result=false;
        switch (c1){
            case ')': result=true;break;
            case ']': result=true;break;
            case '}': result=true;break;

        }
        return result;

    }
}

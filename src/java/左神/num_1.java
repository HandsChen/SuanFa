package 左神;

import java.util.Stack;

public class num_1 {
    public static void main(String[] args) {
        myStack ms=new myStack();
        ms.push(3);
        ms.push(5);
        System.out.println(ms.getMin());
        ms.pop();
        ms.push(1);
        System.out.println(ms.getMin());

    }
    public static class myStack{
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        myStack(){
            stack1=new Stack<Integer>();
            stack2=new Stack<Integer>();
        }

        public void push(int num){
            if(this.stack1.isEmpty()){
                stack1.push(num);
            }else{
                if(num<stack1.peek()){
                    stack1.push(num);
                }
            }
            stack2.push(num);
        }
        public int pop(){

            int val;
            if(stack2.isEmpty()){
                throw new RuntimeException("当前栈为空");
            }else {
                val=stack2.pop();
                if(stack1.peek()==val){
                    stack1.pop();
                }
            }
            return val;
        }

        public int getMin(){
            if(stack1.isEmpty()){
                throw new RuntimeException("不存在最小值");
            }else {
                return stack1.peek();
            }
        }

    }
}

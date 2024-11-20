package Top100;

import java.util.Stack;

public class num_234 {
    public static void main(String[] args) {

    }
    public boolean isPalindrome(ListNode head) {
        if(head==null)
            return true;

        //将链表中的数放入一个堆栈里面

        ListNode cur=head;

        Stack stack=new Stack();
        while(cur!=null){
            stack.add(cur.val);
            cur=cur.next;
        }
        while(stack.size()>0){
            int num= (int) stack.pop();
            if(num!=head.val)
                return false;
            head=head.next;
        }
        return true;

    }
}

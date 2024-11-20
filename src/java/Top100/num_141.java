package Top100;

public class num_141 {
    public static void main(String[] args) {

    }
    public static boolean hasCycle(ListNode head) {
      //定义两个指针，一个快指针，一个慢指针，两个指针同时走，那么如果快指
        if(head==null)
            return false;
        if(head.next==null)
            return false;
        ListNode slow,fast;
        slow=head;
        fast=head;
        boolean flag=false;
        while(fast!=null){
            if(slow==fast){
                if(flag)
                    return true;
                else
                    flag=true;

            }
            slow= slow.next;
            if(fast.next==null){
                return false;
            }
            if(fast.next.next==null){
                return false;
            }
            fast=fast.next.next;
        }
        return false;
    }
}

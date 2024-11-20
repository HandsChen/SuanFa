package Top100;

public class num_142 {
    public static void main(String[] args) {

    }
    public ListNode detectCycle(ListNode head) {

        //首先得到环中得节点
        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null&&slow!=null){
            fast=fast.next;
            if(fast==null)
                return null;
            fast=fast.next;
            if(fast==null)
                return null;
            if(fast==slow){
                break;
            }
        }

        //相遇得节点必定在环中,通过该节点得到环种节点得数目
        int count=0;
        ListNode cur=slow;
        while(cur!=null){
            cur=cur.next;
            count++;
            if(cur==slow){
                break;
            }
        }

        fast=head;
        slow=head;
        //让fast节点向前先走count步
        for(int i=0;i<count;i++){
            fast=fast.next;
        }

        //然后fast和slow一起走
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }

        return slow;

    }
}

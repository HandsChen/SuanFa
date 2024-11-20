package Top100;

public class num_21 {
    public static void main(String[] args) {
        ListNode l1_1=new ListNode(1);
        ListNode l1_2=new ListNode(2);
        ListNode l1_4=new ListNode(4);

        ListNode l2_1=new ListNode(1);
        ListNode l2_3=new ListNode(3);
        ListNode l2_4=new ListNode(4);

        l1_1.next=l1_2;
        l1_2.next=l1_4;

        l2_1.next=l2_3;
        l2_3.next=l2_4;

        ListNode head=mergeTwoLists(l1_1,l2_1);

        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1==null&&l2==null)
            return null;
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;

        ListNode cur1,cur2; //定义两个指针
        ListNode head=new ListNode();
        ListNode ans=head;
        cur1=l1;
        cur2=l2;
        while(cur1!=null && cur2!=null){
            int a=cur1.val;
            int b=cur2.val;
            if(a<=b){
                head.next=cur1;
                cur1= cur1.next;
            }else {
                head.next=cur2;
                cur2= cur2.next;
            }
            head=head.next;
        }
        //跳出来说明有这么几种情况 1.链表1结束 2.链表2结束，3列表1和2均结束
        if(cur1==null){
            head.next=cur2;
        }
        if(cur2==null){
            head.next=cur1;
        }
        return ans.next;

    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

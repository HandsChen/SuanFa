package Top100;

public class num_206 {
    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;

        show(node1);
        show(reverseList(node1));

    }
    public static ListNode reverseList(ListNode head) {

        if(head==null)
            return null;
        ListNode newHead= reverseList(head.next);
        if(newHead==null)
            newHead=head;
        ListNode cur=newHead;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=head;
        head.next=null;
        return newHead;
    }
    public static void show(ListNode head){
        while(head!=null){
            System.out.print(head.val);
            System.out.print(" ");
            head=head.next;
        }
        System.out.println();
    }
}
//class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) { val = x; }
//}
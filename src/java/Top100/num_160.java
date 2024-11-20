package Top100;

public class num_160 {
    public static void main(String[] args) {

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA==null)
            return null;
        if(headB==null)
            return null;
        int lenA = 0;
        int lenB=0;
        ListNode curA =headA;
        ListNode curB =headB;
        while(curA!=null){
            lenA++;
            curA=curA.next;
        }
        while(curB!=null){
            lenB++;
            curB=curB.next;
        }
        //指针回到初始位置
        curA =headA;
        curB =headB;

        //判断哪个长
        if(lenA >lenB){
            for(int i=0;i<(lenA-lenB);i++){
                curA=curA.next;
            }
        }
        if(lenB >lenA){
            for(int i=0;i<(lenB-lenA);i++){
                curB=curB.next;
            }
        }
        //这个时候初始长度一样了
        while (curA!=null||curB!=null){
            if(curA==curB)
                return curA;
            else {
                curA=curA.next;
                curB=curB.next;
            }
        }
        return null;

    }
}

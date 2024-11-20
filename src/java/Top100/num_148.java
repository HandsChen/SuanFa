package Top100;

import java.util.Arrays;

public class num_148 {
    public static void main(String[] args) {

        ListNode node4=new ListNode(4);
        ListNode node2=new ListNode(2);
        ListNode node1=new ListNode(1);
        ListNode node3=new ListNode(3);

        node4.next=node2;
        node2.next=node1;
        node1.next=node3;

        System.out.println(sortList(node4).val);


    }
    public static ListNode sortList(ListNode head) {

        //首先得到链表的节点数目
        ListNode cur=head;
        int count=0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }

        cur=head;
        int[] nums=new int[count];
        count=0;
        //将链表中的所有数放入数组中
        while(cur!=null){
            nums[count++]=cur.val;
            cur=cur.next;
        }
        //对数组进行归并排序
        int[] finalNums=Guibing(nums);

        ListNode dead=new ListNode();
        ListNode cur1=dead;
        //重新构造为链表
        for (int i=0;i<finalNums.length;i++){
            dead.next=new ListNode(finalNums[i]);
            dead=dead.next;
        }

        return cur1.next;

    }
    public static int[] Guibing(int[] nums){
        //终止条件
        if(nums.length<2)
            return nums;

        int mid=nums.length/2;

        int[] left= Arrays.copyOfRange(nums,0,mid);
        int[] right=Arrays.copyOfRange(nums,mid,nums.length);

        return merge(Guibing(left),Guibing(right));


    }
    public static int[] merge(int[] left,int[] right){

        //新建一个结果数组
        int res[]=new int[left.length+right.length];

        int i=0;
        //进行归并
        while(left.length>0&&right.length>0){

            if(left[0]<=right[0]){

                res[i++]=left[0];
                left=Arrays.copyOfRange(left,1,left.length);

            }else {
                res[i++]=right[0];
                right=Arrays.copyOfRange(right,1,right.length);

            }

        }
        //将剩下的继续归并
        while (left.length>0){
            res[i++]=left[0];
            left=Arrays.copyOfRange(left,1,left.length);
        }
        while (right.length>0){
            res[i++]=right[0];
            right=Arrays.copyOfRange(right,1,right.length);
        }
        return res;

    }
}

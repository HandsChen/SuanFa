package Top100;

import java.util.HashMap;

public class num_236 {

    public static void main(String[] args) {
        TreeNode node3=new TreeNode(3);
        TreeNode node5=new TreeNode(5);
        TreeNode node1=new TreeNode(1);
        TreeNode node6=new TreeNode(6);
        TreeNode node2=new TreeNode(2);
        TreeNode node7=new TreeNode(7);
        TreeNode node4=new TreeNode(4);
        TreeNode node0=new TreeNode(0);
        TreeNode node8=new TreeNode(8);

        node3.left=node5;
        node3.right=node1;

        node5.left=node6;
        node5.right=node2;

        node2.left=node7;
        node2.right=node4;

        node1.left=node0;
        node1.right=node8;

        TreeNode res=lowestCommonAncestor(node3,node5,node1);

        System.out.println(res.val);





    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //新建一个hashmap
        HashMap<Integer,Integer> hs=new HashMap<Integer,Integer>();
        hs.put(root.val,root.val);
        getHashPair(root,hs);
        return new TreeNode(getComParrent(hs,p.val,q.val,root.val));

    }
    public static void getHashPair(TreeNode root,HashMap<Integer,Integer> hs){
        if(root==null)
            return;
        //根目录的节点是其自己
        if(root.left!=null){
            hs.put(root.left.val,root.val);
            getHashPair(root.left,hs);
        }
        if(root.right!=null){
            hs.put(root.right.val,root.val);
            getHashPair(root.right,hs);
        }

    }
    public static int getComParrent(HashMap<Integer,Integer> hs,int p,int q,int end){

        HashMap<Integer,Boolean> flag=new HashMap<Integer,Boolean>();
        flag.put(end,true);

        while (p!=end){
            flag.put(p,true);
            p=hs.get(p);
        }

        while (!flag.containsKey(q)){
            q=hs.get(q);

        }
        return q;
    }
}

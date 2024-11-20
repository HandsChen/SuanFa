package Top100;

public class num_98 {
    static boolean res=true;
    public static void main(String[] args) {
        TreeNode node_1=new TreeNode(1);
        TreeNode node_1_1=new TreeNode(1);
        node_1.left=node_1_1;
        System.out.println(isValidBST(node_1));
    }
    public static boolean isValidBST(TreeNode root) {



        return search(root,Integer.MIN_VALUE,Integer.MAX_VALUE);


    }
    public static boolean search(TreeNode root,int low,int high){

        if(root==null){
            return true;
        }

        if(root.val<=low||root.val>=high){
            return false;

        }

        return search(root.left,low,root.val)&&search(root.right,root.val,high);

    }
}

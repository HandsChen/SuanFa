package Top100;

public class num_538 {

    public static void main(String[] args) {

    }
    public static TreeNode convertBST(TreeNode root) {

        final TreeNode finalRoot=root;
        TreeNode head=BSTsearch(root,finalRoot);

        return head;
    }
    public static TreeNode BSTsearch(TreeNode root,TreeNode finalRoot){
        if(root==null)
            return null;

        int sum= root.val;
        sum=sum+sumDFS(finalRoot,root.val);

        TreeNode node= new TreeNode(sum);

        TreeNode nodeLeft=null;
        TreeNode nodeRight=null;
        if(root.left!=null)
            nodeLeft=BSTsearch(root.left,finalRoot);
        if(root.right!=null)
            nodeRight=BSTsearch(root.right,finalRoot);

        node.left=nodeLeft;
        node.right=nodeRight;
        return node;
    }
    public static int sumDFS(TreeNode node,int condition){
        if(node==null)
            return 0;
        int sum=0;
        if (node.val>condition)
            sum=node.val;
        int LeftSum=0;
        int RightSum=0;
        if(node.left!=null){
            LeftSum=sumDFS(node.left,condition);
        }
        if(node.right!=null){
            RightSum=sumDFS(node.right,condition);
        }

        return sum+LeftSum+RightSum;
    }
}

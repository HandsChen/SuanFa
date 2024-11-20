package Top100;

public class num_114 {
    public static void main(String[] args) {


    }
    public void flatten(TreeNode root) {

            while(root!=null){
                if(root.left==null){
                    //进行下一个节点
                    root=root.right;
                }else {
                    //存在左子树
                    //找到左子树的最右节点
                    TreeNode pre=root.left;
                    while(pre.right!=null){
                        pre=pre.right;
                    }
                    //将右子树嫁接到左子树的最右节点
                    pre.right=root.right;
                    //将左子树移动到右子树原来的位置
                    root.right=root.left;
                    root.left=null;//原来左子树置空

                    //进行下一个节点
                    root=root.right;
                }
            }

    }


}

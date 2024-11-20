package Top100;

import java.util.Arrays;

public class num_105 {
    public static void main(String[] args) {

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int len1=preorder.length;
        int len2=inorder.length;

        if(len1==0||len2==0){
            return null;

        }

        //
        TreeNode root=new TreeNode(preorder[0]);

        //定位到根节点
        for(int i=0;i<len2;i++){
            if(inorder[i]==root.val){

                int[] pre_left= Arrays.copyOfRange(preorder,1,i+1);
                int[] pre_right= Arrays.copyOfRange(preorder,i+1,len1);

                int[] in_left=Arrays.copyOfRange(inorder,0,i);
                int[] in_right=Arrays.copyOfRange(inorder,i+1,len2);

                //进行连接
                root.left=buildTree(pre_left,in_left);
                root.right=buildTree(pre_right,in_right);


            }
        }
        return root;

    }
}

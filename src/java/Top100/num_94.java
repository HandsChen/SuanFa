package Top100;

import java.util.ArrayList;
import java.util.List;

public class num_94 {
    public static void main(String[] args) {

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null)
            return new ArrayList();

        List<Integer> left=new ArrayList<>();
        List<Integer> right=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        if(root.left!=null){
            left= inorderTraversal(root.left);
        }
        if(root.right!=null){
            right= inorderTraversal(root.right);
        }
        res.addAll(left);
        res.add(root.val);
        res.addAll(right);
        return res;

    }
}

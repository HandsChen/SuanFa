package Top100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class num_102 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res=new ArrayList<>();

        BSF(root, res);

        return res;



    }
    public static  void BSF(TreeNode root, List<List<Integer>> res){
        if(root==null)
            return;

        Queue<TreeNode> q1=new LinkedList<TreeNode>();
        Queue<TreeNode> q2=new LinkedList<TreeNode>();

        List<Integer> l1=new ArrayList<Integer>();
        List<Integer> l2=new ArrayList<Integer>();

        q1.add(root);
        while (true) {
            while (!q1.isEmpty()) {

                TreeNode current = q1.poll();
                l1.add(current.val);
                if (current.left != null) {
                    q2.add(current.left);
                }
                if (current.right != null) {
                    q2.add(current.right);
                }

            }
            if(l1.size()!=0){
                res.add(new ArrayList(l1));
                l1.clear();
            }

            while (!q2.isEmpty()) {
                TreeNode current = q2.poll();
                l2.add(current.val);
                if (current.left != null) {
                    q1.add(current.left);
                }
                if (current.right != null) {
                    q1.add(current.right);
                }


            }
            if(l2.size()!=0){
                res.add(new ArrayList(l2));
                l2.clear();
            }

            //如果q1和q2都为空
            if(q1.size()==0&&q2.size()==0){
                break;
            }
        }


    }
}

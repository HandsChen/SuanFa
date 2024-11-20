package Top100;

public class num_337 {
    public static void main(String[] args) {


    }
    public static int rob(TreeNode root) {
        int[] res=robIntel(root);

        return Math.max(res[0],res[1]);

    }
    public static int[] robIntel(TreeNode root) {

        if(root==null){
            return new int[2];
        }

        int[] left=robIntel(root.left);
        int[] right=robIntel(root.right);

        int[] res=new int[2];

        //如果不偷
        res[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);

        //如果偷
        res[1]=left[0]+right[0]+root.val;
        return res;




    }
}

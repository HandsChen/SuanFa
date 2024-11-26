package common;

public class TreeUtil {
    //获取树节点的高度
    public static int height(TreeNode node) {
        //叶节点的高度为 0 ，而空节点的高度为 −1
        return node == null ? -1 : node.getHeight();
    }

    //更新节点高度
    public static void updateHeight(TreeNode node) {
        node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
    }

    //获取平衡因子 设平衡因子为 f ，则一棵 AVL 树的任意节点的平衡因子皆满足 −1 ≤ f ≤ 1 。
    public static int balanceFactor(TreeNode node) {
        //空节点平衡因子为0
        if (node == null) {
            return 0;
        }
        //节点平衡因子 = 左子树高度 - 右子树高度
        return height(node.getLeft()) - height(node.getRight());
    }
}

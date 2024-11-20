package Hello算法.二叉搜索树;

import common.TreeNode;

public class BinarySearchTree {
    /**
     * 二叉搜索树算法
     * 时间复杂度: 二叉搜索树的时间复杂度分析首先需要看二叉树的客观形态是什么样的，如果二叉树为链表时
     * 那么其时间复杂度最差，此时为O(n),而当二叉树为平衡树或者完全二叉树，其时间复杂度最好，此时为O(log𝑛)
     * 空间复杂度: 因为不需要额外的栈空间，因此其空间复杂度为O(1)
     *
     * @param root   遍历根节点
     * @param target 目标值
     * @return 返回目标值的节点指针，如果没有找到则返回空
     */
    static TreeNode binarySearch(TreeNode root, int target) {
        TreeNode curNode = root;
        while (null != curNode) {
            if (curNode.getVal() == target) { //如果找到目标节点，则返回该节点
                return curNode;
            } else if (curNode.getVal() < target) { //指针指向右子树
                curNode = curNode.getRight();
            } else if (curNode.getVal() > target) { //指针指向右s子树
                curNode = curNode.getLeft();
            }
        }
        return null;
    }

    /**
     * 向二叉树中插入一个节点
     *
     * @param root   树的根节点 （可以为空）
     * @param target 要插入的目标值
     */
    static void insertTreeNode(TreeNode root, int target) {
        //1.首先要判断二叉树是否为空
        if (null == root) {
            root = new TreeNode(target); //初始化一个
            return;
        }
        //2.如果二叉树不为空,那么就遍历二叉树
        TreeNode curNode = root;
        TreeNode preNode = null;
        while (null != curNode) {
            preNode = curNode; //存放前置节点
            if (curNode.getVal() == target) { //如果该数已经被插入,那么放弃插入
                return;
            } else if (curNode.getVal() < target) { //指针指向右子树
                curNode = curNode.getRight();
            } else if (curNode.getVal() > target) { //指针指向右s子树
                curNode = curNode.getLeft();
            }
        }

        //3.将目标数插入到前置节点
        if (target > preNode.getVal()) {
            preNode.setRight(new TreeNode(target));
        } else {
            preNode.setLeft(new TreeNode(target));
        }
    }

    /**
     * 从搜索二叉树中删除一个节点
     *
     * @param root   树的根节点 （可以为空）
     * @param target 要删除的目标值
     */
    static void deleteTreeNode(TreeNode root, int target) {
        if (null == root) { //如果树的根节点不存在，那么就直接返回
            return;
        }
        //1.在二叉树中搜索该节点（有存在和不存在两种情况）
        TreeNode curNode = root;
        TreeNode preNode = null;
        while (null != curNode) {
            if (curNode.getVal() == target) { //如果找到了该节点，那么就直接跳出循环
                break;
            } else if (target > curNode.getVal()) { //说明要寻找的值是在当前节点的右子树
                preNode = curNode; //保存当前节点，并记录为前置节点
                curNode = curNode.getRight();
            } else if (target < curNode.getVal()) {//说明要寻找的值在左子树
                preNode = curNode;
                curNode = curNode.getLeft();
            }
        }
        //此时跳出循环共有要搜索的值存在和不存在两种情况
        if (null == curNode) {
            return; //如果树中没有目标值对应的节点，那么就直接返回
        }
        //2.如果树中存在目标值对应的节点，此时又分为三种情况，即该节点下有几个节点。0个 / 1个 / 2个
        if (curNode.getLeft() == null && curNode.getRight() == null) { //0个，说明是叶子节点
            curNode = null; //置空等待GC去回收
            return; //删除成功
        } else if (curNode.getLeft() != null && curNode.getRight() != null) {
            //2个，这个时候如果要删除当前节点，那么应该使用当前节点左子树的值最大节点或者右子树的值的最小节点替换当前节点
            //这里选择右子树的最小节点
            TreeNode tmpNode = curNode.getRight();
            TreeNode minNodeOfRightTree = null;
            while (tmpNode != null) { //执行中序遍历
                minNodeOfRightTree = tmpNode;
                tmpNode = tmpNode.getLeft();
            }
            //当跳出循环时，当前pre节点即为右字数的最小节点 （中序遍历）
            //这个时候对目标节点进行删除
            if (minNodeOfRightTree.getVal() > preNode.getVal()) {
                preNode.setRight(minNodeOfRightTree);
            } else {
                preNode.setLeft(minNodeOfRightTree);
            }
            minNodeOfRightTree.setRight(tmpNode);
            //清空minNodeOfRightTree的父
        } else { //1个，如果是1个，那么就使用其子节点替换该节点
            TreeNode childNode = null;
            if (curNode.getLeft() != null) {
                childNode = curNode.getLeft();
            } else if (curNode.getRight() != null) {
                childNode = curNode.getRight();
            }
            if (childNode.getVal() > preNode.getVal()) {
                preNode.setRight(childNode); //将当前节点的孩子节点挂载到当前节点的上一个节点的右树上
            } else {
                preNode.setLeft(childNode);
            }
            //删除当前节点
            curNode.setLeft(null);
            curNode.setRight(null);
        }

    }


    public static void main(String[] args) {
        TreeNode node_1 = new TreeNode(1);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_4 = new TreeNode(4);
        TreeNode node_5 = new TreeNode(5);
        TreeNode node_6 = new TreeNode(6);
        /*
                 4
                / \
               2   5
              / \   \
             1   3   6
         */
        node_4.setLeft(node_2);
        node_4.setRight(node_5);
        node_2.setLeft(node_1);
        node_2.setRight(node_3);
        node_5.setRight(node_6);
        System.out.println("binarySearch(node_1,7) = " + binarySearch(node_4, 6));
        insertTreeNode(node_4, 8);
    }
}

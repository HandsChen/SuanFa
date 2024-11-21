package Hello算法.二叉搜索树;

import common.TreeNode;
import common.TreeOperation;

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
     * @return 1: 成功 0:失败 -1:删除的是根节点
     */
    static int deleteTreeNode(TreeNode root, int target) {
        if (null == root) { //如果树的根节点不存在，那么就直接返回
            return 0;
        }
        //1.在二叉树中搜索该节点（有存在和不存在两种情况）
        TreeNode curNode = root;
        TreeNode preNode = null;
        while (null != curNode) {
            if (curNode.getVal() == target) { //如果找到了该节点，那么就直接跳出循环
                break;
            } else if (target > curNode.getVal()) { //说明要寻找的值是在当前节点的右子树
                preNode = curNode;
                curNode = curNode.getRight();
            } else if (target < curNode.getVal()) {//说明要寻找的值在左子树
                preNode = curNode;
                curNode = curNode.getLeft();
            }
        }
        //此时跳出循环共有要搜索的值存在和不存在两种情况
        if (null == curNode) {
            return 0; //如果树中没有目标值对应的节点，那么就直接返回
        }
        //2.如果树中存在目标值对应的节点，此时又分为三种情况，即该节点下有几个节点。0个 / 1个 / 2个
        if (curNode.getLeft() == null && curNode.getRight() == null) { //0个，说明是叶子节点
            if (null == preNode) { //删除的是根节点
                return -1;
            } else {
                if (curNode.getVal() > preNode.getVal()) {
                    preNode.setRight(null);
                } else {
                    preNode.setLeft(null);
                }
                return 1;
            }
        } else if (curNode.getLeft() != null && curNode.getRight() != null) {
            //2个，这个时候如果要删除当前节点，那么应该使用当前节点左子树的值最大节点或者右子树的值的最小节点替换当前节点
            //这里选择右子树的最小节点
            TreeNode tmpNode = curNode.getRight();
            TreeNode minNodeOfRightTree = null;  //定义右子树的最小节点
            while (tmpNode != null) { //执行中序遍历
                minNodeOfRightTree = tmpNode;
                tmpNode = tmpNode.getLeft();
            }
            int minNodeOfRightTreeVal = minNodeOfRightTree.getVal(); //防止被修改
            //当跳出循环时，当前minNodeOfRightTree节点即为右子树的最小节点 （中序遍历）
            //从右子树中删除minNodeOfRightTree使得其脱离
            int deletingRoot = deleteTreeNode(curNode.getRight(), minNodeOfRightTreeVal);
            if (deletingRoot == -1) {
                curNode.setRight(null); //删除当右子树根节点为删除目标值时，删除该节点
            }
            //删除目标节点,其实就是把val植覆盖
            curNode.setVal(minNodeOfRightTreeVal);
            return 1;
        } else { //1个，如果是1个，那么就使用其子节点替换该节点
            TreeNode childNode = null;
            if (curNode.getLeft() != null) {
                childNode = curNode.getLeft();
            } else if (curNode.getRight() != null) {
                childNode = curNode.getRight();
            }
            curNode.setVal(childNode.getVal());
            //删除当前节点
            curNode.setLeft(childNode.getLeft());
            curNode.setRight(childNode.getRight());

            childNode.setRight(null);
            childNode.setLeft(null);
            return 1;
        }

    }

    static void remove(TreeNode root, int target) {
        // 若树为空，直接提前返回
        if (root == null) {
            return;
        }
        TreeNode cur = root, pre = null;
        // 循环查找，越过叶节点后跳出
        while (cur != null) {
            // 找到待删除节点，跳出循环
            if (cur.getVal() == target) {
                break;
            }
            pre = cur;
            // 待删除节点在 cur 的右子树中
            if (cur.getVal() < target) {
                cur = cur.getRight();
            }
            // 待删除节点在 cur 的左子树中
            else {
                cur = cur.getLeft();
            }
        }

        // 如果无待删除的节点，那么直接返回
        if (null == cur) {
            return;
        }
        //如果当前要删除的节点有一个或无节点
        if (null == cur.getLeft() && null == cur.getRight()) {
            // 当子节点数量 = 0 / 1 时， child = null / 该子节点
            TreeNode child = cur.getLeft() != null ? cur.getLeft() : cur.getRight();
            if (root != cur) { //如果当前要删除的节点不是根节点
                if (pre.getLeft() == cur) { //使用其子节点代替当前节点
                    pre.setLeft(child);
                } else {
                    pre.setRight(child);
                }
            } else { //如果要删除的节点为根节点
                root = child; //使用根节点的孩子节点代替当前根节点
            }
        } else {
            //寻找当前节点右子树的最小值(中序遍历搜寻)
            TreeNode tmpRoot = cur.getRight();
            while (tmpRoot.getLeft() != null) { //指针滑向当前节点右子树的最小值(中序遍历搜寻)
                tmpRoot = tmpRoot.getLeft(); //一直向左边找
            }
            //从当前节点右子树中删除最小值节点
            remove(cur.getRight(),tmpRoot.getVal());
            //用最小值的节点中的值替换当前节点
            cur.setVal(tmpRoot.getVal());
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
        System.out.println("______________插入节点前的树形态_________________");
        TreeOperation.show(node_4);
        insertTreeNode(node_4, 8);
        System.out.println("______________插入节点以后的树形态_________________");
        TreeOperation.show(node_4);
        deleteTreeNode(node_4, 5);
        System.out.println("______________删除节点以后的树形态(方法一，自己想)_________________");
        TreeOperation.show(node_4);
        System.out.println("______________删除节点以后的树形态（方法二，参考pdf）_________________");
        deleteTreeNode(node_4, 4);
        TreeOperation.show(node_4);
    }
}

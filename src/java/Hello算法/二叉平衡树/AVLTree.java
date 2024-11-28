package Hello算法.二叉平衡树;

import common.TreeNode;
import common.TreeUtil;

public class AVLTree {

    //右旋操作 node为当前已经失衡的节点
    TreeNode rightRotate(TreeNode node) {
        TreeNode child = node.getLeft();
        TreeNode grand_child = child.getRight();
        //开始右旋，以child为中点进行旋转
        child.setRight(node);
        node.setLeft(grand_child);
        //更新高度
        TreeUtil.updateHeight(node);
        TreeUtil.updateHeight(child);
        return child;
    }

    //左旋操作 node为当前已经失衡的节点
    TreeNode leftRotate(TreeNode node) {
        TreeNode child = node.getRight();
        TreeNode grand_child = child.getLeft();
        //开始右旋，以child为中点进行旋转
        child.setLeft(node);
        node.setRight(grand_child);
        //更新高度
        TreeUtil.updateHeight(node);
        TreeUtil.updateHeight(child);
        return child;
    }

    //通用的旋转方法
    TreeNode rotate(TreeNode node) {
        //首先获得失衡节点的平衡因子
        int balanceFactor = TreeUtil.balanceFactor(node);
        if (balanceFactor > 1) { //左偏树
            if (TreeUtil.balanceFactor(node.getLeft()) < 0) {
                //先左旋转后右旋
                node.setLeft(leftRotate(node.getLeft()));
            }
            return rightRotate(node);
        } else if (balanceFactor < -1) { //右偏树
            if (TreeUtil.balanceFactor(node.getLeft()) > 0) {
                //先右旋转后左旋
                node.setRight(rightRotate(node.getRight()));
            }
            return leftRotate(node);
        } else {
            return node; //已经平衡直接返回
        }
    }

//    //插入节点
//    void insert(int val) {
//        root = insertHelper(root, val);
//    }

    /*
    递归插入节点（辅助方法）
    * */
    TreeNode insertHelper(TreeNode node, int val) {
        if (node == null) { //如果根节点不存在，那么初始化一个节点
            return new TreeNode(val);
        }
        //查找插入的位置并插入节点
        return null;
    }
}

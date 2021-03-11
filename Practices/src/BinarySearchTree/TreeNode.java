package BinarySearchTree;

//public class TreeNode{
//    public int key;
//    public TreeNode left;
//    public TreeNode right;
//
//    public TreeNode(int value) {
//        this.key = value;
//    }
//
//}

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
package BinarySearchTree;

import java.util.HashSet;
import java.util.Set;

public class lowestCommonAncestorIV {

    public TreeNode lowestCommonAncestorIV(TreeNode root, TreeNode[] nodes) {
        Set<TreeNode> s = new HashSet<>();
        for (TreeNode node: nodes) {
            s.add(node);
        }

        return helper(root, s);
    }

    private TreeNode helper(TreeNode root, Set<TreeNode> set) {
        if (root == null || set.contains(root)) {
            return root;
        }

        TreeNode left = helper(root.left, set);
        TreeNode right = helper(root.right, set);

        if (left != null && right != null) {
            return root;
        } else {
            return left == null ? right : left;
        }

    }
}

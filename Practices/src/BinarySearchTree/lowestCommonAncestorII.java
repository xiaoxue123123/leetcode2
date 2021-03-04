package BinarySearchTree;

public class lowestCommonAncestorII {
    boolean pFound = false;
    boolean qFound = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode result = LCA(root, p, q);
        return pFound && qFound ? result : null;
    }

    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode leftResult = LCA(root.left, p, q);
        TreeNode rightResult = LCA(root.right, p, q);

        if (root == p) {
            pFound = true;
            return root;
        }

        if (root == q) {
            qFound = true;
            return root;
        }


        if (leftResult != null && rightResult != null) {
            return root;
        }

        return leftResult == null ? rightResult : leftResult;


    }
}

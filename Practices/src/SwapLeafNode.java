

public class SwapLeafNode {
    public int mystery(TreeNode root) {
        // sanity check
        if (root == null) {
            return -1;
        }

        // base case
        // if root is leaf node, return 0.
        if (root.left == null && root.right == null) {
            return 0;
        }

        // recursion rule
        int sum = mystery(root.left) + mystery(root.right);

        // swap left tree and right tree under condition
        // A + B == 0; A = 0 and B = 0 or A = -B.
        // only returns -1 or 0, so A and B both have to be 0, which
        // means root.left and root.right are both leaf node.

        if (sum == 0) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }
        return -1;

    }


}

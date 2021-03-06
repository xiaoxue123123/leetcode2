package BinarySearchTree;

public class FindDistance {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    boolean sameTree = false;

    public int findDistance(TreeNode root, int p, int q) {
        if (root == null || p == q) {
            return 0;
        }

        int depthP = depth(root, p, q);
        int depthQ = depth(root, q, p);
        // System.out.println(sameTree + "  " + depthP + "   " + depthQ);

        if (sameTree) {
            if (depthP > depthQ) {
                return depthP - depthQ;
            } else {
                return depthQ - depthP;
            }
        } else {
            return depthP + depthQ - 2;
        }

    }

    private int depth(TreeNode root, int n, int n2) {
        int res = 0;
        if (root == null) {
            return 0;
        }
        if (root.val == n) {
            return 1;
        }


        int leftResult = depth(root.left, n, n2);
        int rightResult = depth(root.right, n, n2);
        if (leftResult > 0 && root.left.val == n2) {
            // System.out.println(n2);
            sameTree = true;
            // return leftResult + 1;
        }
        if (rightResult > 0 && root.right.val == n2) {
            //      System.out.println(n2);

            sameTree = true;
            // return rightResult + 1;
        }

        if (leftResult == 0 && rightResult == 0) {
            return 0;
        } else {
            return leftResult > 0 ? leftResult + 1 : rightResult + 1;
        }
    }
}
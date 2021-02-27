public class CounsinsBT {

    class TreeNode {
     TreeNode left;
     TreeNode right;
     TreeNode parent;
     TreeNode() {};
    }

    /**
     * assumption:
     * the treenode has pointer to parent, otherwise, we lose control of root.
     * <p>
     * TreeNode {
     * TreeNode left;
     * TreeNode right;
     * TreeNode parent;
     * }
     * <p>
     * cousin:
     * 1. same level
     * 2. different parents => distance from node to LCA > 1
     * <p>
     * <p>
     * 1. find level
     * 1.1 if level different, return false.
     * 2. go up until meet, at the same time, count distance to LCA.
     * 2.1 if distance = 1, return false.
     * 2.2 if can't meet, return false.
     * return true.
     * <p>
     * TC: O(tree height)
     * SC: O(tree height)
     * <p>
     * test:
     * 6
     * <p>
     * /     \
     * <p>
     * 3            5
     * <p>
     * /     \      /     \
     * <p>
     * 7       8    1       2
     **/

    public boolean isCousin(TreeNode one, TreeNode two) {
        if (one == null || two == null) {
            return false;
        }

        int d1 = findDepth(one);
        int d2 = findDepth(two);

        if (d1 != d2) {
            return false;
        }

        int dToLCA = 0;
        while (one !=two) {
            one = two.parent;
            one = two.parent;
            dToLCA++;
        }
        return dToLCA == 1 ? false : true;
    }

    private int findDepth(TreeNode node) {
        int d = 0;
        while (node != null) {
            node = node.parent;
            d++;
        }
        return d;
    }


}

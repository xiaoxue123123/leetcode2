import java.util.ArrayList;
import java.util.List;

public class Tree {

     static class TreeNode {
         public int key;
         public TreeNode left;
         public TreeNode right;
         public TreeNode(int key) {
             this.key = key;
         }
    }

    TreeNode root;


    public TreeNode constructTree(Integer[] array) {
        if (array.length == 0) {
            return null;
        }

        return constructTreeHelper(array, root,0);
    }

    private TreeNode constructTreeHelper(Integer[] array, TreeNode root, int i) {
        if (i < array.length) {
            TreeNode temp = new TreeNode(array[i]);
            root = temp;

            root.left = constructTreeHelper(array, root.left, 2*i + 1);
            root.right = constructTreeHelper(array, root.right, 2*i + 2);

        }
        return root;
    }

    public static void main(String[] args) {
        Tree solution = new Tree();
        Integer[] array = new Integer[] {8, 2, 9, 28};
        solution.constructTreeHelper(array, solution.root,0);
    }


}

import java.util.LinkedList;
import java.util.Queue;

public class Deserialize {
//    public TreeNode deserialize(String data) {
//        String[] strs = data.split(",");
//        TreeNode root = strs[0].equals("null") ? null : new TreeNode(Integer.valueOf(strs[0]));
//        // make a queue
//        // offer root
//        Queue<TreeNode> q = new LinkedList<TreeNode>();
//        q.offer(root);
//        int i = 0;
//        // loop while queue is not empty
//        while (!q.isEmpty() && i <= strs.length / 2 - 1) {
//            // pop cur
//            TreeNode cur = q.poll();
//            if (cur != null) {
//                // connect cur to left, if left no null, offer left
//                TreeNode left = strs[2*i + 1].equals("null") ? null : new TreeNode(Integer.valueOf(strs[2*i + 1]));
//                if (left != null) {
//                    cur.left = left;
//                }
//                q.offer(left);
//
//                // do the same with right
//                TreeNode right = strs[2*i + 2].equals("null") ? null : new TreeNode(Integer.valueOf(strs[2*i + 2]));
//                if (right != null) {
//                    cur.right = right;
//                }
//                q.offer(right);
//            }
//            i++;
//        }
//        return root;
//    }
public TreeNode deserialize(String data) {
    String[] strs = data.split(",");
    Queue<TreeNode> parent = new LinkedList<>();
    TreeNode root = strs[0].equals("null") ? null : new TreeNode(Integer.valueOf(strs[0]));
    parent.offer(root);
    int i = 1;
    while(!parent.isEmpty()) {
        Queue<TreeNode> children = new LinkedList<>();
        while(!parent.isEmpty()) {
            TreeNode node = parent.poll();
            if(node!=null) {
                if(i< strs.length && !strs[i].equals("null")){
                    node.left = new TreeNode(Integer.valueOf(strs[i++]));
                } else {
                    i++;
                }
                if(i< strs.length && !strs[i].equals("null")){
                    node.right = new TreeNode(Integer.valueOf(strs[i++]));
                } else {
                    i++;
                }
                children.offer(node.left);
                children.offer(node.right);
            }
        }
        parent = children;
    }
    return root;
}
    public static void main(String[] args) {
        Deserialize solution = new Deserialize();
        String input = "1,2,3,null,null,4,5,7,8";
        TreeNode root = solution.deserialize(input);
    }
}

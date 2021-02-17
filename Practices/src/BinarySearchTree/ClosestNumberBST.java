package BinarySearchTree;
import com.sun.source.tree.Tree;

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ClosestNumberBST {
    public int[] closestKValues(TreeNode root, double target, int k) {
        // Write your solution here


        PriorityQueue<Integer> pq = new PriorityQueue<>(10, new Comparator<Integer>(){
            @Override
            public int compare(Integer one, Integer two) {
                return Math.abs(one - target) > Math.abs(two - target) ? 1 : -1;
            }
        });

        inorder(root,pq);
        List<Integer> array = new ArrayList<>();
        int count = 0;
        while (!pq.isEmpty() && count < k) {
            array.add(pq.poll());
            count++;
        }

        int size = array.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = array.get(i);
        }
        Arrays.sort(result);
        return result;


    }

    private void inorder(TreeNode root, PriorityQueue<Integer> pq) {
        if (root == null) {
            return;
        }
        inorder(root.left, pq);
        pq.offer(root.key);
        inorder(root.right, pq);
    }

    public static void main(String[] args) {
        ClosestNumberBST s = new ClosestNumberBST();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(8);
        int[] res = s.closestKValues(root,3,1);
        System.out.println(res);
    }
}

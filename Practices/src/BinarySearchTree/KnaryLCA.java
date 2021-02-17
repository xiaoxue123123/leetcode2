package BinarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;

public class KnaryLCA {
    public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, KnaryTreeNode a, KnaryTreeNode b) {
        // Write your solution here
        System.out.println(" root: " + root.key + " a : " + a.key + " b: " + b.key);
        if (root == null || root == a || root == b) {
            System.out.println("root is " + root.key);
            return root;
        }

        boolean hasA = false;
        boolean hasB = false;
        for (KnaryTreeNode child: root.children) {
            KnaryTreeNode node = lowestCommonAncestor(child,a,b);
            if (node == a) {
                hasA = true;
            }
            if (node == b) {
                hasB = true;
            }
        }
        if (hasA && hasB) {
            System.out.println("root here is " + root.key);
            return root;
        }
        if (hasA) {
            System.out.println("a is " + a.key);
            return a;
        }
        if (hasB) {
            System.out.println("b is " + b.key);
            return b;
        }
        return null;
    }
    public static void main(String[] args) {
        KnaryTreeNode five = new KnaryTreeNode(5);
        KnaryTreeNode nine = new KnaryTreeNode(9);
        KnaryTreeNode twelve = new KnaryTreeNode(12);
        KnaryTreeNode one = new KnaryTreeNode(1);
        KnaryTreeNode two = new KnaryTreeNode(2);
        KnaryTreeNode three = new KnaryTreeNode(3);
        KnaryTreeNode fourteen = new KnaryTreeNode(14);
        five.children = new ArrayList<>(Arrays.asList(nine, twelve));
        nine.children = new ArrayList<>(Arrays.asList(one, two,three));
        twelve.children = new ArrayList<>(Arrays.asList(fourteen));
        KnaryLCA s = new KnaryLCA();
        KnaryTreeNode result = s.lowestCommonAncestor(five, two, fourteen);
        System.out.println(result.key);
    }


}

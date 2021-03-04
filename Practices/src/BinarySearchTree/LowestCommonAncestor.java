package BinarySearchTree;

public class LowestCommonAncestor {
     // Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }



        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            TreeNode cur = root;
            while (cur != null) {
                if (cur.val > p.val && cur.val > q.val) {
                    cur = cur.left;
                } else if (cur.val < p.val && cur.val < q.val) {
                    cur = cur.right;
                } else {
                    return cur;
                }
            }
            return null;

        }

        public static void main(String[] args) {
//          int[] array = {1,2,3};
//         String str = String.valueOf(array);
//         String str2 = String.valueOf(array);
//         System.out.println(str.equals(str2));
//
            char[] cnt = new char[26];
            String s = "eat";
            for (char c: s.toCharArray()) {
                cnt[c - 'a']++;
                // System.out.println(cnt[c - 'a']);
            }
            String key = String.valueOf(cnt);

            char[] cnt1 = new char[26];
            String s1 = "tea";
            for (char c: s1.toCharArray()) {
                cnt1[c - 'a']++;
                // System.out.println(cnt[c - 'a']);
            }
            String key1 = String.valueOf(cnt1);
            System.out.println(key.equals(key1));
            System.out.println(key.toString());
            System.out.println(key1.toString());

        }
        }

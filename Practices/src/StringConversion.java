public class StringConversion {
    public static void main(String[] args) {
        System.out.println(null + " hi");
        System.out.println(1.13 + 5 + " hi");
        System.out.println((double) 1.13 + 5 + " hi");
        System.out.println((float) 1.13 + 5 + " hi");
        System.out.println((byte) 1 + " hi");
        // largest number for long type
        System.out.println((long)9223372036854775807L + " hi");


        String s2 = (char)(60 + 1) + "s";
        System.out.println(s2);
//        long num1 = (long)10 + 5.0;

//        int num2 = (int)(1.5 + (double)2);
//
//        char c = (char)"a";
        TreeNode head = new TreeNode(0);
        head.left = new TreeNode(1);
        head.right = new TreeNode(2);
        String s3 = head + " hi";
        System.out.println(s3);

        System.out.println('a');

        int i;
        System.out.println((i = 5) > 3);
    }
}

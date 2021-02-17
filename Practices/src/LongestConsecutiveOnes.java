public class LongestConsecutiveOnes {
    public int longestConsecutiveOnes(int[] nums, int k) {
        int slow = 0;
        int fast = 0;
        int count = 0;
        int longest = 0;
        while (fast < nums.length) {
            if (nums[fast] == 1) {
                longest = Math.max(longest, ++fast - slow);
            } else if (count < k) {
                count++;
                longest = Math.max(longest, ++fast - slow);
            } else if (nums[slow++] == 0) {
                count--;
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        LongestConsecutiveOnes s = new LongestConsecutiveOnes();
        int[] input = new int[]{1,0,1,0,1,1};
        int longest = s.longestConsecutiveOnes(input, 1);
        //System.out.print(longest);
        int[] num = new int[]{0,1,2,3};
        int slow = 0;
        if (slow++ == 0) {
            System.out.print(slow);
        }
        System.out.print(slow);


    }
}

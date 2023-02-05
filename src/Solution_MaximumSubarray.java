/**
 * https://leetcode.com/problems/maximum-subarray/description/
 */
public class Solution_MaximumSubarray {

    // Kadane's algorithm
    public int maxSubArray(int[] nums) {
        int[] partial = new int[nums.length];

        for (int end = 0; end < nums.length; end++) {
            if (end == 0) {
                partial[end] = nums[end];
            } else {
                int self =  nums[end];
                int combined = partial[end - 1] + nums[end];
                partial[end] = Math.max(self, combined);
            }
        }

        int maxSum = partial[0];
        for (int sum : partial) {
            if (sum > maxSum) {
                maxSum = sum;
            }
        }

        return maxSum;
    }

    // Simple O(n^2) approach
    public int maxSubArray_Simple(int[] nums) {
        int maxSum = nums[0];

        for (int end = 0; end < nums.length; end++) {
            int rangeSum = nums[end];
            for (int start = end; start >= 0; start--) {

                if (start != end) {
                    rangeSum += nums[start];
                }

                if (rangeSum > maxSum) {
                    maxSum = rangeSum;
                    // Record the start and end index values
                }
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        var solve = new Solution_MaximumSubarray();
        solve.test(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6);
        solve.test(new int[]{5, 4, -1, 7, 8}, 23);
        solve.test(new int[]{1}, 1);
        solve.test(new int[]{1, -3, 2, 1, -1}, 3);
        solve.test(new int[]{-2,1}, 1);
    }

    private void test(int[] nums, int expected) {
        if (maxSubArray(nums) == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }
}

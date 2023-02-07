import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class Solution_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int index1 = -1, index2 = -1;

        // Simple case: O(n)
        if (target % 2 == 0) {
            int half = target / 2;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == half) {
                    if (index1 == -1) {
                        index1 = i;
                        continue;
                    }

                    // Using an index twice not allowed
                    if (i != index1) {
                        return new int[]{index1, i};
                    }
                }
            }
        }

        // General case: Build a hash index
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int match = target - nums[i];
            map.putIfAbsent(match, i);
        }

        // Look for hash index mappings
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                index1 = i;
                index2 = map.get(nums[i]);

                // Using an index twice not allowed
                if (index1 != index2) {
                    break;
                }
            }
        }

        return new int[]{index1, index2};
    }

    public static void main(String[] args) {
        var solve = new Solution_TwoSum();
        solve.test(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1});
        solve.test(new int[]{3, 2, 4}, 6, new int[]{1, 2});
        solve.test(new int[]{3, 3}, 6, new int[]{0, 1});
        solve.test(new int[]{3, 1, 2, 5, 3}, 6, new int[]{0, 4});
        solve.test(new int[]{2, 4, 11, 3}, 6, new int[]{0, 1});
    }

    void test(int[] nums, int target, int[] indexes) {
        int[] twoSum = twoSum(nums, target);
        Arrays.sort(indexes);
        Arrays.sort(twoSum);

        if (Arrays.equals(twoSum, indexes)) {
            System.out.println("PASS");
        } else {
            System.out.print("FAIL: ");
            System.out.print(Arrays.toString(twoSum));
            System.out.print(", Expected: ");
            System.out.println(Arrays.toString(indexes));
        }
    }
}

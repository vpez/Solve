import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution_ContainsDuplicate solve = new Solution_ContainsDuplicate();
        solve.test(new int[]{1, 2, 3, 1}, true);
        solve.test(new int[]{1, 2, 3, 4}, false);
        solve.test(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true);
    }

    void test(int[] nums, boolean expected) {
        if (containsDuplicate(nums) == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }
}

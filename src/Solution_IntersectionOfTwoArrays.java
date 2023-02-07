import java.util.Arrays;

public class Solution_IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Sorting both arrays to avoid O(n^2) complexity
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // Simplify by knowing which arrays is bigger or equal
        int[] big, small;
        if (nums1.length >= nums2.length) {
            big = nums1;
            small = nums2;
        } else {
            big = nums2;
            small = nums1;
        }

        int[] match = new int[big.length];

        int i = 0, j = 0;
        while (i < big.length && j < small.length) {
            if (big[i] < small[j]) {
                i++;
            } else if (big[i] > small[j]) {
                j++;
            } else {
                // Remember that the value at the current index is a match
                match[i] = 1;
                i++;
                j++;
            }
        }

        // How many matches did we see
        int matchSize = 0;
        for (int bit : match) matchSize += bit;

        // Gathering the final result
        int[] intersection = new int[matchSize];
        int current = 0;
        for (int k = 0; k < match.length; k++) {
            if (match[k] == 1) {
                intersection[current++] = big[k];
                // We assumed that we always pick from the bigger array
            }
        }

        return intersection;
    }

    public static void main(String[] args) {
        var solve = new Solution_IntersectionOfTwoArrays();
        solve.test(new int[]{1, 2, 2, 1}, new int[]{2, 2}, new int[]{2, 2});
        solve.test(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}, new int[]{4, 9});
    }

    void test(int[] nums1, int[] nums2, int[] nums3) {
        int[] intersect = intersect(nums1, nums2);

        Arrays.sort(intersect);
        Arrays.sort(nums3);

        if (Arrays.equals(intersect, nums3)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }
}

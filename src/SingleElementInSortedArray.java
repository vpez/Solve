class SingleElementInSortedArray {

    public static void main(String[] args) {
        SingleElementInSortedArray solution = new SingleElementInSortedArray();
        int[] nums1 = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(solution.singleNonDuplicate(nums1));

        int[] nums2 = {1, 1, 2};
        System.out.println(solution.singleNonDuplicate(nums2));

        int[] nums3 = {3, 3, 7, 7, 10};
        System.out.println(solution.singleNonDuplicate(nums3));
    }

    public int singleNonDuplicate(int[] nums) {
        return singleNonDuplicate(nums, 0, nums.length - 1);
    }

    private int singleNonDuplicate(int[] nums, int start, int end) {
        // base case
        if (start == end) {
            return nums[start];
        }
        int divide = start + ((end - start) / 2);

        // divide
        if (nums[divide] == nums[divide + 1]) {
            divide--;
        } else if (nums[divide] != nums[divide - 1]) {
            // base case
            return nums[divide];
        }

        // recursive for odd subarray
        int leftSize = divide - start + 1;
        if (leftSize % 2 == 1) {
            // left subarray has odd length
            return singleNonDuplicate(nums, start, divide);
        } else {
            // right subarray has odd length
            return singleNonDuplicate(nums, divide + 1, end);
        }
    }
}
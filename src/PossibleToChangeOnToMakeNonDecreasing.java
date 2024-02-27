class PossibleToChangeOnToMakeNonDecreasing {
    public static void main(String[] args) {
        var solution = new PossibleToChangeOnToMakeNonDecreasing();
        System.out.println(solution.solution(new int[]{-1, 0, 1})); // true
        System.out.println(solution.solution(new int[]{1, 4, 2, 3})); // true
        System.out.println(solution.solution(new int[]{2, 3, 3, 2, 4})); // true
        System.out.println(solution.solution(new int[]{-1, 4, 2, 3})); // true
        System.out.println(solution.solution(new int[]{4, 2, 1})); // false
        System.out.println(solution.solution(new int[]{1})); // true
        System.out.println(solution.solution(new int[]{3, 4, 2, 3})); // false
    }

    boolean solution(int[] nums) {
        boolean changed = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) continue;
            
	    if (changed) return false;
   
	    changed = true;
            
	    if (i == nums.length - 1) continue;
            
	    // prev, prev, current, next
	    if (i > 1 && nums[i - 2] > nums[i] && nums[i - 1] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}

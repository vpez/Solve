import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 * Based on Kadane's algorithm
 */
public class Solution_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        char[] characters = str.toCharArray();

        // Stores the maximum unique substring size up to i-th index
        int[] partial = new int[str.length()];

        int start = 0;
        for (int end = 0; end < partial.length; end++) {
            char letter = characters[end];
            if (end == 0) {
                partial[end] = 1;
            } else {
                // What if we add this to the previous tail?

                // work with arrays, instead of:
                // substr = str.substr(start, end + 1), to be inclusive 'end'
                int subSize = (end + 1) - start;
                char[] substr = new char[subSize];
                System.arraycopy(characters, start, substr, 0, substr.length);

                if (hasNoDuplicates(substr)) {
                    partial[end] = partial[end - 1] + 1; // add this letter
                } else {
                    // reset the start index to where we noticed duplicate and skip it (+1)
                    // work with arrays, instead of:
                    // start = str.substr(0, end).lastIndexOf(letter) + 1
                    // gives the last index where we saw the duplicate letter and skips it
                    for (int i = end - 1; i >= 0; i--) {
                        if (characters[i] == letter) {
                            start = i + 1;
                            break;
                        }
                    }
                    partial[end] = (end - start) + 1; // this will be the size of new substring from start to end (inclusive)
                }
            }
        }

        // Get the max
        Arrays.sort(partial);
        return partial[partial.length - 1];
    }

    private boolean hasNoDuplicates(char[] characters) {
        Arrays.sort(characters);
        for (int i = 0; i < characters.length - 1; i++) {
            if (characters[i] == characters[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var solve = new Solution_LongestSubstringWithoutRepeatingCharacters();
        System.out.println(solve.lengthOfLongestSubstring("abc")); // 3
        System.out.println(solve.lengthOfLongestSubstring("abcd")); // 4
        System.out.println(solve.lengthOfLongestSubstring("abcc")); // 3
        System.out.println(solve.lengthOfLongestSubstring("abcdeabdexr")); // 6
        System.out.println(solve.lengthOfLongestSubstring("dvdf")); // 3
    }
}

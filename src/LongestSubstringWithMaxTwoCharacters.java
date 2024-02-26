import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class LongestSubstringWithMaxTwoCharacters {
    public static void main(String[] args) {
        var app = new LongestSubstringWithMaxTwoCharacters();
        String s1 = "aabxyziab";
        System.out.println(s1 + " " + app.solution(s1));

        String s2 = "abceeeeecceefga";
        System.out.println(s2 + " " + app.solution(s2));

        String s3 = "xxxaaay";
        System.out.println(s3 + " " + app.solution(s3));

        String s4 = "abcdef";
        System.out.println(s4 + " " + app.solution(s4));
    }

    private int solution(String str) {
        int[] partial = new int[str.length()];
        int start = 0;
        char[] characters = str.toCharArray();
        for (int end = 1; end < characters.length; end++) {
            if (hasAtMostTwoCharacters(characters, start, end)) {
                partial[end] = partial[end - 1] + 1;
            } else {
                while (!hasAtMostTwoCharacters(characters, start, end)) {
                    start++;
                }
                partial[end] = end - start;
            }
        }
        Arrays.sort(partial);
        return partial[partial.length - 1];
    }

    private boolean hasAtMostTwoCharacters(char[] characters, int begin, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = begin; i < end; i++) {
            set.add(characters[i]);
        }
        return set.size() <= 2;
    }
}

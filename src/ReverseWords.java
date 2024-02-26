import java.util.*;
import java.util.stream.Collectors;

public class ReverseWords {
    public static void main(String[] args) {
        var app = new ReverseWords();
        System.out.println(app.reverseWordsNewbie("    the sky is blue    "));
        System.out.println(app.reverseWords("a"));
        System.out.println(app.reverseWords("a b c d "));
    }

    public String reverseWordsNewbie(String s) {
        List<String> words = Arrays.stream(s.split(" ")).filter(str -> !str.isEmpty()).toList();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = words.size() - 1; i >= 0; i--) {
            stringBuilder.append(words.get(i));
            if (i != 0) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public String reverseWords(String s) {
        char[] characters = s.toCharArray();
        char[] reverse = new char[findReverseSize(characters)];
        int start, end = characters.length - 1;
        int index = 0;
        while (index < reverse.length) {
            end = findEndIndex(characters, end);
            start = findStartIndex(characters, end);
            index = collectWord(characters, start, end, reverse, index);
            end = start - 1;
        }

        return new String(reverse);
    }

    private int findReverseSize(char[] characters) {
        int reverseLength = 0;
        // remember if the last seen character was a whitespace
        boolean isSpace = true;
        for (char ch : characters) {
            // any non-whitespace character should be counted
            if (!Character.isWhitespace(ch)) {
                reverseLength++;
                isSpace = false;
            } else if (!isSpace && Character.isWhitespace(ch)) {
                // when switching from a non-space to a whitespace we should include it
                // because we need at least one whitespace between the words
                reverseLength++;
                isSpace = true;
            }
        }

        // we do not need to keep the trailing whitespace e.g. "a b c d "
        if (isSpace) {
            reverseLength--;
        }
        return reverseLength;
    }

    private int findEndIndex(char[] chars, int limit) {
        while (limit >= 0 && Character.isWhitespace(chars[limit])) {
            limit--;
        }
        return limit;
    }

    private int findStartIndex(char[] chars, int end) {
        int start = end;
        while (start >= 0 && !Character.isWhitespace(chars[start])) {
            start--;
        }
        return start + 1;
    }

    private int collectWord(char[] chars, int start, int end, char[] reverse, int index) {
        int length = end - start + 1;
        System.arraycopy(chars, start, reverse, index, length);
        index += length;

        if (index < reverse.length) {
            reverse[index++] = ' ';
        }
        return index;
    }
}

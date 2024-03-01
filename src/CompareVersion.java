/**
 * https://leetcode.com/problems/compare-version-numbers/description/
 */
public class CompareVersion {
    public static void main(String[] args) {
        var app = new CompareVersion();
        System.out.println(app.compareVersion("1.01", "1.001"));
        System.out.println(app.compareVersion("1.0", "1.0.0"));
        System.out.println(app.compareVersion("0.1", "1.1"));
        System.out.println(app.compareVersion("1.0", "1.0.0.1"));
    }

    public int compareVersion(String version1, String version2) {
        char[] chars1 = version1.toCharArray();
        char[] chars2 = version2.toCharArray();
        int i = 0, j = 0, v1, v2, dot;
        while (i < chars1.length && j < chars2.length) {
            dot = nextDot(chars1, i);
            v1 = toInt(chars1, i, dot);
            i = dot + 1;

            dot = nextDot(chars2, j);
            v2 = toInt(chars2, j, dot);
            j = dot + 1;

            if (v1 > v2) return 1;
            else if (v1 < v2) return -1;
        }

        while (i < chars1.length) {
            dot = nextDot(chars1, i);
            if (toInt(chars1, i, dot) > 0) return 1;
            i = dot + 1;
        }

        while (j < chars2.length) {
            dot = nextDot(chars2, j);
            if (toInt(chars2, j, dot) > 0) return -1;
            j = dot + 1;
        }

        return 0;
    }

    private int toInt(char[] chars, int start, int end) {
        int n = 0;
        for (int i = start; i < end; i++) {
            n = n * 10 + (chars[i] - '0');
        }
        return n;
    }

    private int nextDot(char[] chars, int start) {
        for (int i = start + 1; i < chars.length; i++) {
            if (chars[i] == '.') {
                return i;
            }
        }
        return chars.length;
    }
}

public class WhitespaceCorrection {
    /**
     * Given a string of words and whitespaces, correct the whitespaces such that there
     * is exactly one whitespace between each word. The sentence should not start or
     * finish with a whitespace.
     */
    public static void main(String[] args) {
        var app = new WhitespaceCorrection();
        System.out.println(app.correction("   Good  morning sir   "));
        System.out.println(app.correction("Lorem     ipsum dolor  sit amet"));
        System.out.println(app.correction(" "));
        System.out.println(app.correction(""));
        System.out.println(app.correction("a"));
        System.out.println(app.correction("\tHello\nWorld "));
    }

    public String correction(String s) {
        char[] chars = s.toCharArray();
        boolean space = true;
        int size = 0;
        for (char c : chars) {
            if (!Character.isWhitespace(c)) {
                size++;
                space = false;
            } else if (!space && Character.isWhitespace(c)) {
                size++;
                space = true;
            }
        }
        if (space) {
            size--;
        }

        if (size < 0) return "";

        char[] result = new char[size];
        int start = 0, index = 0, len = chars.length;
        while (index < size) {
            while (start < len && Character.isWhitespace(chars[start])) start++;
            int end = start;
            while (end < len && !Character.isWhitespace(chars[end])) end++;
            int wordLength = end - start;
            System.arraycopy(chars, start, result, index, wordLength);
            index += wordLength;
            if (index < size) {
                result[index++] = ' ';
            }
            start = end;
        }

        return new String(result);
    }
}

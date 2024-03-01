import java.util.*;

public class SetOrderExamples {
    public static void main(String[] args) {
        List<String> values = List.of("One", "one", "OnE", "TWO", "two");

        // TreeSet uses Comparator for equality check
        Set<String> set1 = new TreeSet<>(values);
        System.out.println(set1);

        Set<String> set2 = new TreeSet<>(String::compareToIgnoreCase);
        set2.addAll(values);
        System.out.println(set2);

        // Example: Count number of unique words, find the short and longest words
        String text = """
                When she returns to the forum page, her post is there. It is a way now,
                 approximately, of being at home. The forum has become one of the most consistent places in her life,
                  like a familiar cafe that exists somehow outside of geography and beyond time zones.""";
        StringTokenizer tokenizer = new StringTokenizer(text, " \t\n\r\f,.");
        Set<String> uniqueWords = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        SortedSet<String> wordsLength = new TreeSet<>(Comparator.comparing(String::length));
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            uniqueWords.add(word);
            wordsLength.add(word);
        }
        System.out.println("Unique words: " + uniqueWords.size());
        System.out.println("Shortest word: " + wordsLength.first());
        System.out.println("Longest word: " + wordsLength.last());

        // Equality of Sets: Asymmetry problem
        Set<String> hashSet = new HashSet<>(List.of("abc", "ABC"));
        Set<String> treeSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        treeSet.addAll(List.of("abc", "123"));
        System.out.println("treeSet.contains(\"ABC\") = " + treeSet.contains("ABC"));
        System.out.println(hashSet.equals(treeSet));
        System.out.println(treeSet.equals(hashSet));


    }
}

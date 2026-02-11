import java.util.HashSet;
import java.util.Set;

// made static due to main method calling this class
public static nt lengthOfLongestSubstringOptimal(String s) {
    Set<Character> set = new HashSet<>();

    int left = 0;
    int maxLength = 0;

    for (int right = 0; right < s.length(); right++) {

        while (set.contains(s.charAt(right))) {
            set.remove(s.charAt(left));
            left++;
        }

        set.add(s.charAt(right));
        maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
}

// getting into the habit of adding a test suite -> could we tidy up the below at some point?
public static void main(String[] args) {

    test("abcabcbb", 3);
    test("bbbbb", 1);
    test("pwwkew", 3);
    test("", 0);
    test("a", 1);
    test("abba", 2);
    test("dvdf", 3);
    test("tmmzuxt", 5);
}

private static void test(String input, int expected) {
    int result = lengthOfLongestSubStringOptimal(input);
    System.out.println(
            "Input : \"" + input + "\" | Expected: " + expected + " | Got: " + result
    );
}
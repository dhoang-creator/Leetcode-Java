import java.util.HashSet;
import java.util.Set;

public int lengthOfLongestSubstringNaive(String s) { // O(n^2)
    int maxLength = 0;

    for (int left = 0; left < s.length(); left++) { // O(n)
        Set<Character> set = new HashSet<>();

        // should j be initialised to 0?
        for (int right = left; right < s.length(); right++) { // O(n)

            // placeholder to move to new set
            char currentChar = s.charAt(j);

            if (set.contains(currentChar)) {
                break; // duplicate found
            }

            set.add(currentChar);
            maxLength = Math.max(maxLength, right - left + 1); // invariant rule -> how was this determined?
        }
    }

    return maxLength;
}

public int lengthOfLongestSubStringNaiveCondensed(String s) {
    for (int left = 0; left < s.length(); left++) {
        Set<Character> set = new HashSet<>();

        for (int right = left; right < s.length(); right++) {
            if (!set.add(s.charAt(right))) {
                break;
            }
        }
    }
    // note in this example, it's more confusing and no return variable
}
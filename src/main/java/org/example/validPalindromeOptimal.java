public boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
        while (left < right && !Character.isLetterOrDigits(s.charAt(left))) {
            left++; // skips invalid chars -> total O(n)
        }
        while (left < right && !Character.isLetterOrDigits(s.chatAt(right))) {
            right--; // skips invalid chars -> total O(n)
        }

        if (Character.toLowerCase(s.charAt(left)) !=
            Character.toLowerCase(s.charAt(right)) {
                return false; // O(1)
            }

            left++; // O(1)
            right--; // O(1)
    }
    return true; // O(1)
}

public boolean isPalindromeCorrect(String s) {
    if (s.isEmpty()) {
        return true;
    }
    int start = 0;
    int last = s.length() -1;
    while (start <= last) {
        char currFirst = s.charAt(start);
        char currLast = s.charAt(last);
        if (!Character.isLetterOrDigit(currFirst)) {
            start++;
        } else if (!Character.isLetterOrDigit(currLast)) {
            last--;
        } else {
            if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                return false;
            }
            start++;
            last--;
        }
    }
    return true;
}

public boolean isPalindrome(String s) {
    // Step 1: clean the string
    StringBuilder cleaned = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
        char c = s.chatAt(i);
        if (Character.isLetterOrDigit(c)) {
            cleaned.append(Character.toLowerCase(c));
        }
    }

    // Step 2: reverse and compare
    String original = cleaned.toString();
    String reversed = cleaned.reverse().toString();

    // because technically, when you reverse a palindrome, it's just the same as the OG
    return original.equals(reversed);
}

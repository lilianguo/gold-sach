/*
76. Minimum Window Substring

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"

Note:

    If there is no such window in S that covers all characters in T, return the empty string "".
    If there is such window, you are guaranteed that there will always be only one unique minimum window in S.



*/
class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> countMap = constructMap(t);
        int index = 0, slow = 0, minLen = Integer.MAX_VALUE, matchCount = 0;
        for (int fast = 0; fast < s.length(); fast++) {
            char c = s.charAt(fast);
            Integer count = map.get(c);
            if (count == null) {
                continue;
            }
            map.put(c, count - 1);
            if (count == 1) {
                matchCount++;
            }
            while(matchCount == countMap.size()) {
                if (fast - slow + 1 < minLen) {
                    minLen = fast - slow + 1;
                    index = slow;
                }
                char leftMost = s.charAt(slow++);
                Integer leftMostCount = map.get(leftMost);
                if (leftMostCount == null) {
                    continue;
                }
                countMap.put(leftMost, leftMostCount + 1);
                if (leftMostCount == 0) {
                    matchCount--;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(index, index + minLen);
    }
}
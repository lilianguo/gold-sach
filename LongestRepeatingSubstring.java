/*
1062. Longest Repeating Substring
Given a string S, find out the length of the longest repeating substring(s). Return 0 if no repeating substring exists.

 

Example 1:

Input: "abcd"
Output: 0
Explanation: There is no repeating substring.

Example 2:

Input: "abbaba"
Output: 2
Explanation: The longest repeating substrings are "ab" and "ba", each of which occurs twice.

Example 3:

Input: "aabcaabdaab"
Output: 3
Explanation: The longest repeating substring is "aab", which occurs 3 times.

Example 4:

Input: "aaaaa"
Output: 4
Explanation: The longest repeating substring is "aaaa", which occurs twice.

 

Note:

    The string S consists of only lowercase English letters from 'a' - 'z'.
    1 <= S.length <= 1500


*/

/*


Time complexity : O(Nlog⁡N)in the average case and O(N^2)in the worst case. 
One needs O((N−L)L) for one duplicate check, 
and one does up to O(log N) checks. Together that results in O(∑L(N−L)L)
 i.e. in O(Nlog⁡N)\mathcal{O}(N \log N)O(NlogN) in the average case and in O(N^2)in the worst case of L close to N/2.

Space complexity : O(N^2) to keep the hashset. 
*/
class LongestRepeatingSubstring {
    /*
    Search a substring of given length L
    that occurs at least 2 times.
    Return start position if the substring exits and -1 otherwise.
    */
  public int search(int L, int n, String S) {
    HashSet<String> seen = new HashSet();
    String tmp;
    for(int start = 0; start < n - L + 1; ++start) {
      tmp = S.substring(start, start + L);
      if (seen.contains(tmp)) return start;
      seen.add(tmp);
    }
    return -1;
  }

  public int longestRepeatingSubstring(String S) {
    int n = S.length();
    // binary search, L = repeating string length
    int left = 1, right = n;
    int L;
    while (left <= right) {
      L = left + (right - left) / 2;
      if (search(L, n, S) != -1) left = L + 1;
      else right = L - 1;
    }

    return left - 1;
  }
}
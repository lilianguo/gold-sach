import java.util.Map;
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// 3. Longest Substring Without Repeating Characters
// map 保存char 和 上一个char出现的位置
class LongestSubstringWithoutRepeatingCha {
    public int lengthOfLongestSubstring(String s) { 
        if (s == null || s.length == 0) {
            return 0;
        }
        int start = 0;
        int end = s.length() - 1;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= start) {
                max = Math.max(max, end - start + 1);
                start = map.get(s.charAt(i)) + 1;
                map.put(s.charAt(i), i);
            } else {
                map.put(s.charAt(i), i);
                end = i;
                max = Math.max(max, end - start + 1);
            }
        }
        return max;
    }
}
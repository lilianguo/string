/**
 * 159. Longest Substring with At Most Two Distinct Characters
 * Given a string s, return the length of the longest substring that contains at most two distinct characters.
 *
 * * s consists of English letters.
 * 1 <= s.length <= 105
 */
class Solution {
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    if (s == null) return 0;
    if (s.length() < 3) return s.length();
    int left = 0, right = 0;
    Map<Character, Integer> map = new HashMap<>();
    int max = 0;
    while (right < s.length()) {
      char c = s.charAt(right);
      if (map.containsKey(c) || map.size() < 2) {
        map.put(c, map.getOrDefault(c, 0) + 1);
        max = Math.max(right - left + 1, max);
        right++;
      } else {
        while (map.size() == 2) {
          c = s.charAt(left++);
          if (map.get(c) > 1) {
            map.put(c, map.get(c) - 1);
          } else {
            map.remove(c);
          }
        }
      }
    }
    return max;
  }
}
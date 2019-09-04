class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int max = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
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
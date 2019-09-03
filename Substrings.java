class Substrings {
    // https://www.cnblogs.com/EdwardLiu/p/6177843.html
    // https://leetcode.com/problems/longest-string-chain/discuss/295182/C%2B%2B-Bottom-Up-DP-solution-(with-Explanation)
    // 根据string的长度sort，然后维护每个string的longest chain，default为1，如果删除某个char生成的string能提供更长的chain，则更新
    // Dynamic Programing, using hashmap to save each word maiximum chain length
    /* Sort words according to length
Starting with each word and we derivations all combinations of word that can lead to this word - simply by removing each ith character of word where 0 <= i < word.Length
Now check if curent chain length is more than 1 + previous word chain length, in that case we would update chain length for this current word. It can be stored in dictionary
Update maxChainLength for each word if we find larger chain 
    */
    public int findLongestChain (String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        int longestChain = 0;
        Arrays.sort(words, new Comparator<String>() {
            public int compare (String s1, String s2) {
                return s1.length()  - s2.length();
            }
        });
        Map<String, Integer> map = new Hashmap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                continue;
            }
            map.put(word, 1);
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                String after = sb.toString();
                if (map.containsKey(after) && map.get(after) + 1 > map.get(word)) {
                    map.put(word, map.get(after) + 1);
                }
            }
            if (map.get(word) > longestChain) {
                longestChain = map.get(word);
            }
        }
        return longestChain;
    }

    
}
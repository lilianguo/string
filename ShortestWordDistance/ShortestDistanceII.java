/*
244. Shortest Word Distance II
Design a class which receives a list of words in the constructor, 
and implements a method that takes two words word1 and word2 and 
return the shortest distance between these two words in the list. 
Your method will be called repeatedly many times with different parameters. 

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
Note:
You may assume that word1 does not equal to word2, 
and word1 and word2 are both in the list.

Time: O(n)
Space: O(n)

traverse the list to get a map
and then get subtract of index
note that the index here for each word is sorted by nature(in the order of showance)
*/

class ß {
    Map<String, List<Integer>> locations;
    public ShortestDistanceII(String[] words) {
        this.locations = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            locations.putIfAbsent(words[i], new ArrayList<>());
            locations.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> loc1 = locations.get(word1);
        List<Integer> loc2 = locations.get(word2);
        int l1 = 0;
        int l2 = 0;
        int min = Integer.MAX_VALUE;
        while(l1 < loc1.size() && l2 < loc2.size()) {
            min = Math.min(min, Math.abs(loc1.get(l1) - loc2.get(l2)));
            if (loc1.get(l1) < loc2.get(l2)) {
                l1++;
            } else {
                l2++;
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
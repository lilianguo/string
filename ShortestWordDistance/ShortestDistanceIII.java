/*
245. Shortest Word Distance III

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “makes”, word2 = “coding”
Output: 1
Input: word1 = "makes", word2 = "makes"
Output: 3
Note:
You may assume word1 and word2 are both in the list.

*/
class ShortestDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> locations = createMap(words, word1, word2);
        int min = Integer.MAX_VALUE;
        if (word1.equals(word2)) {
            for (int i = 1; i < locations.get(word1).size(); i++) {
                min = Math.min(min, locations.get(word1).get(i) - locations.get(word1).get(i - 1));
            }
            return min;
        }

        List<Integer> loc1 = locations.get(word1);
        List<Integer> loc2 = locations.get(word2);
        int l1 = 0;
        int l2 = 0;
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

    private Map<String, List<Integer>> createMap(String[] words, String word1, String word2) {
        Map<String, List<Integer>> locations = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (!locations.containsKey(word1)) {
                    locations.put(word1, new ArrayList<>());
                }
                locations.get(word1).add(i);
                continue;
            }
            if (words[i].equals(word2)) {
                if (!locations.containsKey(word2)) {
                    locations.put(word2, new ArrayList<>());
                }
                locations.get(word2).add(i);
                continue;
            }
        }
        return locations;
    }
}
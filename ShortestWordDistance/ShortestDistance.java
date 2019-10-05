
/*
243. Shortest Word Distance

Given a list of words and two words word1 and word2, 
return the shortest distance between these two words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
Space complexity is O(1), since no additional space is allocated.
*/
class ShortestDistance {
    public int shortestDistance(String[] words, String w1, String w2) {
        int idx1 = -1;
        int idx2 = -1;
        int min = words.length;
        int curDis;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(w1)) {
                idx1 = i;
            } else if (words[i].equals(w2)) {
                idx2 = i;
            }
            
            if (idx1 != -1 && idx2 != -1) {
                min = Math.min(min, Math.abs(idx1 - idx2));
            }
        }
        return min;
    }
}
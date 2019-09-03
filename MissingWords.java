class MissingWords {
    public List<String> missingWords (String s, String t) {
        String[] S = s.trim().split(" ");
        String[] T = t.trim().split(" ");
        List<String> res = new ArrayList<>();
        for (int i = 0, j = 0; i < S.length && j < T.length;) {
            if (S[i].equals(T[j])) {
                i++;
                j++;
                continue;
            }
            res.add(S[i]);
            i++;
        }
        return res;
    }
}
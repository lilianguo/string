class LongestAbsoluteFilePath {
    // https://leetcode.com/problems/longest-absolute-file-path/
    // time O(n)
    // space O(n)
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        int res = 0;
        int[] sum = new int[input.length() + 1];
        for (String line : input.split("\n")) {
            // 当前处于第几层， 从第一层开始
            int level = line.lastIndexOf("\t") + 2;
            int len = line.length() - (level - 1);
            if (line.contains(".")) {
                //当前曾有文件，更新max
                res = Math.max(res, sum[level - 1] + len);
            } else {
                // 当前这层没有文件，所以需要加 1 代表“／”
                sum[level] = sum[level - 1] + len + 1;
            }

        }
        return res;
    }
}
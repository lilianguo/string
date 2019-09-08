class MultiplyString {
    public String multiply(String nums1, String nums2) {
        String res = "";
        if (nums1 == null || nums2 == null) {
            return res;
        }
        int m = nums1.length();
        int n = nums2.length();
        int[] nums = new int[m + n];
        for (int i = m - 1; i >=0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int curr = (nums1.charAt(i) - '0') * (nums2.charAt(j) - '0');
                int sum = curr + nums[i + j + 1];
                nums[i + j] += sum/10;
                nums[i + j + 1] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int curr : nums) {
            if (!(curr == 0 && sb.length() == 0))  {
                sb.append(curr);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
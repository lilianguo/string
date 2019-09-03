class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        //先去除原串中所有的'-'并将其全部转为大写。
        //再从后往前每隔k个位置插入一个'-'字符。
        S = S.replaceAll("-", "");
        S = S.toUpperCase();
        StringBuilder sb =  new StringBuilder(S);
        int i = sb.length() - K;
        while (i > 0) {
            sb.insert(i, '-');
            i = i - K;
        }
        return sb.toString();
    }
}
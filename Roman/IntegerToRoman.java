class IntegerToRoman {
    public String intToRoman(int num) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1000);
        nums.add(900);
        nums.add(500);
        nums.add(400);
        nums.add(100);
        nums.add(90);
        nums.add(50);
        nums.add(40);
        nums.add(10);
        nums.add(9);
        nums.add(5);
        nums.add(4);
        nums.add(1);
        Map<Integer, String> map = new HashMap<>();
        map.put(1000, "M");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(400, "CD");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(100, "C");
        map.put(50, "L");
        map.put(10, "X");
        map.put(5, "V");
        map.put(1, "I");
        if (num == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            int cnt = num / list.get(i);
            while(cnt > 0) {
                sb.append(map.get(list.get(i)));
            }
        }
        return sb.toString();
    }

    public static String intToRomanII(int num) {
    String M[] = {"", "M", "MM", "MMM"};
    String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
}

}
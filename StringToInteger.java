class StringToInteger {
    // 8. String to Integer (atoi)
    public int myAtoi(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) {
            return 0;
        }
        String s = str.split(" ")[0];
        int index = 0;
        int sign = 1;
        if (s.charAt(index) == '+') {
            index++;
        } else if (s.charAt(index) == '-') {
            index++;
            sign = -1;
        }
        long num = 0;
        for (; index < s.length(); index++) {
            if (s.charAt(index) < '0' || s.charAt(index) > '9') {
                break;
            }
            num = num * 10 + (s.charAt(index) - '0');
            if (num > Integer.MAX_VALUE) {
                break;
            }
        }

        if (num * sign >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } 
        if (num * sign <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) num * sign;
    }
}
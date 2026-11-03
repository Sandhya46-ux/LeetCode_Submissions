
class Solution {
    public boolean validDigit(int n, int x) {
        String s = String.valueOf(n);
        char digit = (char) (x + '0');

        return s.charAt(0) != digit && s.indexOf(digit, 1) != -1;
    }
}
